package com.shipmentserivce.apiimpl.services.impl;

import com.orderservice.common.model.ShipmentDTO;
import com.shipmentserivce.api.RSocketShipmentClientApi;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RSocketShipmentClientApiImpl implements RSocketShipmentClientApi {

    private final RSocketRequester shipmentRSocketRequester;

    @Override
    public void sendShipment(ShipmentDTO shipmentDTO) {
        shipmentRSocketRequester.route("shipment").data(shipmentDTO)
                .retrieveMono(String.class).block();
    }
}
