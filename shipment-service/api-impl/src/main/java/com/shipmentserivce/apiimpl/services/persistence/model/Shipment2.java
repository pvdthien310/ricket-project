package com.shipmentserivce.apiimpl.services.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shipment2 {
    private String orderId;
    private String shipmentDate;
    private String carrier;
    private String trackingNumber;
    private String shippingStatus;
}
