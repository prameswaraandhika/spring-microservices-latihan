package com.prameswaradev.OrderService.service;

import com.prameswaradev.OrderService.entity.Order;
import com.prameswaradev.OrderService.model.OrderRequest;
import com.prameswaradev.OrderService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    public Long placeOrder(OrderRequest orderRequest) {
        Order order = Order.builder()
                .amount(orderRequest.getTotalAmount())
                .status("CREATED")
                .productId(orderRequest.getProductId())
                .date(Instant.now())
                .quantity(orderRequest.getQuantity())
                .build();

        return orderRepository.save(order).getId();
    }
}
