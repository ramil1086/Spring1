package com.gb.practice;

import java.util.List;

public interface InterfaceProductRepository {
    Product getProductById(int id);
    List<Product> getListOfProducts();
}
