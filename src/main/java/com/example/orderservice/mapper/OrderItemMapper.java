package com.example.orderservice.mapper;

import com.example.orderservice.dto.OrderItemDto;
import com.example.orderservice.model.OrderItem;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = org.mapstruct.InjectionStrategy.CONSTRUCTOR)
public interface OrderItemMapper {
    @Named("mapOrderItemToDto")
    @Mapping(target = "order.items", ignore = true)
    OrderItemDto toDto(OrderItem orderItem);

    @Named("mapOrderItemDtoToEntity")
    @Mapping(target = "order.items", ignore = true)
    OrderItem toEntity(OrderItemDto orderItemDto);

    @Named("mapOrderItemsToDtos")
    @IterableMapping(qualifiedByName = "mapOrderItemToDto")
    List<OrderItemDto> toDto(List<OrderItem> orderItems);

    @Named("mapOrderItemDtosToEntities")
    @IterableMapping(qualifiedByName = "mapOrderItemDtoToEntity")
    List<OrderItem> toEntity(List<OrderItemDto> orderItemDtos);
}