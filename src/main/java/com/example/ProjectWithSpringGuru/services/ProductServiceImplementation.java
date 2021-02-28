package com.example.ProjectWithSpringGuru.services;

import com.example.ProjectWithSpringGuru.model.DomainObject;
import com.example.ProjectWithSpringGuru.model.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Service
@Profile("map")
public class ProductServiceImplementation extends AbstractMapService implements ProductService {



    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Product saveOrUpdate(Product product) {
        return (Product) super.saveOrUpdate(product);
    }

    @Override
    protected void loadDomainObjects() {
        domainMap = new HashMap<>();

        Product product1 = new Product();
        product1.setId(1);
        product1.setPrice(BigDecimal.valueOf(14.99));
        product1.setDescription("product 1");
        product1.setImgUrl("http://example.com/product1");
        domainMap.put(1, product1);

        Product product2 = new Product();
        product2.setId(2);
        product2.setPrice(BigDecimal.valueOf(15.99));
        product2.setDescription("product 2");
        product2.setImgUrl("http://example.com/product2");
        domainMap.put(2, product2);

        Product product3 = new Product();
        product3.setId(3);
        product3.setPrice(BigDecimal.valueOf(16.99));
        product3.setDescription("product3");
        product3.setImgUrl("http://example.com/product3");
        domainMap.put(3, product3);

        Product product4 = new Product();
        product4.setId(4);
        product4.setPrice(BigDecimal.valueOf(17.99));
        product4.setDescription("product4");
        product4.setImgUrl("http://example.com/product4");
        domainMap.put(4, product4);

        Product product5 = new Product();
        product5.setId(5);
        product5.setPrice(BigDecimal.valueOf(18.99));
        product5.setDescription("product5");
        product5.setImgUrl("http://example.com/product5");
        domainMap.put(5, product5);
    }


    @Override
    public Product getById(Integer id) {
        return (Product) super.getById(id);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }


}
