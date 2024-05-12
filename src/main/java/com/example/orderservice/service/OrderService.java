package com.example.orderservice.service;

import com.example.orderservice.dto.OrderDto;

public interface OrderService {
    OrderDto findById(Long id);

    OrderDto createOrder(OrderDto orderDto);


    OrderDto processPayment(Long orderId);
}
