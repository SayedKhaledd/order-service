package com.example.orderservice.service;

import com.example.orderservice.dto.OrderItemDto;

import java.util.List;

public interface OrderItemService {
    OrderItemDto create(OrderItemDto orderItemDto);

    List<OrderItemDto> create(List<OrderItemDto> orderItemDto);

}
