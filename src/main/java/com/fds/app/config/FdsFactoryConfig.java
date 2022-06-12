package com.fds.app.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fds.app.repository.TradeCompanyDetailsRepository;
import com.fds.app.service.TradeCompanyDetailsService;
import com.fds.app.service.TradeCompanyDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class FdsFactoryConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public ExecutorService executorService() {
        return Executors.newFixedThreadPool(10);
    }
}
