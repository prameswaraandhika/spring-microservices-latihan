package com.prameswaradev.ProductService.service;

import com.prameswaradev.ProductService.entity.Product;
import com.prameswaradev.ProductService.exception.InsufficientProducts;
import com.prameswaradev.ProductService.exception.ProductNotFound;
import com.prameswaradev.ProductService.model.ProductRequest;
import com.prameswaradev.ProductService.model.ProductResponse;
import com.prameswaradev.ProductService.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public long create(ProductRequest productRequest) {
      log.info("Procces to create the product");
        Product product = Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();

        return productRepository.save(product).getId();
    }

    public ProductResponse getProductById(Long id) {
        log.info("Get product with id {}", id);
        Product product = productRepository.findById(id).orElseThrow(()-> new ProductNotFound("Product not found"));
        ProductResponse productResponse = new ProductResponse();
        copyProperties(product, productResponse);
        return productResponse;
    }

    public void reduceQuantity(Long id, Long newQuantity) {
        log.info("Reduce quantity of product with id {}", id);
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ProductNotFound(String.format("Product with id %d not found", id) ));
        isSufficient(product.getQuantity(), newQuantity);
        product.setQuantity(product.getQuantity() - newQuantity);
        Product productSaved = productRepository.save(product);
        log.info("Product update successfully, data: {}", productSaved);

    }

    private void isSufficient(Long currentQuantity, Long quantityToCheck) {
        if (currentQuantity < quantityToCheck)
            throw new InsufficientProducts("Product doesnt have sufficient quantity");
    }
}
