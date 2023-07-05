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

    private int  quantity;

    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;


}
