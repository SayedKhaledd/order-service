package com.example.orderservice.service;

import com.example.orderservice.client.PaymentClient;
import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.dto.OrderItemDto;
import com.example.orderservice.mapper.OrderMapper;
import com.example.orderservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final PaymentClient paymentClient;

    public OrderDto createOrder(Set<Long> orderItems) {
        return null;
    }


    @Override
    public OrderDto processPayment(Long orderId) {
        OrderDto orderDto = orderMapper.toDto(orderRepository.findById(orderId).orElseThrow(() ->
                new RuntimeException("Order not found")));
        orderDto.setTotalPrice(calculateTotalAmount(orderDto));
        orderDto.setTransactionId(paymentClient.processPayment(orderDto.getId().toString(),
                orderDto.getTotalPrice(), "USD"));
        return orderDto;
    }

    private Double calculateTotalAmount(OrderDto orderDto) {
        return orderDto.getItems().stream()
                .map(OrderItemDto::getTotalAmount)
                .reduce(0.0, Double::sum);
    }
}
