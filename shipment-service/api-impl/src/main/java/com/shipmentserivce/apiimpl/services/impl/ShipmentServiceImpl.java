package com.shipmentserivce.apiimpl.services.impl;

import com.shipmentserivce.apiimpl.services.persistence.ShipmentRepository;
import com.shipmentserivce.apiimpl.services.persistence.mapper.ShipmentMapper;
import com.shipmentserivce.apiimpl.services.persistence.model.Shipment;
import com.orderservice.common.model.ShipmentDTO;
import com.shipmentserivce.api.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Override
    public void insertShipment(ShipmentDTO shipmentDTO) {
        Shipment shipment = ShipmentMapper.INSTANCE.toEntity(shipmentDTO);
        shipmentRepository.save(shipment);
    }
}
