package com.fds.app.iexapis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fds.app.model.TradeCompany;
import com.fds.app.model.TradeCompanyDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class IexapisApiClient {
    private static final String IEXAPIS_GET_COMPANIES_URL = "https://sandbox.iexapis.com/stable/ref-data/symbols?token=Tpk_ee567917a6b640bb8602834c9d30e571";
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper om = new ObjectMapper();
    private static final String IEXAPIS_GET_COMPANY_DETAIL_URL = "https://sandbox.iexapis.com/stable/stock/%s/quote?token=Tpk_ee567917a6b640bb8602834c9d30e571";


    private List<TradeCompany> getTradeCompanies() {
        ResponseEntity<Object[]> response = restTemplate.getForEntity(IEXAPIS_GET_COMPANIES_URL, Object[].class);

        return Arrays.stream(response.getBody())
                .map(o -> om.convertValue(o, TradeCompany.class))
                .collect(Collectors.toList());
    }

    public List<TradeCompany> getActiveCompanies() {
        List<TradeCompany> list = getTradeCompanies()
                .stream()
                .filter(c -> c.getIsEnabled().equals("true")).limit(10)
                .collect(Collectors.toList());

        return list;
    }

    public TradeCompanyDetails getInfo(String companySymbol) {
        String companyUrl = String.format(IEXAPIS_GET_COMPANY_DETAIL_URL, companySymbol);
        ResponseEntity<TradeCompanyDetails> response = restTemplate.getForEntity(companyUrl, TradeCompanyDetails.class);
        return om.convertValue(response.getBody(), TradeCompanyDetails.class);
    }

    public List<TradeCompanyDetails> getAllTradeCompaniesDetails(List<TradeCompany> tradeCompanies) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<TradeCompanyDetails> list = new CopyOnWriteArrayList<>();

        Callable<List<TradeCompanyDetails>> callable = () -> {
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
        List<Callable<List<TradeCompanyDetails>>> callableTasks = new ArrayList<>();
        for (int i = 0; i < tradeCompanies.size(); i++) {
            callableTasks.add(callable);
        }

        executorService.submit(callable);
        executorService.shutdown();
        return list;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        IexapisApiClient receiver = new IexapisApiClient();


        System.out.println(receiver.getAllTradeCompaniesDetails(receiver.getActiveCompanies()).size());
    }
}
