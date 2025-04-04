package com.orderservice.apiimpl.services.persistence;

import com.orderservice.apiimpl.services.persistence.model.Order;
import com.orderservice.common.model.OrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
