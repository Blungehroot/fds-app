package com.fds.app.config;

import com.fds.app.dto.TradeCompanyDetailsDto;
import com.fds.app.model.TradeCompanyDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class CompaniesStocks {

    public List<TradeCompanyDetailsDto> getAllCompaniesStocks(List<TradeCompanyDetails> details) {
        List<TradeCompanyDetailsDto> companiesList = new ArrayList<>();
        details.forEach(c -> companiesList.add(TradeCompanyDetailsDto.fromTradeCompanyDetails(c)));

        return companiesList;
    }

    public List<TradeCompanyDetailsDto> getTopHighestValueCompaniesStocks(List<TradeCompanyDetailsDto> companiesList) {
        List<TradeCompanyDetailsDto> topHighestValueCompaniesList = new ArrayList<>();

        return topHighestValueCompaniesList;
    }
}
