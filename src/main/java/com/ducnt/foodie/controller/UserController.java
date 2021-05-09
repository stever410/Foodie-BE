package com.ducnt.foodie.controller;

import com.ducnt.foodie.dto.SignupDto;
import com.ducnt.foodie.model.User;
import com.ducnt.foodie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Validated @RequestBody SignupDto request) {
        return userService.addNewUser(request);
    }
}
