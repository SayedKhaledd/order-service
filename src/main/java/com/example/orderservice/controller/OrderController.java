package com.example.orderservice.controller;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.service.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController()
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/{orderId}")
    public OrderDto find(@PathVariable Long orderId) {
        return orderService.findById(orderId);
    }

    @PostMapping("/create")
    public OrderDto create(@RequestBody @Valid OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @PostMapping("/payment/{orderId}")
    public OrderDto payOrder(@PathVariable Long orderId) {
        return orderService.processPayment(orderId);
    }
}
