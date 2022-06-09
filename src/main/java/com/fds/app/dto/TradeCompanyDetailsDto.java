package com.fds.app.dto;

import com.fds.app.model.TradeCompanyDetails;
import lombok.Data;

@Data
public class TradeCompanyDetailsDto {
    private String symbol;
    private Double latestPrice;
    private String companyName;
    private String volume;
    private Integer previousVolume;

    public static TradeCompanyDetailsDto fromTradeCompanyDetails(TradeCompanyDetails tradeCompanyDetails) {
        TradeCompanyDetailsDto tradeCompanyDetailsDto = new TradeCompanyDetailsDto();
        tradeCompanyDetailsDto.setSymbol(tradeCompanyDetails.getSymbol());
        tradeCompanyDetailsDto.setLatestPrice(tradeCompanyDetails.getLatestPrice());
        tradeCompanyDetailsDto.setCompanyName(tradeCompanyDetails.getCompanyName());
        tradeCompanyDetailsDto.setVolume(tradeCompanyDetails.getVolume());
        tradeCompanyDetailsDto.setPreviousVolume(tradeCompanyDetails.getPreviousVolume());

        return tradeCompanyDetailsDto;
    }
}
