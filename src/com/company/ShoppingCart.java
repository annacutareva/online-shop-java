package com.company;

import com.company.Product;

import java.util.ArrayList;

public class ShoppingCart {

    public ArrayList<Product> cart = new ArrayList<>();

    public void add(Product product) {
        cart.add(product);
    }

}