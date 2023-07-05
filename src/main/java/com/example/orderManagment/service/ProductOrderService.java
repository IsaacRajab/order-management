package com.example.orderManagment.service;

import com.example.orderManagment.entity.ProductOrder;
import com.example.orderManagment.repository.ProductOrderRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderService {
    @Autowired
    private final ProductOrderRepository productOrderRepository;

    public ProductOrderService(ProductOrderRepository productOrderRepository) {
        this.productOrderRepository = productOrderRepository;
    }

    public List<ProductOrder> getAllProductOrders() {
        return productOrderRepository.findAll();
    }

    @SneakyThrows
    public ProductOrder getProductOrderById(Long id) {
        return productOrderRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public ProductOrder createProductOrder(ProductOrder productOrder) {
        return productOrderRepository.save(productOrder);
    }

    public ProductOrder updateProductOrder(Long id, ProductOrder productOrderDetails) {
        ProductOrder productOrder = getProductOrderById(id);
        productOrder.setQuantity(productOrderDetails.getQuantity());
        productOrder.setPrice(productOrderDetails.getPrice());
        productOrder.setVat(productOrderDetails.getVat());
        return productOrderRepository.save(productOrder);
    }

    public void deleteProductOrder(Long id) {
        productOrderRepository.deleteById(id);
    }
}
