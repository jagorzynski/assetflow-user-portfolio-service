package com.sothrose.assetflow_user_portfolio_service.service;

import com.sothrose.assetflow_user_portfolio_service.model.UserDto;
import com.sothrose.assetflow_user_portfolio_service.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

  private final UserRepository userRepository;

  public void saveUser(UserDto useDto) {
    userRepository.save(useDto.toUser());
  }

  public UserDto getUserById(Long userId) {
    return userRepository.findById(userId).map(UserDto::from).orElse(null);
  }

  public List<UserDto> getAllUsers() {
    return userRepository.findAll().stream().map(UserDto::from).toList();
  }

  public void deleteUserById(Long userId) {
    userRepository.deleteById(userId);
  }
}
