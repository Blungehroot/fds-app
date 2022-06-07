package com.fds.app.service;

import com.fds.app.model.TradeCompanyDetails;
import com.fds.app.repository.TradeCompanyDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TradeCompanyDetailsService {

    private final TradeCompanyDetailsRepository tradeCompanyDetailsRepository;

    @Autowired
    public TradeCompanyDetailsService(TradeCompanyDetailsRepository tradeCompanyDetailsRepository) {
        this.tradeCompanyDetailsRepository = tradeCompanyDetailsRepository;
    }

    public List<TradeCompanyDetails> saveAll(Set<TradeCompanyDetails> tradeCompanyDetails) {
        List<TradeCompanyDetails> list = new ArrayList<>(tradeCompanyDetails);
        return tradeCompanyDetailsRepository.saveAll(list);
    }
}
