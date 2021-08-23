package com.company;


import java.util.ArrayList;
import java.util.List;

public class Order {

    public static List<ShoppingCart> order = new ArrayList<>();

    public void addAll(ShoppingCart shoppingCart) {

        order.add(shoppingCart);
    }

    public void getOrderInfo() {
        for(ShoppingCart cart : order) {
            cart.getCartInfo();
        }
    }
}