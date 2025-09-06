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

    @GetMapping("/products/{searchValue}")
    public ResponseEntity<?> getProductBySearch(@PathVariable String searchValue){
        Optional<ProductEntity> productByName = productServiceimpl.getProductsByName(searchValue);
        List<ProductEntity> productByDescription = productServiceimpl.getProductByDescription(searchValue);
        Long id;
        try{
            id = Long.parseLong(searchValue);
        } catch (NumberFormatException e){
            id = 0L;
        }
        if (productByName.isPresent()){
            return ResponseEntity.ok(productByName.get());
        }
        else if (!productByDescription.isEmpty()){
            return ResponseEntity.ok(productByDescription);
        }
        else if (!id.equals(0L)){
            Optional<ProductEntity> productById = productServiceimpl.getProductsByType(id);
            if (productById.isPresent()){
                return ResponseEntity.ok(productById.get());
            } else {
                return ResponseEntity.status(404).body("No Entity for given id is found.");
            }
        }
        else {
            return ResponseEntity.status(404).body("No Entity for given name is found.");
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
