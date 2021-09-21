package com.company;


import java.util.ArrayList;
import java.util.List;

class ShoppingCart {

    List<Product> cart = new ArrayList<>();

    void add(Product product) {
        cart.add(product);
        System.out.println("Adding to cart Product# " + product.id + " Name: " + product.name + " Price: " + product.price);
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