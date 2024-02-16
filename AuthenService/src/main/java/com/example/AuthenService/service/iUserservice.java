package com.example.AuthenService.service;

import com.example.AuthenService.domain.User;
import com.example.AuthenService.exception.UserNotFoundException;

import java.util.List;


public interface iUserservice {
User saveUser(User user);
List<User> getAllUsers();
User updateUser (User user, String email);
boolean deleteUserByEmail(String email);
List<User> findByName (String name);
User login(User user) throws UserNotFoundException;
}
