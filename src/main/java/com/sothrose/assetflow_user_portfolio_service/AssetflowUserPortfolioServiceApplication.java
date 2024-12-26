package com.sothrose.assetflow_user_portfolio_service;

import static com.sothrose.assetflow_user_portfolio_service.model.AssetType.CRYPTO;
import static java.util.Arrays.asList;

import com.sothrose.assetflow_user_portfolio_service.model.Portfolio;
import com.sothrose.assetflow_user_portfolio_service.model.User;
import com.sothrose.assetflow_user_portfolio_service.repository.UserRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AssetflowUserPortfolioServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(AssetflowUserPortfolioServiceApplication.class, args);
  }

  @Bean
  public ApplicationRunner applicationRunner(UserRepository userRepository) {
    return args -> {
      var user1 =
          User.builder()
              .username("john_doe")
              .firstName("John")
              .lastName("Doe")
              .email("john.doe@example.com")
              .birthday(LocalDate.of(1990, 5, 15))
              .build();

      var user2 =
          User.builder()
              .username("jane_smith")
              .firstName("Jane")
              .lastName("Smith")
              .email("jane.smith@example.com")
              .birthday(LocalDate.of(1985, 11, 25))
              .build();

      userRepository.saveAll(asList(user1, user2));

      var portfolio1 =
          Portfolio.builder()
              .user(user1)
              .assetType(CRYPTO)
              .assetName("BTC")
              .currency("USDT")
              .quantity(new BigDecimal("0.02567890"))
              .purchasePrice(new BigDecimal("30000.00"))
              .build();

      var portfolio2 =
          Portfolio.builder()
              .user(user1)
              .assetType(CRYPTO)
              .assetName("ETH")
              .currency("USDT")
              .quantity(new BigDecimal("2.34123"))
              .purchasePrice(new BigDecimal("2500.00"))
              .build();

      var portfolio3 =
          Portfolio.builder()
              .user(user2)
              .assetType(CRYPTO)
              .assetName("LTC")
              .currency("USDT")
              .quantity(new BigDecimal("50.12345"))
              .purchasePrice(new BigDecimal("200.00"))
              .build();

      user1.setPortfolios(asList(portfolio1, portfolio2));
      user2.setPortfolios(asList(portfolio3));
    };
  }
}
