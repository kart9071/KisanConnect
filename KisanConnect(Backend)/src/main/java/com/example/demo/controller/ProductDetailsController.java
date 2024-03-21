package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProductDetails;
import com.example.demo.service.ProductDetailService;

@RestController
public class ProductDetailsController {

    @Autowired
    private ProductDetailService productService;

    @PostMapping("/products")
    public ProductDetails createProduct(@RequestBody ProductDetails product) {
        return productService.saveProduct(product);
    }
}
