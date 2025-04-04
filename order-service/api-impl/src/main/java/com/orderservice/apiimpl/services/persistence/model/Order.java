package com.orderservice.apiimpl.services.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    private String orderId;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "order_date")
    private String orderDate;
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @Column(name = "status")
    private String orderStatus;

}
