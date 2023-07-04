package com.example.orderManagment.controller;

import com.example.orderManagment.entity.ProductOrder;
import com.example.orderManagment.service.ProductOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-orders")
public class ProductOrderController {
    private final ProductOrderService productOrderService;

    public ProductOrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @GetMapping
    public ResponseEntity<List<ProductOrder>> getAllProductOrders() {
        List<ProductOrder> productOrders = productOrderService.getAllProductOrders();
        return ResponseEntity.ok(productOrders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductOrder> getProductOrderById(@PathVariable Long id) {
        ProductOrder productOrder = productOrderService.getProductOrderById(id);
        return ResponseEntity.ok(productOrder);
    }

    @PostMapping
    public ResponseEntity<ProductOrder> createProductOrder(@RequestBody ProductOrder productOrder) {
        ProductOrder createdProductOrder = productOrderService.createProductOrder(productOrder);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductOrder> updateProductOrder(@PathVariable Long id, @RequestBody ProductOrder productOrder) {
        ProductOrder updatedProductOrder = productOrderService.updateProductOrder(id, productOrder);
        return ResponseEntity.ok(updatedProductOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductOrder(@PathVariable Long id) {
        productOrderService.deleteProductOrder(id);
        return ResponseEntity.noContent().build();
    }
}

