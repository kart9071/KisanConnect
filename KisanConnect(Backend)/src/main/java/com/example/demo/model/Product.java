package com.example.demo.model;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Product {
	
	@Id
	private Long id;
	private String name;
	private String company;
	
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductVariant> var;
    
	@Lob
	private byte[] image;
	@Lob
	private String content;
	
	@ElementCollection
	private List<String> features;
	@Lob
	private String productUsage;
	@Lob
	private String crops;
	@Lob
	private String timeOfApplication;
	@Lob
	private String dosage;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public List<ProductVariant> getVar() {
		return var;
	}
	public void setVar(List<ProductVariant> var) {
		this.var = var;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<String> getFeatures() {
		return features;
	}
	public void setFeatures(List<String> features) {
		this.features = features;
	}
	public String getProductUsage() {
		return productUsage;
	}
	public void setProductUsage(String productUsage) {
		this.productUsage = productUsage;
	}
	public String getCrops() {
		return crops;
	}
	public void setCrops(String crops) {
		this.crops = crops;
	}
	public String getTimeOfApplication() {
		return timeOfApplication;
	}
	public void setTimeOfApplication(String timeOfApplication) {
		this.timeOfApplication = timeOfApplication;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", company=" + company + ", var=" + var + ", image="
				+ Arrays.toString(image) + ", content=" + content + ", features=" + features + ", productUsage="
				+ productUsage + ", crops=" + crops + ", timeOfApplication=" + timeOfApplication + ", dosage=" + dosage
				+ "]";
	}
	public Product(Long id, String name, String company, List<ProductVariant> var, byte[] image, String content,
			List<String> features, String productUsage, String crops, String timeOfApplication, String dosage) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
		this.var = var;
		this.image = image;
		this.content = content;
		this.features = features;
		this.productUsage = productUsage;
		this.crops = crops;
		this.timeOfApplication = timeOfApplication;
		this.dosage = dosage;
	}
	public Product() {
		super();
	}
	

	
	
	
}
//it is karthik
//insert into product values(121,10.0,10,400,'banana seed','path');

