package com.example.TaskManagementService.repository;

import com.example.TaskManagementService.domain.Task;
import com.example.TaskManagementService.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task,String> {
    Task findByTaskName (String taskName);
    List<Task> findByUser(User user);
}
