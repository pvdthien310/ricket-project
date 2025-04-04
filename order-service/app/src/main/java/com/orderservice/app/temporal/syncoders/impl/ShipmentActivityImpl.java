package com.orderservice.app.temporal.syncoders.impl;

import com.orderservice.app.services.activities.ShipmentActivity;
import com.orderservice.common.model.OrderDTO;
import com.orderservice.common.model.ShipmentDTO;
import com.shipmentserivce.api.RSocketShipmentClientApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class ShipmentActivityImpl implements ShipmentActivity {

    private final RSocketShipmentClientApi rSocketShipmentClientApi;

    @Override
    public void triggerDelivery(OrderDTO orderDTO) {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        ShipmentDTO shipmentDTO =
                ShipmentDTO.builder()
                        .orderId(orderDTO.getOrderId().toString())
                        .shipmentDate(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
                        .carrier("GHTK")
                        .shippingStatus("PENDING")
                        .trackingNumber(String.valueOf(Math.random()))
                        .build();
        rSocketShipmentClientApi.sendShipment(shipmentDTO);
    }
}
