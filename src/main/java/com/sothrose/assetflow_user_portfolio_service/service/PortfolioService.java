package com.sothrose.assetflow_user_portfolio_service.service;

import static java.lang.String.format;

import com.sothrose.assetflow_user_portfolio_service.exception.UserNotFoundException;
import com.sothrose.assetflow_user_portfolio_service.model.PortfolioDto;
import com.sothrose.assetflow_user_portfolio_service.model.User;
import com.sothrose.assetflow_user_portfolio_service.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PortfolioService {

  private final UserRepository userRepository;

  public void addNewPortfolioToUser(PortfolioDto portfolioDto) {
    var user = fetchUserById(portfolioDto.getUserId());
    user.addPortfolio(portfolioDto.toPortfolio(user));
    userRepository.save(user);
  }

  public void removePortfolioFromUser(Long userId, Long portfolioId) {
    var user = fetchUserById(userId);
    user.removePortfolio(portfolioId);
    userRepository.save(user);
  }

  public List<PortfolioDto> fetchAllUserPortfolios(Long userId) {
    return fetchUserById(userId).getPortfolios().stream().map(PortfolioDto::from).toList();
  }

  private User fetchUserById(Long userId) {
    var userOpt = userRepository.findById(userId);
    if (userOpt.isEmpty()) {
      throw new UserNotFoundException(format("User with id: [%s] not found", userId));
    }

    return userOpt.get();
  }
}
