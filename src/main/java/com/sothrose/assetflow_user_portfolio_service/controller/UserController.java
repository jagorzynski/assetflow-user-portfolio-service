package com.sothrose.assetflow_user_portfolio_service.controller;

import com.sothrose.assetflow_user_portfolio_service.model.UserDto;
import com.sothrose.assetflow_user_portfolio_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/assetflow/users")
public class UserController {

    private final UserService userService;

    @PostMapping(consumes = "application/json")
    public void saveUser(@RequestBody UserDto useDto) {
        userService.saveUser(useDto);
    }

    @GetMapping(path = "/{userId}", produces = "application/json")
    public UserDto getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping(produces = "application/json")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping(path = "/{userId}")
    public void deleteUserById(@PathVariable Long userId) {
        userService.deleteUserById(userId);
    }

}
