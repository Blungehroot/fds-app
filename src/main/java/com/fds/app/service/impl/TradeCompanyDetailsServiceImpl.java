package com.fds.app.service.impl;

import com.fds.app.model.TradeCompanyDetails;
import com.fds.app.repository.TradeCompanyDetailsRepository;
import com.fds.app.service.TradeCompanyDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
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
        List<TradeCompanyDetails> current = tradeCompanyDetailsRepository.findAll();

        for (TradeCompanyDetails updatedCompany:tradeCompanyDetails) {
            for (TradeCompanyDetails currentCompany:current) {
                if (updatedCompany.getSymbol().equals(currentCompany.getSymbol()))
                    tradeCompanyDetails.remove(updatedCompany);
            }
        }

        return tradeCompanyDetailsRepository.saveAll(tradeCompanyDetails);
    }

    @Override
    public List<TradeCompanyDetails> getAll() {
        return tradeCompanyDetailsRepository.findAll();
    }
}