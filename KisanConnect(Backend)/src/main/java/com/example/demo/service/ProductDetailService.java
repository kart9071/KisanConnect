package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ProductDetails;
import com.example.demo.repository.ProductDetailsRepository;

@Service
public class ProductDetailService {

    @Autowired
    private ProductDetailsRepository productRepository;

    public ProductDetails saveProduct(ProductDetails product) {
        return productRepository.save(product);
    }

    public Iterable<ProductDetails> getProductDetails(){
        return productRepository.findAll();
    }
}
