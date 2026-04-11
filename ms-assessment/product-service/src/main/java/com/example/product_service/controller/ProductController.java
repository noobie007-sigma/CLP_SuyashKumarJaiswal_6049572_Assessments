package com.example.product_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product_service.entity.Product;
import com.example.product_service.service.ProductService;



@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.save(product);
    }
    @GetMapping("/{id}")
    public Product get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Product deleted successfully";
    }
}