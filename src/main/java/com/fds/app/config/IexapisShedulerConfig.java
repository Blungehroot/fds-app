package com.fds.app.config;

import com.fds.app.service.TradeCompanyDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Priority;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
public class IexapisShedulerConfig {

    @Autowired
    private TradeCompanyDetailsService service;

//    @Scheduled(cron = "0 */30 * ? * *")
//    public void scheduleDataGather() {
//        log.info("Cron job is started");
//        IexapisApiClient receiver = new IexapisApiClient();
//        service.saveAll(receiver.getAllTradeCompaniesDetails(receiver.getActiveCompanies()));
//        log.info("Cron job is finished");
//    }

    @Scheduled(cron = "0 0/1 * ? * *")
    public void scheduleDataGathers() {
        log.info("Cron job is started");
        log.info("Top highest values stocks companies: ");
        CompaniesStocks stocks = new CompaniesStocks();
        System.out.println(stocks.getTopHighestValueCompaniesStocks(stocks.getAllCompaniesStocks(service.getAll())));
        log.info("Cron job is finished");
    }
}

