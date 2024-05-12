package com.example.orderservice.mapper;


import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = org.mapstruct.InjectionStrategy.CONSTRUCTOR,
        uses = {OrderItemMapper.class})
public interface OrderMapper {
    @Mapping(target = "items", qualifiedByName = "mapOrderItemsToDtos")
    OrderDto toDto(Order order);

    @Mapping(target = "items", qualifiedByName = "mapOrderItemDtosToEntities")
    Order toEntity(OrderDto orderDto);


}
