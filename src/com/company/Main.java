package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static Scanner input = new Scanner(System.in);
    public static String continueShopping, addToCart, placeOrder;
    public static int choose, quantity = 1;
    public static double total = 0;
    public static double[] prices = {0.00, 2.00, 8.00, 18.00, 6.00, 11.00};

    public static List<Product> Products = new ArrayList<>();
    static ShoppingCart shoppingCart = new ShoppingCart();

    public static void products() {

        //creating products and adding them to the products list
        Product product1 = new Product(1, "Apple", 2.00);

//        product1.setProductId(1);
//        product1.setProductName("Apple");
//        product1.setProductPrice(2.00);

        Products.add(product1);

        Product product2 = new Product(2, "Banana", 8.00);

//        product2.setProductId(2);
//        product2.setProductName("Banana");
//        product2.setProductPrice(8.00);

        Products.add(product2);

        Product product3 = new Product(3, "Pineapple", 18.00);

//        product3.setProductId(3);
//        product3.setProductName("Pineapple");
//        product3.setProductPrice(18.00);

        Products.add(product3);

        Product product4 = new Product(4, "Orange", 6.00);

//        product4.setProductId(4);
//        product4.setProductName("Orange");
//        product4.setProductPrice(6.00);

        Products.add(product4);

        Product product5 = new Product(5, "Cherry", 11.00);

//        product5.setProductId(5);
//        product5.setProductName("Cherry");
//        product5.setProductPrice(11.00);

        Products.add(product5);

        //printing the products
        System.out.println("==============");
        System.out.println("PRODUCTS");
        System.out.println("==============");
        System.out.println(Products);
        System.out.println("==============");
    }

    public static void order() {
        //printing the menu
        IntStream.range(1, 6).forEach(i -> System.out.println("Press " + i + " for Product " + i));

        choose = input.nextInt();
        if (choose > 5) {
            System.out.println("There is no product available");
            order();
        }

        System.out.println("Please choose quantity:");
        quantity = input.nextInt();
        System.out.println("You chose Product# " + choose + ". Would you like to add it to the cart? Press Y for Yes or N for No");
        addToCart = input.next();
        if (addToCart.equalsIgnoreCase("y")) {
            System.out.println("Adding to cart Product# " + choose + " - " + quantity + "pcs");
        } else {
            order();
        }

        //adding selected products to the shopping cart
        for (Product product : Products) {
            if (product.getProductId() == choose && !shoppingCart.contains(product)) {
                shoppingCart.add(product);
            }
        }

        total += quantity * prices[choose];
        System.out.println("Would you like to continue shopping? Press Y for Yes or N for No");
        continueShopping = input.next();
        if (continueShopping.equalsIgnoreCase("y")) {
            order();
        } else {
            System.out.println("Would you like to place an order? Press Y for Yes or N for No");
            placeOrder = input.next();
            if (placeOrder.equalsIgnoreCase("y")) {
                System.out.println("Thank you. Your order has been placed.");

                //creating a new order and adding items from shopping cart to the order
                Order order = new Order();
                order.addAll(shoppingCart);

                //printing the order information
                System.out.println("Your order: ");
                order.getOrderInfo();
                System.out.println("Your total is " + total + "$");
            } else {
                System.out.println("Your order has been canceled.");
            }
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        products();
        order();
    }
}