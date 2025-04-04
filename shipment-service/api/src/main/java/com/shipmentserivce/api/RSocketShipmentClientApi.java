package com.shipmentserivce.api;

import com.orderservice.common.model.ShipmentDTO;

public interface RSocketShipmentClientApi {
    void sendShipment(ShipmentDTO shipmentDTO);
}
