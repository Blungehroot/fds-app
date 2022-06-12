package com.fds.app.service;

import com.fds.app.model.TradeCompanyDetails;
import com.fds.app.repository.TradeCompanyDetailsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TradeCompanyDetailsServiceImpl implements TradeCompanyDetailsService {

    private final TradeCompanyDetailsRepository tradeCompanyDetailsRepository;


    public TradeCompanyDetailsServiceImpl(TradeCompanyDetailsRepository tradeCompanyDetailsRepository) {
        this.tradeCompanyDetailsRepository = tradeCompanyDetailsRepository;
    }

    @Override
    public List<TradeCompanyDetails> saveAll(Set<TradeCompanyDetails> tradeCompanyDetails) {
        List<TradeCompanyDetails> list = new ArrayList<>(tradeCompanyDetails);
        return tradeCompanyDetailsRepository.saveAll(list);
    }

    @Override
    public List<TradeCompanyDetails> getAll() {
        return tradeCompanyDetailsRepository.findAll();
    }
}
