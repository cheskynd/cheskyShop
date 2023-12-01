package com.cheskyshop.models;

public class Shoe {
    private int shoeID;
    private int size;
    private String brand;
    private double price;

    public Shoe() {
        // Default constructor
    }

    public Shoe(int shoeID, int size, String brand, double price) {
        this.shoeID = shoeID;
        this.size = size;
        this.brand = brand;
        this.price = price;
    }

    public Shoe(String brand, int size, double price) {
        this.size = size;
        this.brand = brand;
        this.price = price;
    }

    public int getShoeID() {
        return shoeID;
    }

    public void setShoeID(int shoeID) {
        this.shoeID = shoeID;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Shoe{" +
                "shoeID=" + shoeID +
                ", size=" + size +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
