package com.orderservice.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class  ShipmentDTO  {
    private String orderId;
    private String shipmentDate;
    private String carrier;
    private String trackingNumber;
    private String shippingStatus;
}
