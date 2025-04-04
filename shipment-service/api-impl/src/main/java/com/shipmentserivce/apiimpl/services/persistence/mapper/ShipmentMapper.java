package com.shipmentserivce.apiimpl.services.persistence.mapper;

import com.shipmentserivce.apiimpl.services.persistence.model.Shipment;
import com.orderservice.common.model.ShipmentDTO;
import com.shipmentserivce.apiimpl.services.persistence.model.Shipment2;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShipmentMapper {
    ShipmentMapper INSTANCE = Mappers.getMapper(ShipmentMapper.class);
    @Mapping(source = "orderId", target = "orderId")
    @Mapping(source = "shipmentDate", target = "shipmentDate")
    @Mapping(source = "carrier", target = "carrier")
    @Mapping(source = "trackingNumber", target = "trackingNumber")
    @Mapping(source = "shippingStatus", target = "shippingStatus")
    Shipment toEntity(ShipmentDTO shipment1);


    Shipment toEntity2(Shipment2 shipment1);
}
