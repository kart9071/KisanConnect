package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProductDetails;
import com.example.demo.service.ProductDetailService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ProductDetailsController {

    @Autowired
    private ProductDetailService productService;

    @PostMapping("/products")
    @CrossOrigin(origins = "http://localhost:4200")
    public ProductDetails createProduct(@RequestBody ProductDetails product) {
        System.out.println(product);
        return productService.saveProduct(product);
    }
    
    @GetMapping("/products/details")
    @CrossOrigin(origins = "http://localhost:4200")
    public Iterable<ProductDetails> getProductDetails(){
        return productService.getProductDetails();
    }
}
