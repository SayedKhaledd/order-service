package com.example.orderservice.client;

import com.example.paymentservice.grpc.PaymentRequest;
import com.example.paymentservice.grpc.PaymentResponse;
import com.example.paymentservice.grpc.PaymentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentClientImpl implements PaymentClient {
    private final PaymentServiceGrpc.PaymentServiceBlockingStub paymentServiceStub;

    public PaymentClientImpl(@Value("${payment.service.address}") String paymentServiceAddress) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget(paymentServiceAddress)
                .usePlaintext() // In production, you'd use SSL/TLS
                .build();
        paymentServiceStub = PaymentServiceGrpc.newBlockingStub(channel);
    }

    @Override
    public String processPayment(String orderId, double amount, String currency) {
        PaymentRequest request = PaymentRequest.newBuilder()
                .setOrderId(orderId)
                .setAmount(amount)
                .setCurrency(currency)
                .build();

        PaymentResponse response = paymentServiceStub.processPayment(request);
        return response.getSuccess() ? response.getTransactionId() : "Failed: " + response.getErrorMessage();
    }
}
