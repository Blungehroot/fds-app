package com.fds.app.repository;

import com.fds.app.model.TradeCompanyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeCompanyDetailsRepository extends JpaRepository<TradeCompanyDetails, Long> {
}
