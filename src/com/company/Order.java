package com.company;


import java.util.ArrayList;
import java.util.List;

public class Order {

    List<ShoppingCart> order = new ArrayList<>();

    void addToOrder(ShoppingCart shoppingCart) {
        order.add(shoppingCart);
    }

    void getOrderInfo() {
        order.forEach(ShoppingCart::getCartInfo);
    }
}