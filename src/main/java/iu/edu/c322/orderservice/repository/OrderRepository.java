package iu.edu.c322.orderservice.repository;

import iu.edu.c322.orderservice.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    List<Order> orders = new ArrayList<>();

    public int create(Order order) {
        int id = orders.size() + 1;
        order.setId(id);
        orders.add(order);
        return id;
    }

    public void update(Order order, int id) {
        Order x = getOrderById(id);
        if(x != null) {
            x.setItems(order.getItems());
            x.setTotal(order.getTotal());
            x.setShippingAddress(order.getShippingAddress());
            x.setPayment(order.getPayment());
        } else {
            throw new IllegalStateException("Order id is not valid");
        }
    }

    public void delete(int id) {
        Order x = getOrderById(id);
        if(x != null) {
            orders.remove(x);
        }

    }

    public List<Order> findAll() {
        return this.orders;
    }

    public Order getOrderById(int id) {
        return orders.stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }
}
