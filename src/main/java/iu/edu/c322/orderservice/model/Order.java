package iu.edu.c322.orderservice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int customerId;
    private double total;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    List<Item> items = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    public void addOrderItem(Item item){
        items.add(item);
        item.setOrder(this);
    }

    public void removeOrderItem(Item item){
        items.remove(item);
        item.setOrder(null);
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setShippingAddress(Address address) {
        this.address = address;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public double getTotal() {
        return this.total;
    }

    public Address getShippingAddress() {
        return this.address;
    }

    public List<Item> getItems() {
        return items;
    }

    public Payment getPayment() {
        return payment;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Order)) {
            return false;
        }
        Order order = (Order) o;
        return id == order.id && Objects.equals(items, order.items) && Objects.equals(total, order.total) && Objects.equals(address, order.address) && Objects.equals(payment, order.payment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total, items, address, payment);
    }
}

