package com.example.orderManagment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    private Long  customerId;

    private Date orderedAt;


    @OneToMany(mappedBy = "order")
    private List<ProductOrder> productOrders;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
