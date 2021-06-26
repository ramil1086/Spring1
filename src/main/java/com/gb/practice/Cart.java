package com.gb.practice;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    private List<Product> listOfProducts;

    public Cart() {
        listOfProducts = new ArrayList<>();
    }

    public void addProduct(Product product) {
        listOfProducts.add(product);
    }

    public void removeProduct(Product product) {
        for (int i = 0; i < listOfProducts.size(); i++) {
            if (listOfProducts.get(i).getId() == product.getId()) {
                listOfProducts.remove(listOfProducts.get(i));
                return;
            }
        }
        throw new RuntimeException("No such Product");
    }

    public List<Product> getListOfCart() {
        return listOfProducts;
    }

    public void printCart() {
        System.out.println("Список товаров в корзине:");
        for (Product p : listOfProducts) {
            System.out.println(p.toString());
        }
    }

}
