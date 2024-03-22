package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProductDetails;
import com.example.demo.model.ProductVariant;
import com.example.demo.service.ProductDetailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
    public Iterable<ProductDetails> getProductDetails(){
        Iterable<ProductDetails> products=productService.getProductDetails();
        // System.out.println(i1);
        // HashMap<String,Object> response=new HashMap<>();
        

        // //to store the product details
        // ArrayList<Long> ids=new ArrayList<>();
        // ArrayList<String> names=new ArrayList<>();
        // ArrayList<String> companies=new ArrayList<>();
        // ArrayList<ArrayList<ProductVariant>> productvariants=new ArrayList<>();
        // ArrayList<String> images=new ArrayList<>();
        // ArrayList<String> contents = new ArrayList<>();
        // ArrayList<ArrayList<String>> featurelist=new ArrayList<>();
        // ArrayList<String> usages = new ArrayList<>();
        // ArrayList<String> cropsList = new ArrayList<>();
        // ArrayList<String> timeOfApplications = new ArrayList<>();
        // ArrayList<String> dosages = new ArrayList<>();

        // //to inssert each product row
        // for(ProductDetails product:products){
        //     ids.add(product.getId());
        //     names.add(product.getName());
        //     companies.add(product.getCompany());
        //     ArrayList<ProductVariant> productVariantsSubList=new ArrayList<>(product.getproductVariants());
        //     productvariants.add(productVariantsSubList);
        //     images.add(product.getImage());
        //     contents.add(product.getContent());
        //     ArrayList<String>  

            
        // }
        return products;
        
    }
}
