package com.moujib.backend.model.purchase;

import com.moujib.backend.model.customer.Address;
import com.moujib.backend.model.customer.Customer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;


@Entity
public class Order implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

	@ManyToOne
	private Customer customer;

	@OneToOne
	private Address address;

	private Calendar createdAt;
	
	private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
