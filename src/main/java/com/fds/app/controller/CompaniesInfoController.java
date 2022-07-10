package com.fds.app.controller;

import com.fds.app.component.CompaniesStocks;
import com.fds.app.service.TradeCompanyDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/companies-info/")
public class CompaniesInfoController {
    private final TradeCompanyDetailsService service;

    public CompaniesInfoController(TradeCompanyDetailsService service) {
        this.service = service;
    }

    @GetMapping(value = "top-high-companies")
    public ResponseEntity<?> topHighCompanies() {
        CompaniesStocks stocks = new CompaniesStocks();
        return ResponseEntity.ok(stocks.getTopHighestValueCompaniesStocks(stocks.getAllCompaniesStocks(service.getAll())));
    }

    @GetMapping(value = "top-greatest-change-companies")
    public ResponseEntity<?> topGreatChanges() {
        CompaniesStocks stocks = new CompaniesStocks();
        return ResponseEntity.ok(stocks.getTopGreatestChangeCompanies(stocks.getAllCompaniesStocks(service.getAll())));
    }

}
