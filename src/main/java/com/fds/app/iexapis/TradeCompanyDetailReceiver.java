package com.fds.app.iexapis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fds.app.model.TradeCompany;
import com.fds.app.model.TradeCompanyDetails;
import com.fds.app.service.TradeCompanyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class TradeCompanyDetailReceiver {
    private static final String IEXAPIS_GET_COMPANY_DETAIL_URL = "https://sandbox.iexapis.com/stable/stock/%s/quote?token=Tpk_ee567917a6b640bb8602834c9d30e571";
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper om = new ObjectMapper();

    @Autowired
    private TradeCompanyDetailsService service;

    public TradeCompanyDetails getInfo(String companySymbol) {
        String companyUrl = String.format(IEXAPIS_GET_COMPANY_DETAIL_URL, companySymbol);
        ResponseEntity<TradeCompanyDetails> response = restTemplate.getForEntity(companyUrl, TradeCompanyDetails.class);
        return om.convertValue(response.getBody(), TradeCompanyDetails.class);
    }

    public List<TradeCompanyDetails> getAllTradeCompaniesDetails(List<TradeCompany> tradeCompanies) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<TradeCompanyDetails> list = new CopyOnWriteArrayList<>();

        Callable<List<TradeCompanyDetails>> callable = () -> {
            while (!tradeCompanies.isEmpty()) {
                tradeCompanies.forEach(c -> {
                    try {
                        tradeCompanies.remove(c);
                        Thread.sleep(800);
                        list.add(getInfo(c.getSymbol()));
                    } catch (InterruptedException e) {
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

        executorService.invokeAll(callableTasks);
        executorService.shutdown();
        return list;
    }

    public void saveAllTradeCompaniesDetails(List<TradeCompanyDetails> tradeCompanyDetailsList) {
        service.saveAll(tradeCompanyDetailsList);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TradeCompanyDetailReceiver tradeCompanyDetailReceiver = new TradeCompanyDetailReceiver();
        TradeCompaniesReceiver tradeCompaniesReceiver = new TradeCompaniesReceiver();

        List<TradeCompanyDetails> list = tradeCompanyDetailReceiver.getAllTradeCompaniesDetails(tradeCompaniesReceiver.getActiveCompanies());
        System.out.println(list.stream().distinct().collect(Collectors.toList()).size());
    }
}
