package com.sothrose.assetflow_user_portfolio_service.repository;

import com.sothrose.assetflow_user_portfolio_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
