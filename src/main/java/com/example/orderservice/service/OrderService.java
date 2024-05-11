package com.example.orderservice.service;

import com.example.orderservice.dto.OrderDto;

public interface OrderService {
    OrderDto processPayment(Long orderId);
}
