package iu.edu.c322.orderservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int quantity;
    private int price;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setOrder(Order order) {
        this.order = order;
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

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public int getId() {
        return id;
    }
}
