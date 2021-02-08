package com.example.ProjectWithSpringGuru.services;

import com.example.ProjectWithSpringGuru.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ProductServiceImplementation implements ProductService {

    private Map<Integer, Product> products;

    public ProductServiceImplementation() {
        loadProducts();
    }

    private void loadProducts() {
        products = new HashMap<>();

        Product product1 = new Product();
        product1.setId(1);
        product1.setPrice(BigDecimal.valueOf(14.99));
        product1.setDescription("product 1");
        product1.setImgURL("http://example.com/product1");
        products.put(1, product1);

        Product product2 = new Product();
        product2.setId(2);
        product2.setPrice(BigDecimal.valueOf(15.99));
        product2.setDescription("product 2");
        product2.setImgURL("http://example.com/product2");
        products.put(2, product2);

        Product product3 = new Product();
        product3.setId(3);
        product3.setPrice(BigDecimal.valueOf(16.99));
        product3.setDescription("product3");
        product3.setImgURL("http://example.com/product3");
        products.put(3, product3);

        Product product4 = new Product();
        product4.setId(4);
        product4.setPrice(BigDecimal.valueOf(17.99));
        product4.setDescription("product4");
        product4.setImgURL("http://example.com/product4");
        products.put(4, product4);

        Product product5 = new Product();
        product5.setId(5);
        product5.setPrice(BigDecimal.valueOf(18.99));
        product5.setDescription("product5");
        product5.setImgURL("http://example.com/product5");
        products.put(5, product5);
    }

    @Override
    public List<Product> listAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product getProductById(Integer id) {
        return products.get(id);
    }

    @Override
    public Product saveOrUpdateProduct(Product product) {
        if (product != null) {
            if (product.getId() == null) {
                product.setId(getNextKey());
            }
            products.put(product.getId(), product);
            return product;
        } else {
            throw new RuntimeException("Product can't be null");
        }
    }

    @Override
    public void deleteProduct(Integer id) {
        products.remove(id);
    }

    private Integer getNextKey() {
       return products.keySet().stream().max(Comparator.comparingInt(k -> k)).get()+1;
    }

}
