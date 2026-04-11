package cg.demo.association.test1;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name="abes_customer")
public class Customer {

    @Id
    @Column(name="customer_id")
    private int customerId;

    @Column(name="customer_name", nullable=false)
    private String customerName;

    @OneToMany(mappedBy="customer", cascade=CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();


    public Customer() {}

    public Customer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}