package com.moujib.backend.model.product;


import com.moujib.backend.model.customer.Customer;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Rating implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

	@ManyToOne
	private Product product;

	@OneToOne
	private Customer user;
	
	private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getUser() {
        return user;
    }

    public void setUser(Customer user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
