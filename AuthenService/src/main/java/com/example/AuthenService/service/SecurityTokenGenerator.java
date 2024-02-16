package com.example.AuthenService.service;

import com.example.AuthenService.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(User user);
}
