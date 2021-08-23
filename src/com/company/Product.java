package com.company;

public class Product {

    private int id;
    private String name;
    private double price;

    public Product() {
        this.id = -1;
        this.name = null;
        this.price = -1;
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return id;
    }

    public void setProductId(int id) {

        this.id = id;
    }

    public String getProductName() {

        return name;
    }

    public void setProductName(String name) {

        this.name = name;
    }

    public double getProductPrice() {
        return price;
    }

    public void setProductPrice(double price) {

        this.price = price;
    }
    @Override
    public String toString() {
        return this.getProductId() + " Product Name: " + this.getProductName() +
                ", Product Price: $" + this.getProductPrice() + "\n";
    }
}