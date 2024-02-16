package com.example.TaskManagementService.service;

import com.example.TaskManagementService.domain.Task;
import com.example.TaskManagementService.exception.TaskNotFoundException;
import com.example.TaskManagementService.exception.UserNotFoundException;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    List<Task> getTasksforUser(String emailId) throws UserNotFoundException;
    Task addTask(Task task);
    Task getTaskByName(String taskname) throws TaskNotFoundException;
    boolean deleteTask(String taskId);
    Task updateTaskStatus(String taskId, String status)throws TaskNotFoundException;
}
