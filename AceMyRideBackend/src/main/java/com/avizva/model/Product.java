package com.avizva.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String productId;
	
	private String name;
	
	private String brand;
	
	private float price;
	
	private String description;
	
	private int inStock;
	
	private String belongsToCategoryName;
	
	private String suppliedBySupplierName;
	
	private String imagePath;
	
	@Column(columnDefinition = "boolean default true")
	private boolean enabled;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", columnDefinition = "datetime default CURRENT_TIMESTAMP", updatable = false)
	private Date createdAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	public String getBelongsToCategoryName() {
		return belongsToCategoryName;
	}

	public void setBelongsToCategoryName(String belongsToCategoryName) {
		this.belongsToCategoryName = belongsToCategoryName;
	}

	public String getSuppliedBySupplierName() {
		return suppliedBySupplierName;
	}

	public void setSuppliedBySupplierName(String suppliedBySupplierName) {
		this.suppliedBySupplierName = suppliedBySupplierName;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
}
