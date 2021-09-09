package com.company;

public class Product {

    int id;
    String name;
    double price;

//    public Product() {
//        this.id = -1;
//        this.name = null;
//        this.price = -1;
//    }

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    int getProductId() {
        return id;
    }

    void setProductId(int id) {
        this.id = id;
    }

    String getProductName() {
        return name;
    }

    void setProductName(String name) {
        this.name = name;
    }

    double getProductPrice() {
        return price;
    }

    void setProductPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.getProductId() + " Product Name: " + this.getProductName() +
                ", Product Price: $" + this.getProductPrice() + "\n";
    }
}