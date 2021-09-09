package com.company;


import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    public static List<Product> cart = new ArrayList<>();

    public void add(Product product) {
        cart.add(product);
    }

    void getCartInfo() {
        cart.forEach(product -> System.out.println(product.getProductName()));
    }

//    void clear() {
//        cart.clear();
//    }

    boolean cartContains(Product product) {
        return cart.contains(product);
    }
}