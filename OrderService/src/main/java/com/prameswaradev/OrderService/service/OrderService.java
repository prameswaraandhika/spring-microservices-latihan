package com.prameswaradev.OrderService.service;

import com.prameswaradev.OrderService.entity.Order;
import com.prameswaradev.OrderService.external.client.ProductService;
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
    private final ProductService productService;

    public Long placeOrder(OrderRequest orderRequest) {
        productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());
        Order order = Order.builder()
                .amount(orderRequest.getTotalAmount())
                .status("CREATED")
                .productId(orderRequest.getProductId())
                .date(Instant.now())
                .quantity(orderRequest.getQuantity())
                .build();
        log.info("Order places successfully, data: {}", order);
        return orderRepository.save(order).getId();
    }
}
