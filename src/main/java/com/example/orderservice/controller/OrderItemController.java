package com.example.orderservice.controller;

import com.example.orderservice.dto.OrderItemDto;
import com.example.orderservice.service.OrderItemService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/order-item")
public class OrderItemController {
    private final OrderItemService orderItemService;


    @PostMapping
    public OrderItemDto createOrderItem(@RequestBody @Valid OrderItemDto orderItemDto) {
        return orderItemService.create(orderItemDto);
    }

    @PostMapping("/list")
    public List<OrderItemDto> createOrderItems(@RequestBody @Valid List<OrderItemDto> orderItemDtos) {
        return orderItemService.create(orderItemDtos);
    }
}
