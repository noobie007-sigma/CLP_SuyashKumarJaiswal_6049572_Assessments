package cg.demo.association.test1;

import java.util.*;

public class DaoClient {
	
    static OrderDao dao = new OrderDaoImpl();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        String opt = null;

        do {

            System.out.println("1-ADD, 2--VIEW BY ORDER ID, 3--VIEW BY CUSTOMER NAME");

            int mtype = scan.nextInt();

            processMenu(mtype);

            System.out.println("press y to continue");

            opt = scan.next();

        } while(opt.equalsIgnoreCase("y"));
    }

    public static void processMenu(int mtype) {

        switch(mtype) {

        case 1:
            addOrder();
            break;

        case 2:
            viewOrderByOrderID();
            break;

        case 3:
            viewOrdersByCustName();
            break;

        default:
            System.out.println("Invalid option");
        }
    }

    public static void addOrder() {

        System.out.println("Enter Customer ID");
        int cid = scan.nextInt();

        System.out.println("Enter Customer Name");
        String cname = scan.next();

        System.out.println("Enter Order Amount");
        double amt = scan.nextDouble();

        Customer c = new Customer(cid, cname);

        Order o = new Order(new Date(), amt);

        o.setCustomer(c);

        dao.addOrder(o);

        System.out.println("Order Added Successfully");
    }

    public static void viewOrderByOrderID() {

        System.out.println("Enter Order ID");

        int id = scan.nextInt();

        Order o = dao.viewOrderById(id);

        if(o != null) {

            System.out.println(o.getOrderId() + " " + o.getOrderAmt()+" " + o.getCustomer().getCustomerName());
        }
        else
            System.out.println("Order Not Found");
    }

    public static void viewOrdersByCustName() {

        System.out.println("Enter Customer Name");

        String name = scan.next();

        List<Order> list = dao.viewOrdersByCustomerName(name);

        for(Order o : list) {

            System.out.println(o.getOrderId()+" " + o.getOrderAmt()+" " + o.getCustomer().getCustomerName());
        }
    }
}