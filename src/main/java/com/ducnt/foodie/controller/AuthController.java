package com.ducnt.foodie.controller;

import com.ducnt.foodie.dto.LoginRequest;
import com.ducnt.foodie.dto.SignupRequest;
import com.ducnt.foodie.service.AuthService;
import com.ducnt.foodie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class AuthController {

    AuthService authService;
    UserService userService;

    @Autowired
    public AuthController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.authenticateUser(request));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Validated @RequestBody SignupRequest request) {
        return ResponseEntity.ok(userService.addNewUser(request));
    }
}
