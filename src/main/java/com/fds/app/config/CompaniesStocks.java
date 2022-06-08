package com.fds.app.config;

import com.fds.app.dto.TradeCompanyDetailsDto;
import com.fds.app.model.TradeCompanyDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class CompaniesStocks {

    public List<TradeCompanyDetailsDto> getAllCompaniesStocks(List<TradeCompanyDetails> details) {
        List<TradeCompanyDetailsDto> companiesList = new ArrayList<>();
        details.forEach(c -> companiesList.add(TradeCompanyDetailsDto.fromTradeCompanyDetails(c)));

        return companiesList;
    }

    public List<TradeCompanyDetailsDto> getTopHighestValueCompaniesStocks(List<TradeCompanyDetailsDto> companiesList) {
        companiesList.sort((c1, c2) -> {
            if (c1.getVolume() == null || c2.getVolume() == null) {
                return c2.getPreviousVolume().compareTo(c1.getPreviousVolume());
            } else {
                return Integer.compare(Integer.parseInt(c2.getVolume()), Integer.parseInt(c1.getVolume()));
            }
        });

        return companiesList.stream().limit(5).collect(Collectors.toList());

    }

    /*public List<TradeCompanyDetailsDto> getTopGreatestChangePercentCompanies(List<TradeCompanyDetailsDto> companiesList) {

    }*/
}

