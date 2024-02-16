package com.example.TaskManagementService.service;

import com.example.TaskManagementService.domain.User;
import com.example.TaskManagementService.exception.UserNotFoundException;
import com.example.TaskManagementService.repository.UserTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserTaskServiceImpl implements UserTaskService{
    private final UserTaskRepository userTaskRepository;
    @Autowired
    public UserTaskServiceImpl(UserTaskRepository userTaskRepository) {
        this.userTaskRepository = userTaskRepository;
    }

    @Override
    public User addUser(User user) {
        return userTaskRepository.save(user);

    }

    @Override
    public User findByemailId(String emailId) {
        return userTaskRepository.findByemailId(emailId);
    }




}
