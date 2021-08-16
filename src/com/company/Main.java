package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);
    public static String continueShopping, addToCart, placeOrder;
    public static int choose, quantity = 1;
    public static double total = 0;
    public static double[] prices = {0.00, 10.00, 20.00, 30.00, 40.00, 50.00, 60.00};

    public static ArrayList<Product> products = new ArrayList<>();

    public static void products() {
        products.add(new Product(1, "Product 1", 10.00));
        products.add(new Product(2, "Product 2", 20.00));
        products.add(new Product(3, "Product 3", 30.00));
        products.add(new Product(4, "Product 4", 40.00));
        products.add(new Product(5, "Product 5", 50.00));
        products.add(new Product(6, "Product 6", 60.00));
        System.out.println("==============");
        System.out.println("PRODUCTS");
        System.out.println("==============");
        System.out.println(products.toString());
        System.out.println("==============");
    }

    public static void order() {
        for (int i = 1; i < 7; i++) {
            System.out.println("Press " + i + " for Product " + i);
        }
        choose = input.nextInt();
        if (choose > 6) {
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

        ShoppingCart shoppingCart = new ShoppingCart();

        //shoppingCart.add("Product " + choose + " - " + quantity + " pcs");
        shoppingCart.add(new Product(choose, "Product#" + choose, prices[choose]));

        total += quantity * prices[choose];
        System.out.println("Would you like to continue shopping? Press Y for Yes or N for No");
        continueShopping = input.next();
        if (continueShopping.equalsIgnoreCase("y")) {
            order();
        } else {
            System.out.println("Your total is " + total + "$");
            System.out.println("Would you like to place an order? Press Y for Yes or N for No");
            placeOrder = input.next();
            if (placeOrder.equalsIgnoreCase("y")) {
                System.out.println("Thank you. Your order has been placed.");
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