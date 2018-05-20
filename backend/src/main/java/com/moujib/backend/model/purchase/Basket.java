package com.moujib.backend.model.purchase;

import com.moujib.backend.model.customer.Customer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

@Entity
public class Basket implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

	@OneToOne
	private Customer customer;
	
	private Calendar createdAt;

	@OneToMany(mappedBy = "basket", cascade = CascadeType.ALL)
	private List<BasketRow> rows;

	private float totalPrice;

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

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    public List<BasketRow> getRows() {
        return rows;
    }

    public void setRows(List<BasketRow> rows) {
        this.rows = rows;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

}
