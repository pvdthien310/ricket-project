package com.orderservice.apiimpl.services.persistence.mapper;

import com.orderservice.apiimpl.services.persistence.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.orderservice.common.model.OrderDTO;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "status", target = "orderStatus")
    Order convertOrderDtoToOrder(OrderDTO orderDto);


}
