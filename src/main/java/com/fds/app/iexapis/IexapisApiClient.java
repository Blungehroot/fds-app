package com.fds.app.iexapis;

import com.fds.app.config.FdsFactoryConfig;
import com.fds.app.model.TradeCompany;
import com.fds.app.model.TradeCompanyDetails;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.concurrent.*;
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
                .collect(Collectors.toList());

        return list;
    }

    public TradeCompanyDetails getInfo(String companySymbol) throws ExecutionException, InterruptedException {
        String companyUrl = String.format(IEXAPIS_GET_COMPANY_DETAIL_URL, companySymbol);
        return CompletableFuture.completedFuture(fdsFactoryConfig.restTemplate().getForEntity(companyUrl, TradeCompanyDetails.class).getBody()).get();
    }

    public Set<TradeCompanyDetails> getAllTradeCompaniesDetails(List<TradeCompany> tradeCompanies) {
        Set<TradeCompanyDetails> list = new CopyOnWriteArraySet<>();

        ExecutorService executorService = fdsFactoryConfig.executorService();
        Queue<TradeCompany> queue = new LinkedList<>(tradeCompanies);

        while (!queue.isEmpty()) {
            TradeCompany company = queue.remove();
            CompletableFuture.supplyAsync(() -> {
                try {
                    list.add(getInfo(company.getSymbol()));
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
                return list;
            }, executorService);
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(240, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        return list;
    }
}
