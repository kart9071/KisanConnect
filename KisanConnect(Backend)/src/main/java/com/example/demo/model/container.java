package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;

@Entity
@Table
public class container {
    @Id
    @Column(unique=true)
    private Integer productId;
    private String productName;
    private Integer price;
    private String offer;
    private String description;
    private Integer productLeft;
    
    
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getProductLeft() {
		return productLeft;
	}
	public void setProductLeft(Integer productLeft) {
		this.productLeft = productLeft;
	}
	public container(Integer productId, String productName, Integer price, String offer, String description,
			Integer productLeft) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.offer = offer;
		this.description = description;
		this.productLeft = productLeft;
	}
	public container() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "container [productId=" + productId + ", productName=" + productName + ", price=" + price + ", offer="
				+ offer + ", description=" + description + ", productLeft=" + productLeft + "]";
	}
    
    
    

}
