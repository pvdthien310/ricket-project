package com.shipmentserivce.api;

import com.orderservice.common.model.ShipmentDTO;

public interface ShipmentService {
    void insertShipment(ShipmentDTO shipmentDTO);
}
