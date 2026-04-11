package com.example.product_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product_service.entity.Product;
import com.example.product_service.exception.ResourceNotFoundException;
import com.example.product_service.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    
    public Product save(Product product) {
        return repository.save(product);
    }
    public Product getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }
    public List<Product> getAll() {
        return repository.findAll();
    }
    public void delete(Long id) {
        Product product = getById(id);
        repository.delete(product);
    }
}