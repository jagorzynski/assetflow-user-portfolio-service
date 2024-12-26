package com.sothrose.assetflow_user_portfolio_service.model;

import static com.google.common.collect.Lists.newArrayList;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
  @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
  private Long userId;

  private String username;
  private String firstName;
  private String lastName;
  private String email;
  private LocalDate birthday;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "user_id")
  private List<Portfolio> portfolios;

  public User(
      String username, String firstName, String lastName, String email, LocalDate birthday) {
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.birthday = birthday;
    this.portfolios = newArrayList();
  }

  public void addPortfolio(Portfolio portfolio) {
    portfolios.add(portfolio);
  }

  public void removePortfolio(Long portfolioId) {
    portfolios.removeIf(portfolio -> portfolio.getPortfolioId().equals(portfolioId));
  }
}
