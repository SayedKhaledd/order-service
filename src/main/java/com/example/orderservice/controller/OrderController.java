package com.example.orderservice.controller;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController()
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/payment/{orderId}")
    public OrderDto payOrder(@PathVariable Long orderId) {
        return orderService.processPayment(orderId);
    }
}
