package com.example.orderservice.service;

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

    @Override
    public OrderItemDto create(OrderItemDto orderItemDto) {
        orderItemDto.setTotalAmount(orderItemDto.getQuantity() * orderItemDto.getUnitPrice());
        return orderItemMapper.toDto(orderItemRepository.save(orderItemMapper.toEntity(orderItemDto)));
    }

    @Override
    public List<OrderItemDto> create(List<OrderItemDto> orderItemDto) {
        orderItemDto.forEach(item -> item.setTotalAmount(item.getQuantity() * item.getUnitPrice()));
        return orderItemMapper.toDto(orderItemRepository.saveAll(orderItemMapper.toEntity(orderItemDto)));
    }
}


