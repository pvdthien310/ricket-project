package com.shipmentserivce.app.controller.adapters;

import com.orderservice.common.model.ShipmentDTO;
import com.shipmentserivce.api.ShipmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ShipmentAdapter {

    private final ShipmentService shipmentService;

    @MessageMapping("shipment")
    public String shipment(ShipmentDTO shipmentDTO) {
        log.info("Shipment received: {}", shipmentDTO);
        shipmentService.insertShipment(shipmentDTO);
        return "OK";
    }
}
