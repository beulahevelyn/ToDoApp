package com.example.TaskManagementService.controller;

import com.example.TaskManagementService.domain.Task;
import com.example.TaskManagementService.domain.User;
import com.example.TaskManagementService.exception.UserAlreadyExistsException;
import com.example.TaskManagementService.exception.UserNotFoundException;
import com.example.TaskManagementService.service.TaskService;
import com.example.TaskManagementService.service.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/task")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserTaskController {
    private final UserTaskService userTaskService;
    private final TaskService taskService;
    @Autowired
    public UserTaskController(UserTaskService userTaskService, TaskService taskService) {
        this.taskService=taskService;
        this.userTaskService = userTaskService;
    }

    @PostMapping("/addnewuser")
    public ResponseEntity<?> addUser(@RequestBody User user) throws UserAlreadyExistsException {
    if(userTaskService.findByemailId(user.getEmailId())!=null){
        User dbuser = userTaskService.findByemailId(user.getEmailId());
        for (Task task : user.getTasks()) {
            taskService.addTask(task) ;
        }

    } else {
        userTaskService.addUser(user);
        for (Task task : user.getTasks()) {
            taskService.addTask(task) ;
        }
    }

        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/getUserTasks/{emailid}")
    public ResponseEntity<?> getUserTasks(@PathVariable String emailid) throws UserNotFoundException {

        return new ResponseEntity<>(userTaskService.findByemailId(emailid),HttpStatus.OK);

    }
}
