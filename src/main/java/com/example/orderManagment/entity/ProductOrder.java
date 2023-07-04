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
    private Long productId;

    private Long orderId;

    private int quantity;

    private double price;

    private double vat;

        @ManyToOne
     @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // Constructors, getters, and setters
}
