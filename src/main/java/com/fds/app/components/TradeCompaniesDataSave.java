package com.fds.app.components;

import com.fds.app.iexapis.IexapisApiClient;
import com.fds.app.service.TradeCompanyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TradeCompaniesDataSave implements CommandLineRunner {
    private final TradeCompanyDetailsService service;

    @Autowired
    public TradeCompaniesDataSave(TradeCompanyDetailsService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        IexapisApiClient receiver = new IexapisApiClient();
        //List<TradeCompanyDetails> result = detailsReceiver.getAllTradeCompaniesDetails(receiver.getActiveCompanies());
        //service.saveAll(result);
    }
}
