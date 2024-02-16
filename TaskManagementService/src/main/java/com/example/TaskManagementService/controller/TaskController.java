package com.example.TaskManagementService.controller;

import com.example.TaskManagementService.domain.Task;
import com.example.TaskManagementService.domain.User;
import com.example.TaskManagementService.exception.TaskNotFoundException;
import com.example.TaskManagementService.exception.UserNotFoundException;
import com.example.TaskManagementService.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/tasksRepo")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {
    private final TaskService taskService;
    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/getAllTasks")
    public ResponseEntity<?> getAllTasks(){
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/getTaskByName/{taskName}")
    public ResponseEntity<?> getTaskByName(@PathVariable String taskName) throws TaskNotFoundException {
        return new ResponseEntity<>(taskService.getTaskByName(taskName),HttpStatus.OK);
    }

    @GetMapping("/getTasksforUser/{emailId}")
    public ResponseEntity<?> getTasksforUser(@PathVariable String emailId) throws UserNotFoundException {
        return new ResponseEntity<>(taskService.getTasksforUser(emailId),HttpStatus.OK);
    }

    @PostMapping("/addNewTask")
    public ResponseEntity<?> addTask(@RequestBody Task task){
        return new ResponseEntity<>(taskService.addTask(task),HttpStatus.OK);
    }

    @PutMapping("/updateTaskStatus/{taskId}")
    public ResponseEntity<?> updateTaskStatus(@PathVariable String taskId, @RequestBody String status) throws TaskNotFoundException {
        return new ResponseEntity<>(taskService.updateTaskStatus(taskId,status),HttpStatus.OK);
    }

    @DeleteMapping("/deleteTask/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable String taskId){
        return new ResponseEntity<>(taskService.deleteTask(taskId),HttpStatus.OK);
    }
}
