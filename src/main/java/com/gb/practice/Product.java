package com.gb.practice;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

public class Product {
    private int id;
    private String name;
    private BigDecimal price;

    public Product() {
    }

    public Product(int id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price.setScale(2, BigDecimal.ROUND_HALF_UP);
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("id = %d, name = %s, price = %s", id,name,price);
    }
}
