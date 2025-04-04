package com.orderservice.api.services;

import com.orderservice.common.model.OrderDTO;

import java.util.UUID;

public interface OrderService {
    UUID insertOrder(OrderDTO order);
}
