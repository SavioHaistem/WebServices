package com.udemy.websevices.controllers;

import com.udemy.websevices.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @GetMapping
    public ResponseEntity<User> getUser() {
        User user = new User(1, "Leo", "0800", "entre.vaicachorra", "minhasenha.fuleira");
        return ResponseEntity.ok().body(user);
    }
}
