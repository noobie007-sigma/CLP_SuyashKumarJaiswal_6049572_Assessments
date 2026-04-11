package com.example.order_service.dto;

public class OrderResponse {

    private Long orderId;
    private String userName;
    private String productName;
    private int quantity;
    private double totalPrice;

    public Long getOrderId() { 
    	return orderId; 
    }
    public void setOrderId(Long orderId) { 
    	this.orderId = orderId; 
    }

    public String getUserName() { 
    	return userName; 
    }
    public void setUserName(String userName) { 
    	this.userName = userName; 
    }

    public String getProductName() { 
    	return productName; 
    }
    public void setProductName(String productName) { 
    	this.productName = productName;
    }

    public int getQuantity() { 
    	return quantity; 
    }
    public void setQuantity(int quantity) { 
    	this.quantity = quantity;
    }

    public double getTotalPrice() { 
    	return totalPrice; 
    }
    public void setTotalPrice(double totalPrice) { 
    	this.totalPrice = totalPrice;
    }
}