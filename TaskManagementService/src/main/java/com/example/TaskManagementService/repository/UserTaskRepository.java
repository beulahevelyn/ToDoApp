package com.example.TaskManagementService.repository;

import com.example.TaskManagementService.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTaskRepository extends MongoRepository<User,Integer> {
    User findByemailId (String emailId);
}
