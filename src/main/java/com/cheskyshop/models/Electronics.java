package com.cheskyshop.models;

public class Electronics {
    private int electronicID;
    private String brand;
    private String model;
    private double price;

    public Electronics() {
        // Default constructor
    }
    
    public Electronics(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public Electronics(int electronicID, String brand, String model, double price) {
        this.electronicID = electronicID;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public int getElectronicID() {
        return electronicID;
    }

    public void setElectronicID(int electronicID) {
        this.electronicID = electronicID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Electronics{" +
                "electronicID=" + electronicID +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
