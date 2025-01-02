package com.sothrose.assetflow_user_portfolio_service.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.sothrose.assetflow_user_portfolio_service.model.PortfolioDto;
import com.sothrose.assetflow_user_portfolio_service.service.PortfolioService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/assetflow/portfolios")
public class PortfolioController {

  private final PortfolioService portfolioService;

  @PostMapping(consumes = APPLICATION_JSON_VALUE)
  public void savePortfolio(@RequestBody PortfolioDto portfolioDto) {
    portfolioService.addNewPortfolioToUser(portfolioDto);
  }

  @GetMapping(path = "/{userId}", produces = APPLICATION_JSON_VALUE)
  public List<PortfolioDto> getAllUserPortfolios(@PathVariable Long userId) {
    return portfolioService.fetchAllUserPortfolios(userId);
  }

  @DeleteMapping
  public void deleteUserPortfolio(@RequestParam Long userId, @RequestParam Long portfolioId) {
    portfolioService.removePortfolioFromUser(userId, portfolioId);
  }
}
