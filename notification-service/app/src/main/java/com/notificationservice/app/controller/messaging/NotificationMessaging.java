package com.notificationservice.app.controller.messaging;

import com.notificationservice.api.service.NotificationService;
import com.orderservice.common.model.NotificationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class NotificationMessaging {

    private final NotificationService notificationService;

    @MessageMapping("send-notification")
    public void sendNotification(NotificationDTO notification) {
        notificationService.sendNotification(notification);
    }


}
