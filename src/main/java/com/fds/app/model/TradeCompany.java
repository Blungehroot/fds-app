package com.fds.app.model;

import javax.persistence.Entity;

@Entity
public class TradeCompany {
    private String symbol;
    private String exchange;
    private String exchangeSuffix;
    private String exchangeName;
    private String exchangeSegment;
    private String exchangeSegmentName;
    private String name;
    private String date;
    private String type;
    private String iexId;
    private String region;
    private String currency;
    private boolean isEnabled;
    private String figi;
    private String cik;
    private String lei;
}
