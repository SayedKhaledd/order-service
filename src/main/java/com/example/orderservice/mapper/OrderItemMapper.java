package com.example.orderservice.mapper;

import com.example.orderservice.dto.OrderItemDto;
import com.example.orderservice.model.OrderItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = org.mapstruct.InjectionStrategy.CONSTRUCTOR)
public interface OrderItemMapper {
    OrderItemDto toDto(OrderItem orderItem);

    OrderItem toEntity(OrderItemDto orderItemDto);

    List<OrderItemDto> toDto(List<OrderItem> orderItems);

    List<OrderItem> toEntity(List<OrderItemDto> orderItemDtos);
}