package com.sothrose.assetflow_user_portfolio_service.model;

import java.math.BigDecimal;
import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PortfolioDto {
  private Long userId;
  private AssetType assetType;
  private String assetName;
  private String currency;
  private BigDecimal quantity;
  private BigDecimal purchasePrice;

  public static PortfolioDto from(Portfolio portfolio) {
    return new PortfolioDto(
        portfolio.getUser().getUserId(),
        portfolio.getAssetType(),
        portfolio.getAssetName(),
        portfolio.getCurrency(),
        portfolio.getQuantity(),
        portfolio.getPurchasePrice());
  }

  public Portfolio toPortfolio(User user) {
    return new Portfolio(user, assetType, assetName, currency, quantity, purchasePrice);
  }
}
