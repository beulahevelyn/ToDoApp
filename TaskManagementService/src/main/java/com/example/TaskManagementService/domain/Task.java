package com.example.TaskManagementService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Task {
    @Id
    @Generated
    private String taskId;
    private String taskName;
    private String assignee;
    private Date dueDate;
    private String status;
    private String comments;
    private Boolean starred;
    @DBRef
    private User user;


}
