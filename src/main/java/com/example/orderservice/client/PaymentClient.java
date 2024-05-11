package com.example.orderservice.client;

public interface PaymentClient {
    String processPayment(String orderId, double amount, String currency);
}
