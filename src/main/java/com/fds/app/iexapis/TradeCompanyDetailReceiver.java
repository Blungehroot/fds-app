package com.fds.app.iexapis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fds.app.model.TradeCompanyDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TradeCompanyDetailReceiver {
    private static final String IEXAPIS_GET_COMPANY_DETAIL_URL = "https://sandbox.iexapis.com/stable/stock/%s/quote?token=Tpk_ee567917a6b640bb8602834c9d30e571";
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper om = new ObjectMapper();

    public TradeCompanyDetails getInfo(String companySymbol) {
        String companyUrl = String.format(IEXAPIS_GET_COMPANY_DETAIL_URL, companySymbol);
        ResponseEntity<TradeCompanyDetails> response = restTemplate.getForEntity(companyUrl, TradeCompanyDetails.class);
        return om.convertValue(response.getBody(), TradeCompanyDetails.class);
    }
}
