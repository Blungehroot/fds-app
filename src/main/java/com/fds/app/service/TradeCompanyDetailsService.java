package com.fds.app.service;

import com.fds.app.model.TradeCompanyDetails;

import java.util.List;
import java.util.Set;

public interface TradeCompanyDetailsService {
    List<TradeCompanyDetails> saveAll(Set<TradeCompanyDetails> tradeCompanyDetails);

    List<TradeCompanyDetails> getAll();
}
