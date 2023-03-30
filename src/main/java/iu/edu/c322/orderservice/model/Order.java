package iu.edu.c322.orderservice.model;

import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    private int id;
    private double total;
    private ShippingAddress shippingAddress;
    List<Item> items = new ArrayList<>();
    private Payment payment;


    public void setTotal(double total) {
        this.total = total;
    }

    public void setShippingAddress(ShippingAddress address) {
        this.shippingAddress = address;
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

    public ShippingAddress getShippingAddress() {
        return this.shippingAddress;
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
        return id == order.id && Objects.equals(items, order.items) && Objects.equals(total, order.total) && Objects.equals(shippingAddress, order.shippingAddress) && Objects.equals(payment, order.payment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total, items, shippingAddress, payment);
    }
}

class ShippingAddress {
    @NotEmpty(message = "state not found.")
    private String state;

    @NotEmpty(message = "city not found.")
    private String city;

    private int postalCode;

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public int getPostalCode() {
        return postalCode;
    }
}

class Item {
    @NotEmpty(message = "item name not found.")
    private String name;

    private int quantity;
    private int price;

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
}

class Payment {
    private String method;
    private String number;
    private ShippingAddress billingAddress;

    public void setMethod(String method) {
        this.method = method;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setBillingAddress(ShippingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getMethod() {
        return method;
    }

    public String getNumber() {
        return number;
    }

    public ShippingAddress getBillingAddress() {
        return billingAddress;
    }
}
