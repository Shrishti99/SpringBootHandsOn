package com.devshri.devshri.service.impl;

import com.devshri.devshri.entity.ProductEntity;
import com.devshri.devshri.repository.ProductRepository;
import com.devshri.devshri.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<ProductEntity> getProductsByType(String categoryName) {
        return productRepository.findByType(categoryName);
    }

}
