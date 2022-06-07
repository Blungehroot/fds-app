package com.fds.app.config;

import com.fds.app.iexapis.IexapisApiClient;
import com.fds.app.service.TradeCompanyDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
public class IexapisShedulerConfig {

    @Autowired
    private TradeCompanyDetailsService service;

    @Scheduled(cron = "0 */30 * ? * *")
    public void scheduleDataGather() {
        log.info("Cron job is started");
        IexapisApiClient receiver = new IexapisApiClient();
        service.saveAll(receiver.getAllTradeCompaniesDetails(receiver.getActiveCompanies()));
        log.info("Cron job is finished");
    }
}
