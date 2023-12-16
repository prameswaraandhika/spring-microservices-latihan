package com.prameswaradev.OrderService.controller;

import com.prameswaradev.OrderService.model.OrderRequest;
import com.prameswaradev.OrderService.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequest orderRequest){
        Long orderId = orderService.placeOrder(orderRequest);
        return new ResponseEntity<>(orderId, HttpStatus.OK);
    }

}
