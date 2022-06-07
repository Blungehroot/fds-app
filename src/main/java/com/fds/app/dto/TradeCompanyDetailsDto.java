package com.fds.app.dto;

import com.fds.app.model.TradeCompanyDetails;
import lombok.Data;

@Data
public class TradeCompanyDetailsDto {
    private String symbol;
    private Double change;
    private Double changePercent;
    private String companyName;
    private String volume;
    private Integer previousVolume;

    public static TradeCompanyDetailsDto fromTradeCompanyDetails(TradeCompanyDetails tradeCompanyDetails) {
        TradeCompanyDetailsDto tradeCompanyDetailsDto = new TradeCompanyDetailsDto();
        tradeCompanyDetailsDto.setSymbol(tradeCompanyDetails.getSymbol());
        tradeCompanyDetailsDto.setChange(tradeCompanyDetails.getChange());
        tradeCompanyDetailsDto.setChangePercent(tradeCompanyDetails.getChangePercent());
        tradeCompanyDetailsDto.setCompanyName(tradeCompanyDetails.getCompanyName());
        tradeCompanyDetailsDto.setVolume(tradeCompanyDetails.getVolume());
        tradeCompanyDetailsDto.setPreviousVolume(tradeCompanyDetails.getPreviousVolume());

        return tradeCompanyDetailsDto;
    }
}
