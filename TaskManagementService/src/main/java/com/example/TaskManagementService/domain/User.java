package com.example.TaskManagementService.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data
@Document(collection = "users")
public class User {



    @Id
    private String emailId;


    private List<Task> tasks;

    public User(String emailId, List<Task> tasks) {
        this.emailId = emailId;
        this.tasks = tasks;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "User{" +
                "emailId='" + emailId + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
