package com.fds.app.components;

import com.fds.app.iexapis.TradeCompaniesReceiver;
import com.fds.app.iexapis.TradeCompanyDetailsReceiver;
import com.fds.app.model.TradeCompanyDetails;
import com.fds.app.service.TradeCompanyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TradeCompaniesDataReceiver implements CommandLineRunner {
    private final TradeCompanyDetailsService service;

    @Autowired
    public TradeCompaniesDataReceiver(TradeCompanyDetailsService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        TradeCompaniesReceiver receiver = new TradeCompaniesReceiver();
        TradeCompanyDetailsReceiver detailsReceiver = new TradeCompanyDetailsReceiver();
        List<TradeCompanyDetails> result = detailsReceiver.getAllTradeCompaniesDetails(receiver.getActiveCompanies());
        service.saveAll(result).get(80);
    }
}
