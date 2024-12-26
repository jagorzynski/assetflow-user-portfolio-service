package com.sothrose.assetflow_user_portfolio_service.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

  public Portfolio(
      User user,
      AssetType assetType,
      String assetName,
      String currency,
      BigDecimal quantity,
      BigDecimal purchasePrice) {
    this.user = user;
    this.assetType = assetType;
    this.assetName = assetName;
    this.currency = currency;
    this.quantity = quantity;
    this.purchasePrice = purchasePrice;
  }
}
