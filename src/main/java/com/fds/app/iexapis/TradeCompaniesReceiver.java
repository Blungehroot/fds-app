package com.fds.app.iexapis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fds.app.model.TradeCompany;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TradeCompaniesReceiver {
    private static final String IEXAPIS_GET_COMPANIES_URL = "https://sandbox.iexapis.com/stable/ref-data/symbols?token=Tpk_ee567917a6b640bb8602834c9d30e571";
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper om = new ObjectMapper();

    public List<TradeCompany> getTradeCompanies() {
        ResponseEntity<Object[]> response = restTemplate.getForEntity(IEXAPIS_GET_COMPANIES_URL, Object[].class);

        return Arrays.stream(response.getBody())
                .map(o -> om.convertValue(o, TradeCompany.class))
                .collect(Collectors.toList());
    }

    public List<TradeCompany> getActiveCompanies() {
        List<TradeCompany> list = getTradeCompanies()
                .stream()
                .filter(c -> c.getIsEnabled().equals("true"))
                .collect(Collectors.toList());

        return list;
    }
}
