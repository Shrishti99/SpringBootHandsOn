package com.devshri.devshri.controller;

import com.devshri.devshri.entity.ProductEntity;
import com.devshri.devshri.service.impl.ProductServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/products/id/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Optional<ProductEntity> product = productServiceimpl.getProductsByType(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.status(404).body("No data found for the given id.");
        }
    }

    @GetMapping("/products/name/{name}")
    public ResponseEntity<?> getProductByName(@PathVariable String name) {
        System.out.println(name);
        Optional<ProductEntity> products = productServiceimpl.getProductsByName(name);
        if (products.isEmpty()) {
            return ResponseEntity.status(404).body("No data found for the given name.");
        } else {
            return ResponseEntity.ok(products);
        }
    }

    @GetMapping("/products/range/{min}/{max}")
    public ResponseEntity<?> getProductsByPriceRange(@PathVariable Double min, @PathVariable Double max) {
        List<ProductEntity> products = productServiceimpl.getProductByRange(min,max);
        if (products.isEmpty()){
            return ResponseEntity.status(404).body("No Entity for given range is found.");
        } else {
            return ResponseEntity.ok(products);
        }
    }
}
