package com.example.orderservice.service;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.dto.OrderItemDto;
import com.example.orderservice.mapper.OrderItemMapper;
import com.example.orderservice.repository.OrderItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;
    private final OrderService orderService;

    @Override
    public OrderItemDto findById(Long id) {
        return orderItemMapper.toDto(orderItemRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Order Item not found")));
    }

    @Override
    public OrderItemDto create(OrderItemDto orderItemDto, Long orderId) {
        OrderDto orderDto = orderService.findById(orderId);
        orderItemDto.setOrder(orderDto);
        orderItemDto.setTotalAmount(orderItemDto.getQuantity() * orderItemDto.getUnitPrice());
        return orderItemMapper.toDto(orderItemRepository.save(orderItemMapper.toEntity(orderItemDto)));
    }

    @Override
    public List<OrderItemDto> create(List<OrderItemDto> orderItemDto, Long orderId) {
        OrderDto orderDto = orderService.findById(orderId);
        orderItemDto.forEach(item -> {
            item.setOrder(orderDto);
            item.setTotalAmount(item.getQuantity() * item.getUnitPrice());
        });
        return orderItemMapper.toDto(orderItemRepository.saveAll(orderItemMapper.toEntity(orderItemDto)));
    }
}


