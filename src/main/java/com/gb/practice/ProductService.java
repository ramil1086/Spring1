package com.gb.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    private InterfaceProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductRepository getProductRepository() {
        return (ProductRepository) productRepository;
    }


    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }

    public List<Product> getListOfProducts() {
        return productRepository.getListOfProducts();
    }

    public void showInfo() {
        System.out.print("Доступные к покупке продукты:\n");
        for (Product p : getListOfProducts()) {
            System.out.println(p.toString());
        }
        System.out.println("Введите команду add или remove и id продукта. Например: add 2");
        System.out.println("Для создания новой корзины введите new cart");
        System.out.println("Для выхода введите exit");
        System.out.print("Команда:");
    }
}
