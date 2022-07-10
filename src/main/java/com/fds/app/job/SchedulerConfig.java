package com.fds.app.job;

import com.fds.app.component.CompaniesStocks;
import com.fds.app.iexapis.IexapisApiClient;
import com.fds.app.service.TradeCompanyDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@RequiredArgsConstructor
@Slf4j
@Configuration
public class SchedulerConfig {

    private final TradeCompanyDetailsService service;

    @Scheduled(cron = "0 * */12 ? * *")
    public void scheduleDataGather() {
        log.info("Cron job is started");
        IexapisApiClient receiver = new IexapisApiClient();
        service.saveAll(receiver.getAllTradeCompaniesDetails(receiver.getActiveCompanies()));
        log.info("Cron job is finished");
   }

    @Scheduled(cron = "0 0/10 */12 ? * *")
    public void scheduleTopCompaniesMonitoring() {
        log.info("Top highest values stocks companies:");
        CompaniesStocks stocks = new CompaniesStocks();
        System.out.println(stocks.getTopHighestValueCompaniesStocks(stocks.getAllCompaniesStocks(service.getAll())));
        log.info("Top greatest change in companies:");
        System.out.println(stocks.getTopGreatestChangeCompanies(stocks.getAllCompaniesStocks(service.getAll())));
    }
}

