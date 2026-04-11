package com.example.order_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.order_service.dto.OrderRequest;
import com.example.order_service.dto.OrderResponse;
import com.example.order_service.dto.ProductDTO;
import com.example.order_service.dto.UserDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderService {

    @Autowired
    private RestTemplate restTemplate;

    private static Long orderCounter = 5000L;

    @CircuitBreaker(name = "orderService", fallbackMethod = "fallbackOrder")
    public OrderResponse createOrder(OrderRequest request) {

        UserDTO user = restTemplate.getForObject(
                "http://USER-SERVICE/users/" + request.getUserId(),
                UserDTO.class);

 
        ProductDTO product = restTemplate.getForObject(
                "http://PRODUCT-SERVICE/products/" + request.getProductId(),
                ProductDTO.class);

        OrderResponse response = new OrderResponse();
        response.setOrderId(++orderCounter);
        response.setUserName(user.getName());
        response.setProductName(product.getName());
        response.setQuantity(request.getQuantity());
        response.setTotalPrice(product.getPrice() * request.getQuantity());

        return response;
    }

    
    public OrderResponse fallbackOrder(OrderRequest request, Exception ex) {
        OrderResponse response = new OrderResponse();
        response.setOrderId(-1L);
        response.setUserName("Service Unavailable");
        response.setProductName("Service Unavailable");
        response.setQuantity(request.getQuantity());
        response.setTotalPrice(0);
        return response;
    }
}