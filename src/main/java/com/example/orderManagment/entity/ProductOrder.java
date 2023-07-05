package com.example.orderManagment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_order")
public class ProductOrder {
    @Id
    @GeneratedValue
    private Long productOrderId;

    private int quantity;

    private double price;

    private double vat;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    // Constructors, getters, and setters
}
