package com.example.NotificationService.controller;

import com.example.NotificationService.service.NotificationService;
import io.jsonwebtoken.Claims;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/notification")
@RestController
public class NotificationController {
    private final NotificationService notificationService;
    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/notifications")
    public ResponseEntity<?> notifications(HttpServletRequest request){
        Claims claims = (Claims) request.getAttribute("claims");
        String emailId = claims.getSubject();
        return new ResponseEntity<>(notificationService.getAllNotifications(emailId), HttpStatus.OK);
    }
}
