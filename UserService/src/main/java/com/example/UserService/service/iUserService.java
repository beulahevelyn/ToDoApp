package com.example.UserService.service;

import com.example.UserService.domain.Address;
import com.example.UserService.domain.StarredTasks;
import com.example.UserService.domain.User;
import com.example.UserService.exception.StarredTaskNotFoundException;
import com.example.UserService.exception.UserAlreadyExistException;
import com.example.UserService.exception.UserNotFoundException;

import java.util.List;

public interface iUserService {

    User register (User user) throws UserAlreadyExistException;
    List<User> getallUsers();
    User updateUser(String email, User user) throws UserNotFoundException;
    User deleteUser(String email) throws UserNotFoundException;

    User addStarred(String email, StarredTasks starredTask) throws UserNotFoundException;
    User deleteStarred(String email, StarredTasks starredTask) throws UserNotFoundException;
    List<StarredTasks> getStarredTasksByStatus (String email) throws StarredTaskNotFoundException, UserNotFoundException;

    User editAddress(String email, Address address) throws UserNotFoundException;
    User deleteAddress(String email) throws UserNotFoundException;

}
