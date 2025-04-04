package com.orderservice.app.temporal.syncoders.impl;

import com.orderservice.app.services.activities.SmsActivity;
import com.orderservice.common.model.OrderDTO;
import org.springframework.stereotype.Component;

@Component
public class SmsActivityImpl implements SmsActivity {

    @Override
    public void sendSms(OrderDTO orderDTO) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("SmsActivityImpl " + orderDTO.toString());
    }
}
