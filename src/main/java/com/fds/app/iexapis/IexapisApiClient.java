package com.fds.app.iexapis;

import com.fds.app.config.FdsFactoryConfig;
import com.fds.app.model.TradeCompany;
import com.fds.app.model.TradeCompanyDetails;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class IexapisApiClient {
    private static final String IEXAPIS_GET_COMPANY_DETAIL_URL = "https://sandbox.iexapis.com/stable/stock/%s/quote?token=Tpk_ee567917a6b640bb8602834c9d30e571";
    private static final String IEXAPIS_GET_COMPANIES_URL = "https://sandbox.iexapis.com/stable/ref-data/symbols?token=Tpk_ee567917a6b640bb8602834c9d30e571";
    private final FdsFactoryConfig fdsFactoryConfig = new FdsFactoryConfig();

    private List<TradeCompany> getTradeCompanies() {
        return Arrays.stream(fdsFactoryConfig
                        .restTemplate()
                        .getForEntity(IEXAPIS_GET_COMPANIES_URL, Object[].class)
                        .getBody())
                .map(o -> fdsFactoryConfig.objectMapper().convertValue(o, TradeCompany.class))
                .collect(Collectors.toList());
    }

    public List<TradeCompany> getActiveCompanies() {
        List<TradeCompany> list = getTradeCompanies()
                .stream()
                .filter(c -> c.getIsEnabled().equals("true"))
                .limit(1000)
                .collect(Collectors.toList());

        return list;
    }

    public TradeCompanyDetails getInfo(String companySymbol) throws ExecutionException, InterruptedException {
        String companyUrl = String.format(IEXAPIS_GET_COMPANY_DETAIL_URL, companySymbol);
        return CompletableFuture.completedFuture(fdsFactoryConfig.restTemplate().getForEntity(companyUrl, TradeCompanyDetails.class).getBody()).get();
    }

    public Set<TradeCompanyDetails> getAllTradeCompaniesDetails(List<TradeCompany> tradeCompanies) throws InterruptedException {
        Set<TradeCompanyDetails> list = new CopyOnWriteArraySet<>();

        Callable<Set<TradeCompanyDetails>> callable = () -> {
            while (!tradeCompanies.isEmpty()) {
                tradeCompanies.forEach(c -> {
                    try {
                        tradeCompanies.remove(c);
                        Thread.sleep(800);
                        list.add(getInfo(c.getSymbol()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            return list;
        };

        List<Callable<Set<TradeCompanyDetails>>> callableTasks = new ArrayList<>();
        for (int i = 0; i < tradeCompanies.size(); i++) {
            callableTasks.add(callable);
        }

        fdsFactoryConfig.executorService().invokeAll(callableTasks);
        fdsFactoryConfig.executorService().shutdown();
        return list;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        IexapisApiClient receiver = new IexapisApiClient();
        List<TradeCompany> list = receiver.getActiveCompanies();

        System.out.println(receiver.getAllTradeCompaniesDetails(list).size());
    }
}
