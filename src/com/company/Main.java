package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

class Main {

    public static Scanner input = new Scanner(System.in);

    public static String continueShopping, addToCart, placeOrder;
    public static int choose, quantity = 1;
    public static double total = 0.00;
    public static double[] prices = {0.00, 2.10, 8.25, 18.90, 6.00, 11.30};

    public static List<Product> Products = new ArrayList<>();
    static ShoppingCart shoppingCart = new ShoppingCart();

    public static void products() {

        //printing the products
        System.out.println("==============");
        System.out.println("PRODUCTS");
        System.out.println("==============");

        //creating products and adding them to the products list
        Product product1 = new Product(1, "Apple", 2.10);
        Products.add(product1);

        Product product2 = new Product(2, "Banana", 8.25);
        Products.add(product2);

        Product product3 = new Product(3, "Pineapple", 18.90);
        Products.add(product3);

        Product product4 = new Product(4, "Orange", 6.00);
        Products.add(product4);

        Product product5 = new Product(5, "Cherry", 11.30);
        Products.add(product5);

        System.out.println("==============");
    }

    public static void order() {

        IntStream.range(1, 6).forEach(i -> System.out.println("Press " + i + " for Product " + i));

        choose = input.nextInt();
        if (choose > 5) {
            System.out.println("There is no product available");
            order();
        }

        //selecting products and quantity
        System.out.println("Please choose quantity:");
        quantity = input.nextInt();
        System.out.println("You chose Product# " + choose + ". Would you like to add it to the cart? Press Y for Yes or N for No");
        addToCart = input.next();

        //adding selected products to the shopping cart
        if (addToCart.equalsIgnoreCase("y")) {
            for (Product product : Products) {
                if (product.getProductId() == choose && !shoppingCart.cartContains(product)) {
                    shoppingCart.add(product);
                }
            }
        } else {
            order();
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
                order.add(shoppingCart);

                //printing the order information
                int orderNumber = ThreadLocalRandom.current().nextInt(1, 100);
                System.out.println("Order# " + orderNumber);
                order.getOrderInfo();
                System.out.println("Total: " + total + "$");
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