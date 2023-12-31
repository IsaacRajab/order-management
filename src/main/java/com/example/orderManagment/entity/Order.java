package com.example.orderManagment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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



    private Date orderedAt;


    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<ProductOrder> productOrders;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

}
