package com.example.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long id;


    private Long customerId;

    private LocalDateTime orderDate;

    private Double totalPrice;

    private List<OrderItemDto> items;

    private String transactionId;


}
