package com.fds.app.service;

import com.fds.app.model.TradeCompanyDetails;
import com.fds.app.repository.TradeCompanyDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TradeCompanyDetailsService {
    @Autowired
    TradeCompanyDetailsRepository tradeCompanyDetailsRepository;

    public List<TradeCompanyDetails> saveAll(List<TradeCompanyDetails> tradeCompanyDetails) {
        return tradeCompanyDetailsRepository.saveAll(tradeCompanyDetails);
    }
}
