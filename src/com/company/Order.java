package com.company;


import java.util.ArrayList;
import java.util.List;

class Order {

    List<ShoppingCart> order = new ArrayList<>();

    void add(ShoppingCart shoppingCart) {
        order.add(shoppingCart);
    }

    void getOrderInfo() {
        order.forEach(ShoppingCart::getCartInfo);
    }
}