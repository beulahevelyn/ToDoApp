package com.example.TaskManagementService.service;

import com.example.TaskManagementService.domain.Task;
import com.example.TaskManagementService.domain.User;
import com.example.TaskManagementService.exception.TaskNotFoundException;
import com.example.TaskManagementService.exception.UserNotFoundException;
import com.example.TaskManagementService.repository.TaskRepository;
import com.example.TaskManagementService.repository.UserTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;
    private UserTaskRepository userTaskRepository;
    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, UserTaskRepository userTaskRepository) {
        this.userTaskRepository=userTaskRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }




    public List<Task> getTasksforUser(String emailId) throws UserNotFoundException {
      User user =  userTaskRepository.findByemailId(emailId);

        if (user != null) {
            return taskRepository.findByUser(user);
        } else {
            // handle user not found

            return Collections.emptyList();
        }

    }

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskByName(String taskName) throws TaskNotFoundException {
        if(taskRepository.findByTaskName(taskName)!=null){
            System.out.println(taskRepository.findByTaskName(taskName));
            throw new TaskNotFoundException();

        }
        return taskRepository.findByTaskName(taskName);
    }

    @Override
    public boolean deleteTask(String taskId){
        taskRepository.deleteById(taskId);
        return true;
    }

    @Override
    public Task updateTaskStatus(String taskId, String status)  throws TaskNotFoundException {

        Task taskIdInRepo = taskRepository.findById(taskId).get();
        if (taskIdInRepo != null) {
            taskIdInRepo.setStatus(status);
        } else {
            throw new TaskNotFoundException();
        }

            return taskRepository.save(taskIdInRepo);



    }
}
