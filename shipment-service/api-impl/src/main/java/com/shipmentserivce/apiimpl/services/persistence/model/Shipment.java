package com.shipmentserivce.apiimpl.services.persistence.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
//@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shipment")
public class Shipment {
    @Id
    private String orderId;
    @Column(name = "shipment_date", nullable = false)
    private String shipmentDate;
    @Column(name= "carrier")
    private String carrier;
    @Column(name="tracking_number")
    private String trackingNumber;
    @Column(name = "status")
    private String shippingStatus;
}
