package com.sothrose.assetflow_user_portfolio_service.repository;

import com.sothrose.assetflow_user_portfolio_service.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {}
