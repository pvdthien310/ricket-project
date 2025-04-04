package com.orderservice.app.temporal.syncoders.impl;


import com.notificationservice.api.service.RSocketNotificationClientAPI;
import com.orderservice.app.services.activities.NotificationActivity;
import com.orderservice.common.model.NotificationDTO;
import com.orderservice.common.model.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@RequiredArgsConstructor
public class NotificationActivityImpl implements NotificationActivity {

    private final RSocketNotificationClientAPI rSocketNotificationClientAPI;

    @Override
    public void sendNotification(OrderDTO orderDTO) {
        String body = MessageFormat.format("Subject: {0} {1}", orderDTO.getOrderId(), orderDTO.getNotificationMethod().name());
        String subject = MessageFormat.format("Vietcombank Thông báo biến động số dư tài khoản của quý khách", orderDTO.getCustomerName(), orderDTO.getOrderId());
        NotificationDTO notificationDTO = new NotificationDTO(orderDTO.getEmail(), subject, body, orderDTO.getNotificationMethod());
        rSocketNotificationClientAPI.sendNotification(notificationDTO);
        System.out.println("NotificationActivityImpl " + orderDTO);
    }
}
