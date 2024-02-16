package com.example.UserService.service;

import com.example.UserService.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(User user);
}
