package iu.edu.c322.orderservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String state;
    private String city;
    private int postalCode;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

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
