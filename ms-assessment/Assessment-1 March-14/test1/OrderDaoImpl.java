package cg.demo.association.test1;

import jakarta.persistence.*;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("order-pu");
    EntityManager em = emf.createEntityManager();

    
    @Override
    public void addOrder(Order order) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Customer cust = order.getCustomer();
        Customer existing = em.find(Customer.class, cust.getCustomerId());
        if(existing == null) {
            em.persist(cust);
        } else {
            order.setCustomer(existing);
        }
        em.persist(order);
        tx.commit();
    }

    @Override
    public Order viewOrderById(int id) {
        return em.find(Order.class, id);
    }

    @Override
    public List<Order> viewOrdersByCustomerName(String name) {

        String jpql = "SELECT o FROM Order o WHERE o.customer.customerName = :name";

        TypedQuery<Order> query =
                em.createQuery(jpql, Order.class);

        query.setParameter("name", name);

        return query.getResultList();
    }
}