package com.example.orderservice.service;

import com.example.orderservice.dto.OrderItemDto;

import java.util.List;

public interface OrderItemService {

    OrderItemDto findById(Long id);

    OrderItemDto create(OrderItemDto orderItemDto, Long orderId);

    List<OrderItemDto> create(List<OrderItemDto> orderItemDto, Long orderId);

}
