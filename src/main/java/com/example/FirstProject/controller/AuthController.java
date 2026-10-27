package com.example.FirstProject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @PostMapping("/register")
    public String registerUser(@RequestBody Map<String, String> body) {

    }


    @PostMapping("/login")
    public String loginUser(@RequestBody Map<String, String> body) {

    }
}