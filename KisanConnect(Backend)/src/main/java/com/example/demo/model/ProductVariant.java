package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class ProductVariant {
	@Id
    private Long variantId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Product product;

	private String variant;
	private int quantity;
	private double price;
	private double discount;
	public Long getVariantId() {
		return variantId;
	}
	public void setVariantId(Long variantId) {
		this.variantId = variantId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getVariant() {
		return variant;
	}
	public void setVariant(String variant) {
		this.variant = variant;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "ProductVariant [variantId=" + variantId + ", product=" + product + ", variant=" + variant
				+ ", quantity=" + quantity + ", price=" + price + ", discount=" + discount + "]";
	}
	public ProductVariant(Long variantId, Product product, String variant, int quantity, double price,
			double discount) {
		super();
		this.variantId = variantId;
		this.product = product;
		this.variant = variant;
		this.quantity = quantity;
		this.price = price;
		this.discount = discount;
	}
	public ProductVariant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
