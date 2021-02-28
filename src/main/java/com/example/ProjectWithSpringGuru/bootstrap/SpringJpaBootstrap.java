package com.example.ProjectWithSpringGuru.bootstrap;

import com.example.ProjectWithSpringGuru.model.Product;
import com.example.ProjectWithSpringGuru.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadProducts();
    }

    public void loadProducts() {
        Product product1 = new Product();
        product1.setPrice(BigDecimal.valueOf(14.99));
        product1.setDescription("product 1");
        product1.setImgUrl("http://example.com/product1");
        productService.saveOrUpdate(product1);

        Product product2 = new Product();
        product2.setPrice(BigDecimal.valueOf(15.99));
        product2.setDescription("product 2");
        product2.setImgUrl("http://example.com/product2");
        productService.saveOrUpdate(product2);

        Product product3 = new Product();
        product3.setPrice(BigDecimal.valueOf(16.99));
        product3.setDescription("product3");
        product3.setImgUrl("http://example.com/product3");
        productService.saveOrUpdate(product3);

        Product product4 = new Product();
        product4.setPrice(BigDecimal.valueOf(17.99));
        product4.setDescription("product4");
        product4.setImgUrl("http://example.com/product4");
        productService.saveOrUpdate(product4);

        Product product5 = new Product();
        product5.setPrice(BigDecimal.valueOf(18.99));
        product5.setDescription("product5");
        product5.setImgUrl("http://example.com/product5");
        productService.saveOrUpdate(product5);
    }
}
