package iu.edu.c322.orderservice.model;

import jakarta.persistence.*;

@Entity
class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String method;
    private String number;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address billingAddress;

    public void setId(int id) {
        this.id = id;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public int getId() {
        return id;
    }

    public String getMethod() {
        return method;
    }

    public String getNumber() {
        return number;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }
}
