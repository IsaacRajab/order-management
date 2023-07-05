package com.example.orderManagment.service;

import com.example.orderManagment.entity.Product;
import com.example.orderManagment.repository.ProductRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
   @Autowired
   private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @SneakyThrows
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = getProductById(id);
        product.setSlug(productDetails.getSlug());
        product.setName(productDetails.getName());
        product.setReference(productDetails.getReference());
        product.setPrice(productDetails.getPrice());
        product.setVat(productDetails.getVat());
        product.setStockable(productDetails.isStockable());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

