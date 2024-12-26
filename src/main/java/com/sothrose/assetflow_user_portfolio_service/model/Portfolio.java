package com.sothrose.assetflow_user_portfolio_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "portfolios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Portfolio {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "portfolio_seq")
  @SequenceGenerator(name = "portfolio_seq", sequenceName = "portfolio_seq", allocationSize = 1)
  private Long portfolioId;

  @ManyToOne private User user;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private AssetType assetType;

  @Column(nullable = false)
  private String assetName;

  @Column(nullable = false)
  private String currency;

  @Column(nullable = false)
  private BigDecimal quantity;

  @Column(nullable = false)
  private BigDecimal purchasePrice;
}
