package com.sothrose.assetflow_user_portfolio_service.model;

import java.time.LocalDate;
import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
  private String username;
  private String firstName;
  private String lastName;
  private String email;
  private LocalDate birthday;

  public static UserDto from(User user) {
    return new UserDto(
        user.getUsername(),
        user.getFirstName(),
        user.getLastName(),
        user.getEmail(),
        user.getBirthday());
  }

  public User toUser() {
    return new User(username, firstName, lastName, email, birthday);
  }
}
