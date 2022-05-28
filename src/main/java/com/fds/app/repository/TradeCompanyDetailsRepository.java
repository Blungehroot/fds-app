package com.fds.app.repository;

import com.fds.app.model.TradeCompanyDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeCompanyDetailsRepository extends MongoRepository<TradeCompanyDetails, String> {
}
