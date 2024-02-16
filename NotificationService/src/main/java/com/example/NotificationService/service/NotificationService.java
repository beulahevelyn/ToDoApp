package com.example.NotificationService.service;

import com.example.NotificationService.config.TaskDTO;
import com.example.NotificationService.domain.Notification;

public interface NotificationService {
    Notification getAllNotifications(String emailId);
    void saveNotifications(TaskDTO taskDTO);
}
