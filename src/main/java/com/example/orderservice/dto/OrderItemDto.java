package com.example.orderservice.dto;

import com.example.orderservice.model.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItemDto {
    private Long id;
    private Order order;
    @NotBlank(message = "Product id is required")
    private Long productId;
    @NotBlank(message = "Quantity is required")
    private Integer quantity;
    @NotBlank(message = "Unit price is required")
    private Double unitPrice;

    private Double totalAmount;


}
