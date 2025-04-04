package com.orderservice.common.model;

import com.orderservice.common.enums.NotificationMethod;
import com.orderservice.common.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private UUID orderId;
    private String customerName;
    private String orderDate;
    private BigDecimal totalAmount;
    private OrderStatus status;
    private String email;
    private String phoneNumber;
    private NotificationMethod notificationMethod;
}
