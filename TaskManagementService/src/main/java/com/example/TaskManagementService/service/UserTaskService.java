package com.example.TaskManagementService.service;

import com.example.TaskManagementService.domain.User;
import com.example.TaskManagementService.exception.UserNotFoundException;

import java.util.Optional;

public interface UserTaskService {
    User addUser(User user) ;


    User findByemailId(String emailId);

}
