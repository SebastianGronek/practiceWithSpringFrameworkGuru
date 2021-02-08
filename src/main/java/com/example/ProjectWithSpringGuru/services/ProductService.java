package com.example.ProjectWithSpringGuru.services;

import com.example.ProjectWithSpringGuru.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveOrUpdateProduct(Product product);

    void deleteProduct(Integer id);
}
