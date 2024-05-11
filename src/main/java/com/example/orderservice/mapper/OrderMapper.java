package com.example.orderservice.mapper;


import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = org.mapstruct.InjectionStrategy.CONSTRUCTOR)
public interface OrderMapper {
    OrderDto toDto(Order order);

    Order toEntity(OrderDto orderDto);
}
