package com.gb.practice;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository implements InterfaceProductRepository{
    private List<Product> listOfProducts;

    public ProductRepository() {
    }

    @PostConstruct
    public void init() {
        listOfProducts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            listOfProducts.add(new Product(i, "Product" + i, BigDecimal.valueOf(Math.random() * 30).setScale(2, BigDecimal.ROUND_HALF_UP)));
        }
    }
@Override
    public List<Product> getListOfProducts() {
        return listOfProducts;
    }

    @Override
    public Product getProductById(int id) {
        for (Product p : listOfProducts) {
            if (p.getId() == id) return p;
        }
        throw  new RuntimeException("No such ID");
    }
}
