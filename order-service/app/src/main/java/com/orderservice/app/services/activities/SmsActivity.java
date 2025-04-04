package com.orderservice.app.services.activities;

import com.orderservice.common.model.OrderDTO;
import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface SmsActivity {
    void sendSms(OrderDTO orderDTO);
}
