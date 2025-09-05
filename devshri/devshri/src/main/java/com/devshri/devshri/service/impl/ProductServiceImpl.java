package com.devshri.devshri.service.impl;

import com.devshri.devshri.entity.ProductEntity;
import com.devshri.devshri.repository.ProductRepository;
import com.devshri.devshri.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductEntity> getAllproducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<ProductEntity> getProductsByType(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        return product;
    }

    @Override
    public Optional<ProductEntity> getProductsByName(String name){
        return productRepository.findAll().stream().filter(product -> product.getName().equalsIgnoreCase(name)).findFirst();
    }

    @Override
    public List<ProductEntity> getProductByRange(Double min, Double max) {
        return productRepository.findAll().stream()
                .filter(product -> product.getPrice() >= min && product.getPrice() <= max)
                .toList();
    }
}
