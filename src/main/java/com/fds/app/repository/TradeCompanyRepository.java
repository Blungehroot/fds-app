package com.fds.app.repository;

import com.fds.app.model.TradeCompany;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TradeCompanyRepository extends MongoRepository<TradeCompany, String> {
}
