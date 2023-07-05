package com.example.orderManagment.service;

import com.example.orderManagment.entity.Order;
import com.example.orderManagment.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
   @Autowired
   private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id)throws ChangeSetPersister.NotFoundException {
        return orderRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order orderDetails) throws ChangeSetPersister.NotFoundException {
        Order order = getOrderById(id);
        order.setOrderedAt(orderDetails.getOrderedAt());
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
