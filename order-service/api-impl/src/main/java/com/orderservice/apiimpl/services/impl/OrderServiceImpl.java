package com.orderservice.apiimpl.services.impl;

import com.orderservice.api.services.OrderService;
import com.orderservice.apiimpl.services.persistence.OrderRepository;
import com.orderservice.apiimpl.services.persistence.mapper.OrderMapper;
import com.orderservice.apiimpl.services.persistence.model.Order;
import com.orderservice.common.model.OrderDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public UUID insertOrder(OrderDTO order) {
        order.setOrderId(UUID.randomUUID());
        Order newEntity = OrderMapper.INSTANCE.convertOrderDtoToOrder(order);
        orderRepository.save(newEntity);
        log.info("Order added: " + newEntity.getOrderId().toString());
        return order.getOrderId();
    }
}
