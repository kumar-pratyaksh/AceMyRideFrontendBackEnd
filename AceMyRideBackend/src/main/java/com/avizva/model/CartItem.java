package com.avizva.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "productId")
	private Product product;

	private int userId;

	private int quantity;

	private double totalPrice;

	@Column(insertable = false, columnDefinition = "boolean default false")
	private boolean orderProcessed;

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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isOrderProcessed() {
		return orderProcessed;
	}

	public void setOrderProcessed(boolean orderProcessed) {
		this.orderProcessed = orderProcessed;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", product=" + product + ", userId=" + userId + ", quantity=" + quantity
				+ ", totalPrice=" + totalPrice + "]";
	}

}
