package com.orderservice.app.temporal.syncoders.impl;

import com.orderservice.api.services.OrderService;
import com.orderservice.app.services.activities.OrderActivity;
import com.orderservice.common.model.OrderDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Slf4j
@Component
@RequiredArgsConstructor
public class OrderActivityImpl implements OrderActivity {

    private final OrderService orderService;

    @Override
    public UUID insertOrder(OrderDTO order) {
       return orderService.insertOrder(order);
    }
}
