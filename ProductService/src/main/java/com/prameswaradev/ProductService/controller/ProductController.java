package com.prameswaradev.ProductService.controller;

import com.prameswaradev.ProductService.entity.Product;
import com.prameswaradev.ProductService.model.ProductRequest;
import com.prameswaradev.ProductService.model.ProductResponse;
import com.prameswaradev.ProductService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> newProduct(@RequestBody ProductRequest productRequest){
        long id = productService.create(productRequest);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id){
        ProductResponse productResponse = productService.getProductById(id);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @PutMapping("/reduceQuantity/{id}")
    public ResponseEntity<?> reduceQuantity(
            @PathVariable Long id,
            @RequestParam Long quantity
    ){
        productService.reduceQuantity(id, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
