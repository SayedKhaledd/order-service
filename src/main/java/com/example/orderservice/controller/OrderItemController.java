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


    @PostMapping("/create/order/{orderId}")
    public OrderItemDto createOrderItem(@RequestBody @Valid OrderItemDto orderItemDto, @PathVariable Long orderId) {
        return orderItemService.create(orderItemDto, orderId);
    }

    @PostMapping("/create-list/order/{orderId}")
    public List<OrderItemDto> createOrderItems(@RequestBody @Valid List<OrderItemDto> orderItemDtos, @PathVariable Long orderId) {
        return orderItemService.create(orderItemDtos, orderId);
    }
}
