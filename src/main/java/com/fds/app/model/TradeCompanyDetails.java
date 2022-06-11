package com.fds.app.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "trade_companies")
public class TradeCompanyDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int avgTotalVolume;
    private String calculationPrice;
    private double change;
    private double changePercent;
    private int close;
    private String closeSource;
    private String closeTime;
    private String companyName;
    private String currency;
    private String delayedPrice;
    private String delayedPriceTime;
    private String extendedChange;
    private String extendedChangePercent;
    private String extendedPrice;
    private String extendedPriceTime;
    private int high;
    private String highSource;
    private String highTime;
    private double iexAskPrice;
    private int iexAskSize;
    private int iexBidPrice;
    private int iexBidSize;
    private double iexClose;
    private long iexCloseTime;
    private long iexLastUpdated;
    private double iexMarketPercent;
    private double iexOpen;
    private long iexOpenTime;
    private double iexRealtimePrice;
    private int iexRealtimeSize;
    private int iexVolume;
    private long lastTradeTime;
    private double latestPrice;
    private String latestSource;
    private String latestTime;
    private long latestUpdate;
    private String latestVolume;
    private int low;
    private String lowSource;
    private long lowTime;
    private long marketCap;
    private String oddLotDelayedPrice;
    private String oddLotDelayedPriceTime;
    private int open;
    private String openTime;
    private String openSource;
    private double peRatio;
    private double previousClose;
    private int previousVolume;
    private String primaryExchange;
    private String symbol;
    private String volume;
    private double week52High;
    private double week52Low;
    private double ytdChange;
    private boolean isUSMarketOpen;
}
