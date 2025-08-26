package com.devshri.devshri.controller;

import com.devshri.devshri.entity.ProductEntity;
import com.devshri.devshri.service.impl.ProductServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
public class eCommerceController {

    @Autowired
    private final ProductServiceImpl productServiceimpl;

    public eCommerceController(ProductServiceImpl productServiceimpl) {
        this.productServiceimpl = productServiceimpl;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Shrishti Singh!";
    }


    @GetMapping("/products")
    public List<ProductEntity> getAllProducts() {
        return productServiceimpl.getAllproducts();
    }
}
