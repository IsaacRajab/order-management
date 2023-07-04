package com.example.orderManagment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Stock {
    @Id
    @GeneratedValue
    private Long id;

    private Long productId;

    private int  quantity;

    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


}
