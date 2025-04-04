package com.notificationservice.api.service;

import com.orderservice.common.model.NotificationDTO;

public interface RSocketNotificationClientAPI {
    void sendNotification(NotificationDTO notification);
}
