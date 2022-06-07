package com.fds.app.dto;

import com.fds.app.model.TradeCompanyDetails;
import lombok.Data;

@Data
public class CompanyDetailsDto {
    private String symbol;
    private Double change;
    private Double changePercent;
    private String companyName;
    private String volume;
    private Integer previousVolume;

    public static CompanyDetailsDto fromTradeCompanyDetails(TradeCompanyDetails tradeCompanyDetails) {
        CompanyDetailsDto companyDetailsDto = new CompanyDetailsDto();
        companyDetailsDto.setSymbol(tradeCompanyDetails.getSymbol());
        companyDetailsDto.setChange(tradeCompanyDetails.getChange());
        companyDetailsDto.setChangePercent(tradeCompanyDetails.getChangePercent());
        companyDetailsDto.setCompanyName(tradeCompanyDetails.getCompanyName());
        companyDetailsDto.setVolume(tradeCompanyDetails.getVolume());
        companyDetailsDto.setPreviousVolume(tradeCompanyDetails.getPreviousVolume());

        return companyDetailsDto;
    }
}
