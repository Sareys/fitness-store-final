package com.moujib.backend.model.purchase;


import com.moujib.backend.model.product.Product;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BasketRow implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	private Basket basket;

	@OneToOne
	private Product product;

	private float totalPrice;

	private int quantity;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
