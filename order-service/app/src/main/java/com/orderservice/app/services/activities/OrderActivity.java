package com.orderservice.app.services.activities;

import com.orderservice.common.model.OrderDTO;
import io.temporal.activity.ActivityInterface;

import java.util.UUID;

@ActivityInterface
public interface OrderActivity {
    UUID insertOrder(OrderDTO order);
}
