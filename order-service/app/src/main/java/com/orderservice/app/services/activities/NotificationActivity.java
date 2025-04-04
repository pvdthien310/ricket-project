package com.orderservice.app.services.activities;

import com.orderservice.common.model.OrderDTO;
import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface NotificationActivity {
    void sendNotification(OrderDTO orderDTO);
}
