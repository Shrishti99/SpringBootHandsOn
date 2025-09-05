package com.devshri.devshri.service;

import com.devshri.devshri.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<ProductEntity> getAllproducts();

    public Optional<ProductEntity> getProductsByType(Long id);

    public Optional<ProductEntity> getProductsByName(String name);

    public List<ProductEntity> getProductByRange(Double min, Double max);
}
