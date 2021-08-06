package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);
    public static String continueShopping, addToCart, placeOrder;
    public static int choose, quantity = 1;
    public static double total = 0;
    public static int[] prices = {0, 10, 20, 30, 40, 50, 60};
    public static ArrayList<String> shoppingCart = new ArrayList();

    public static void products() {
	System.out.println("----------------");
	System.out.println("PRODUCTS");
	System.out.println("----------------");
	System.out.println("Product 1       $10.00");
	System.out.println("Product 2       $20.00");
	System.out.println("Product 3       $30.00");
	System.out.println("Product 4       $40.00");
	System.out.println("Product 5       $50.00");
	System.out.println("Product 6       $60.00");
	System.out.println("-----------------");
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
            System.out.println("You chose Product# " + choose + ". Would you like to add it to the cart? Press Y for yes or N for no");
            addToCart = input.next();
            if (addToCart.equalsIgnoreCase("y")) {
                System.out.println("Adding to cart Product # " + choose + " - " + quantity + "pcs");
            } else {
                order();
            }
            shoppingCart.add("Product " + choose + " - " + quantity + " pcs");
            total += quantity * prices[choose];
            System.out.println("Would you like to continue shopping? Press Y for Yes or N for No");
            continueShopping = input.next();
            if (continueShopping.equalsIgnoreCase("y")) {
            order();
            } else {
                System.out.println("Your order is " + shoppingCart);
                System.out.println("Your total is " + total + "$");
                System.out.println("Would you like to place an order? Press Y for Yes or N for No");
                placeOrder = input.next();
                if (placeOrder.equalsIgnoreCase("y")) {
                    System.out.println("Thank you. Your order has been placed.");
                    System.exit(0);
                } else {
                    System.out.println("Your order has been canceled.");
                    System.exit(0);
                }
            }
    }

    public static void main(String[] args) {
    products();
    order();
    }
}
