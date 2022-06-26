package com.fds.app.service;

import com.fds.app.model.TradeCompanyDetails;
import com.fds.app.repository.TradeCompanyDetailsRepository;
import com.fds.app.service.impl.TradeCompanyDetailsServiceImpl;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Tag("unit")
@ExtendWith(MockitoExtension.class)
class TradeCompanyDetailsTests {
    @Mock
    private TradeCompanyDetailsRepository repository;

    @InjectMocks
    private TradeCompanyDetailsServiceImpl service;

    @Test
    void saveAllTradeCompanies_shouldBeSuccess() {
        List<TradeCompanyDetails> tradeCompanyDetailsList = new ArrayList<>();

        TradeCompanyDetails tradeCompanyDetails = new TradeCompanyDetails();
        tradeCompanyDetails.setId(1L);
        tradeCompanyDetails.setAvgTotalVolume(32099686);
        tradeCompanyDetails.setCalculationPrice("close");
        tradeCompanyDetails.setChange(9.03);
        tradeCompanyDetails.setChangePercent(0.03531);
        tradeCompanyDetails.setClose(274);
        tradeCompanyDetails.setCloseSource("foicialf");
        tradeCompanyDetails.setCloseTime("22 june");
        tradeCompanyDetails.setCompanyName("Str");
        tradeCompanyDetails.setCurrency("USD");
        tradeCompanyDetails.setDelayedPrice("2322");
        tradeCompanyDetails.setDelayedPriceTime("222");
        tradeCompanyDetails.setExtendedChange("2322");
        tradeCompanyDetails.setExtendedChangePercent("1222");
        tradeCompanyDetails.setExtendedPrice("2111");
        tradeCompanyDetails.setExtendedPriceTime(null);
        tradeCompanyDetails.setHigh(1222);
        tradeCompanyDetails.setHighSource("21122");
        tradeCompanyDetails.setHighTime("2322");
        tradeCompanyDetails.setIexAskPrice(23.2);
        tradeCompanyDetails.setIexAskSize(112);
        tradeCompanyDetails.setIexBidPrice(22);
        tradeCompanyDetails.setIexBidSize(12);
        tradeCompanyDetails.setIexClose(12.1);
        tradeCompanyDetails.setIexCloseTime(1232321);
        tradeCompanyDetails.setIexLastUpdated(122211);
        tradeCompanyDetails.setIexMarketPercent(11);
        tradeCompanyDetails.setIexOpen(122.11);
        tradeCompanyDetails.setIexOpenTime(21221);
        tradeCompanyDetails.setIexRealtimePrice(2221.1);
        tradeCompanyDetails.setIexRealtimeSize(2221);
        tradeCompanyDetails.setIexVolume(333);
        tradeCompanyDetails.setLastTradeTime(122222);
        tradeCompanyDetails.setLatestPrice(2223.3);
        tradeCompanyDetails.setLatestSource("2333");
        tradeCompanyDetails.setLatestTime("1122");
        tradeCompanyDetails.setLatestUpdate(122313);
        tradeCompanyDetails.setLatestVolume("12121121");
        tradeCompanyDetails.setLow(233);
        tradeCompanyDetails.setLowSource("121");
        tradeCompanyDetails.setLowTime(212112);
        tradeCompanyDetails.setMarketCap(4434334);
        tradeCompanyDetails.setOddLotDelayedPrice("121211");
        tradeCompanyDetails.setOddLotDelayedPriceTime("122222");
        tradeCompanyDetails.setOpen(1222);
        tradeCompanyDetails.setOpenTime("12121");
        tradeCompanyDetails.setOpenSource("232111");
        tradeCompanyDetails.setPeRatio(44.3);
        tradeCompanyDetails.setPreviousClose(1122.22);
        tradeCompanyDetails.setPreviousVolume(1222);
        tradeCompanyDetails.setPrimaryExchange("232221");
        tradeCompanyDetails.setSymbol("Test");
        tradeCompanyDetails.setVolume("12dsds");
        tradeCompanyDetails.setWeek52High(334.4);
        tradeCompanyDetails.setWeek52Low(232.2);
        tradeCompanyDetails.setYtdChange(44.32);
        tradeCompanyDetails.setUSMarketOpen(false);

        TradeCompanyDetails tradeCompanyDetails1 = new TradeCompanyDetails();
        tradeCompanyDetails1.setId(2L);
        tradeCompanyDetails1.setAvgTotalVolume(320996862);
        tradeCompanyDetails1.setCalculationPrice("close");
        tradeCompanyDetails1.setChange(9.03);
        tradeCompanyDetails1.setChangePercent(0.03531);
        tradeCompanyDetails1.setClose(274);
        tradeCompanyDetails1.setCloseSource("foicialf");
        tradeCompanyDetails1.setCloseTime("22 june");
        tradeCompanyDetails1.setCompanyName("Str");
        tradeCompanyDetails1.setCurrency("USD");
        tradeCompanyDetails1.setDelayedPrice("2322");
        tradeCompanyDetails1.setDelayedPriceTime("222");
        tradeCompanyDetails1.setExtendedChange("2322");
        tradeCompanyDetails1.setExtendedChangePercent("1222");
        tradeCompanyDetails1.setExtendedPrice("2111");
        tradeCompanyDetails.setExtendedPriceTime(null);
        tradeCompanyDetails1.setHigh(1222);
        tradeCompanyDetails1.setHighSource("21122");
        tradeCompanyDetails1.setHighTime("2322");
        tradeCompanyDetails1.setIexAskPrice(23.2);
        tradeCompanyDetails1.setIexAskSize(112);
        tradeCompanyDetails1.setIexBidPrice(22);
        tradeCompanyDetails1.setIexBidSize(12);
        tradeCompanyDetails1.setIexClose(12.1);
        tradeCompanyDetails1.setIexCloseTime(1232321);
        tradeCompanyDetails1.setIexLastUpdated(122211);
        tradeCompanyDetails1.setIexMarketPercent(11);
        tradeCompanyDetails1.setIexOpen(122.11);
        tradeCompanyDetails1.setIexOpenTime(21221);
        tradeCompanyDetails1.setIexRealtimePrice(2221.1);
        tradeCompanyDetails1.setIexRealtimeSize(2221);
        tradeCompanyDetails1.setIexVolume(333);
        tradeCompanyDetails1.setLastTradeTime(122222);
        tradeCompanyDetails1.setLatestPrice(2223.3);
        tradeCompanyDetails1.setLatestSource("2333");
        tradeCompanyDetails1.setLatestTime("1122");
        tradeCompanyDetails1.setLatestUpdate(122313);
        tradeCompanyDetails1.setLatestVolume("12121121");
        tradeCompanyDetails1.setLow(233);
        tradeCompanyDetails1.setLowSource("121");
        tradeCompanyDetails1.setLowTime(212112);
        tradeCompanyDetails1.setMarketCap(4434334);
        tradeCompanyDetails1.setOddLotDelayedPrice("121211");
        tradeCompanyDetails1.setOddLotDelayedPriceTime("122222");
        tradeCompanyDetails1.setOpen(1222);
        tradeCompanyDetails1.setOpenTime("12121");
        tradeCompanyDetails1.setOpenSource("232111");
        tradeCompanyDetails1.setPeRatio(44.3);
        tradeCompanyDetails1.setPreviousClose(1122.22);
        tradeCompanyDetails1.setPreviousVolume(1222);
        tradeCompanyDetails1.setPrimaryExchange("232221");
        tradeCompanyDetails1.setSymbol("2TEST");
        tradeCompanyDetails1.setVolume("12dsds");
        tradeCompanyDetails1.setWeek52High(334.4);
        tradeCompanyDetails1.setWeek52Low(232.2);
        tradeCompanyDetails1.setYtdChange(44.32);
        tradeCompanyDetails1.setUSMarketOpen(false);

        tradeCompanyDetailsList.add(tradeCompanyDetails);
        tradeCompanyDetailsList.add(tradeCompanyDetails1);

        lenient().when(repository.saveAll(tradeCompanyDetailsList)).thenReturn(tradeCompanyDetailsList);

        Set<TradeCompanyDetails> actualList = new HashSet<>(tradeCompanyDetailsList);
        service.saveAll(actualList);

        verify(repository).saveAll(actualList);
    }

    @Test
    void getAllTradeCompanies_shouldBeSuccess() {
        List<TradeCompanyDetails> tradeCompanyDetailsList = new ArrayList<>();

        TradeCompanyDetails tradeCompanyDetails = new TradeCompanyDetails();
        tradeCompanyDetails.setId(1L);
        tradeCompanyDetails.setAvgTotalVolume(32099686);
        tradeCompanyDetails.setCalculationPrice("close");
        tradeCompanyDetails.setChange(9.03);
        tradeCompanyDetails.setChangePercent(0.03531);
        tradeCompanyDetails.setClose(274);
        tradeCompanyDetails.setCloseSource("foicialf");
        tradeCompanyDetails.setCloseTime("22 june");
        tradeCompanyDetails.setCompanyName("Str");
        tradeCompanyDetails.setCurrency("USD");
        tradeCompanyDetails.setDelayedPrice("2322");
        tradeCompanyDetails.setDelayedPriceTime("222");
        tradeCompanyDetails.setExtendedChange("2322");
        tradeCompanyDetails.setExtendedChangePercent("1222");
        tradeCompanyDetails.setExtendedPrice("2111");
        tradeCompanyDetails.setExtendedPriceTime(null);
        tradeCompanyDetails.setHigh(1222);
        tradeCompanyDetails.setHighSource("21122");
        tradeCompanyDetails.setHighTime("2322");
        tradeCompanyDetails.setIexAskPrice(23.2);
        tradeCompanyDetails.setIexAskSize(112);
        tradeCompanyDetails.setIexBidPrice(22);
        tradeCompanyDetails.setIexBidSize(12);
        tradeCompanyDetails.setIexClose(12.1);
        tradeCompanyDetails.setIexCloseTime(1232321);
        tradeCompanyDetails.setIexLastUpdated(122211);
        tradeCompanyDetails.setIexMarketPercent(11);
        tradeCompanyDetails.setIexOpen(122.11);
        tradeCompanyDetails.setIexOpenTime(21221);
        tradeCompanyDetails.setIexRealtimePrice(2221.1);
        tradeCompanyDetails.setIexRealtimeSize(2221);
        tradeCompanyDetails.setIexVolume(333);
        tradeCompanyDetails.setLastTradeTime(122222);
        tradeCompanyDetails.setLatestPrice(2223.3);
        tradeCompanyDetails.setLatestSource("2333");
        tradeCompanyDetails.setLatestTime("1122");
        tradeCompanyDetails.setLatestUpdate(122313);
        tradeCompanyDetails.setLatestVolume("12121121");
        tradeCompanyDetails.setLow(233);
        tradeCompanyDetails.setLowSource("121");
        tradeCompanyDetails.setLowTime(212112);
        tradeCompanyDetails.setMarketCap(4434334);
        tradeCompanyDetails.setOddLotDelayedPrice("121211");
        tradeCompanyDetails.setOddLotDelayedPriceTime("122222");
        tradeCompanyDetails.setOpen(1222);
        tradeCompanyDetails.setOpenTime("12121");
        tradeCompanyDetails.setOpenSource("232111");
        tradeCompanyDetails.setPeRatio(44.3);
        tradeCompanyDetails.setPreviousClose(1122.22);
        tradeCompanyDetails.setPreviousVolume(1222);
        tradeCompanyDetails.setPrimaryExchange("232221");
        tradeCompanyDetails.setSymbol("Test");
        tradeCompanyDetails.setVolume("12dsds");
        tradeCompanyDetails.setWeek52High(334.4);
        tradeCompanyDetails.setWeek52Low(232.2);
        tradeCompanyDetails.setYtdChange(44.32);
        tradeCompanyDetails.setUSMarketOpen(false);

        TradeCompanyDetails tradeCompanyDetails1 = new TradeCompanyDetails();
        tradeCompanyDetails1.setId(2L);
        tradeCompanyDetails1.setAvgTotalVolume(320996862);
        tradeCompanyDetails1.setCalculationPrice("close");
        tradeCompanyDetails1.setChange(9.03);
        tradeCompanyDetails1.setChangePercent(0.03531);
        tradeCompanyDetails1.setClose(274);
        tradeCompanyDetails1.setCloseSource("foicialf");
        tradeCompanyDetails1.setCloseTime("22 june");
        tradeCompanyDetails1.setCompanyName("Str");
        tradeCompanyDetails1.setCurrency("USD");
        tradeCompanyDetails1.setDelayedPrice("2322");
        tradeCompanyDetails1.setDelayedPriceTime("222");
        tradeCompanyDetails1.setExtendedChange("2322");
        tradeCompanyDetails1.setExtendedChangePercent("1222");
        tradeCompanyDetails1.setExtendedPrice("2111");
        tradeCompanyDetails.setExtendedPriceTime(null);
        tradeCompanyDetails1.setHigh(1222);
        tradeCompanyDetails1.setHighSource("21122");
        tradeCompanyDetails1.setHighTime("2322");
        tradeCompanyDetails1.setIexAskPrice(23.2);
        tradeCompanyDetails1.setIexAskSize(112);
        tradeCompanyDetails1.setIexBidPrice(22);
        tradeCompanyDetails1.setIexBidSize(12);
        tradeCompanyDetails1.setIexClose(12.1);
        tradeCompanyDetails1.setIexCloseTime(1232321);
        tradeCompanyDetails1.setIexLastUpdated(122211);
        tradeCompanyDetails1.setIexMarketPercent(11);
        tradeCompanyDetails1.setIexOpen(122.11);
        tradeCompanyDetails1.setIexOpenTime(21221);
        tradeCompanyDetails1.setIexRealtimePrice(2221.1);
        tradeCompanyDetails1.setIexRealtimeSize(2221);
        tradeCompanyDetails1.setIexVolume(333);
        tradeCompanyDetails1.setLastTradeTime(122222);
        tradeCompanyDetails1.setLatestPrice(2223.3);
        tradeCompanyDetails1.setLatestSource("2333");
        tradeCompanyDetails1.setLatestTime("1122");
        tradeCompanyDetails1.setLatestUpdate(122313);
        tradeCompanyDetails1.setLatestVolume("12121121");
        tradeCompanyDetails1.setLow(233);
        tradeCompanyDetails1.setLowSource("121");
        tradeCompanyDetails1.setLowTime(212112);
        tradeCompanyDetails1.setMarketCap(4434334);
        tradeCompanyDetails1.setOddLotDelayedPrice("121211");
        tradeCompanyDetails1.setOddLotDelayedPriceTime("122222");
        tradeCompanyDetails1.setOpen(1222);
        tradeCompanyDetails1.setOpenTime("12121");
        tradeCompanyDetails1.setOpenSource("232111");
        tradeCompanyDetails1.setPeRatio(44.3);
        tradeCompanyDetails1.setPreviousClose(1122.22);
        tradeCompanyDetails1.setPreviousVolume(1222);
        tradeCompanyDetails1.setPrimaryExchange("232221");
        tradeCompanyDetails1.setSymbol("2TEST");
        tradeCompanyDetails1.setVolume("12dsds");
        tradeCompanyDetails1.setWeek52High(334.4);
        tradeCompanyDetails1.setWeek52Low(232.2);
        tradeCompanyDetails1.setYtdChange(44.32);
        tradeCompanyDetails1.setUSMarketOpen(false);

        tradeCompanyDetailsList.add(tradeCompanyDetails);
        tradeCompanyDetailsList.add(tradeCompanyDetails1);

        lenient().when(repository.findAll()).thenReturn(tradeCompanyDetailsList);

        assertNotNull(service.getAll());

        verify(repository).findAll();
    }
}
