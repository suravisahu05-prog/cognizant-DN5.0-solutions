package com.cognizant.paymentservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    @CircuitBreaker(name = "paymentApi", fallbackMethod = "fallbackPayment")
    public String processPayment(String orderId) throws InterruptedException {
        // Simulate slow/unreliable third-party API
        Thread.sleep(3000);
        if (Math.random() < 0.7) {
            throw new RuntimeException("Third-party payment API timeout");
        }
        return "Payment successful for order " + orderId;
    }

    public String fallbackPayment(String orderId, Throwable t) {
        logger.warn("Fallback triggered for order {} due to: {}", orderId, t.getMessage());
        return "Payment service unavailable, please try again later (order " + orderId + ")";
    }
}
