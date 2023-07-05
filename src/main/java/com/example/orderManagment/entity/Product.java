package com.example.orderManagment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private Long id;

    private String slug;

    private String name;

    private String reference;

    private double price;

    private double vat;

    private boolean stockable;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<ProductOrder> productOrders;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Stock> stocks;
    // Constructors, getters, and setters
}







