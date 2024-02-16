package com.example.NotificationService.service;

import com.example.NotificationService.config.TaskDTO;
import com.example.NotificationService.domain.Notification;
import com.example.NotificationService.repository.NotificationRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService{
    private final NotificationRepository notificationRepository;
    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification getAllNotifications(String emailId) {
        return notificationRepository.findById(emailId).get();
    }

    @RabbitListener(queues = "task.queue")
    @Override
    public void saveNotifications(TaskDTO taskDTO) {
        Notification notification = new Notification();
        String emailId = taskDTO.getJsonObject().get("emailId").toString();
        if(notificationRepository.findById(emailId).isEmpty()){
            notification.setEmailId(emailId);
        }
        notification.setNotificationMessage("The list of unseen tasks - ");
        notification.setTaskNames(taskDTO.getJsonObject());
        notificationRepository.save(notification);
    }
}
