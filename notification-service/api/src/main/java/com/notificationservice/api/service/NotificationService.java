package com.notificationservice.api.service;


import com.orderservice.common.model.NotificationDTO;

public interface NotificationService {
    String sendNotification(NotificationDTO notification);
}
