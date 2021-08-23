package com.company;


import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    public static List<Product> cart = new ArrayList<>();

    public void add(Product product) {
        cart.add(product);
    }

    public void getCartInfo() {
        for(Product product : cart) {
            System.out.println(product.getProductName());
        }
    }

    public void clear() {
        cart.clear();
    }
}