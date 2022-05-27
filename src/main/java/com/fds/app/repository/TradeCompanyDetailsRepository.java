package com.fds.app.repository;

import com.fds.app.model.TradeCompanyDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TradeCompanyDetailsRepository extends MongoRepository<TradeCompanyDetails, String> {
}
