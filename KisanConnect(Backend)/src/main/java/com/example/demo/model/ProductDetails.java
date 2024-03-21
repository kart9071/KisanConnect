package com.example.demo.model;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class ProductDetails {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String name;

    private String company;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<ProductVariant> productVarients;

    private String image;

    @Lob
    private String content;

    @ElementCollection
    @CollectionTable(name = "product_features", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "feature")
    private List<String> features;

    private String usage;

    private String crops;

    @Column(name = "time_of_application")
    private String timeOfApplication;

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

    public List<ProductVariant> getproductVarients() {
        return productVarients;
    }

    public void setproductVarients(List<ProductVariant> productVarients) {
        this.productVarients = productVarients;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
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

    public ProductDetails(Long id, String name, String company, List<ProductVariant> productVarients, String image,
            String content, List<String> features, String usage, String crops, String timeOfApplication,
            String dosage) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.productVarients = productVarients;
        this.image = image;
        this.content = content;
        this.features = features;
        this.usage = usage;
        this.crops = crops;
        this.timeOfApplication = timeOfApplication;
        this.dosage = dosage;
    }

    public ProductDetails() {
        super();
    }

    @Override
    public String toString() {
        return "ProductDetails [id=" + id + ", name=" + name + ", company=" + company + ", productVarients="
                + productVarients + ", image=" + image + ", content=" + content + ", features=" + features + ", usage="
                + usage + ", crops=" + crops + ", timeOfApplication=" + timeOfApplication + ", dosage=" + dosage + "]";
    }

    
}
