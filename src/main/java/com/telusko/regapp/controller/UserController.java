package com.telusko.regapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.regapp.User;
import com.telusko.regapp.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {
@Autowired
    private UserService userService;
    private static final Logger logger = LogManager.getLogger(UserController.class);


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        logger.info("Received registration request for email: {}", user.getEmail());
        Optional<User> existingUser = userService.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            logger.warn("Attempt to register with an already registered email: {}", user.getEmail());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email is already registered!");
        }
        userService.registerUser(user);
        logger.info("User registered successfully: {}", user.getEmail());
        return ResponseEntity.ok("User registered successfully!");
    }
}
