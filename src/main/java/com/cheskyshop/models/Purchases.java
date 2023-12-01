package com.cheskyshop.models;

import java.util.Date;

public class Purchases {
    private int purchaseID;
    private int customerID;
    private int shoeID;
    private int electronicID;
    private Date purchaseDate;
    private int quantity;
    private double totalPrice;

    public Purchases() {
        // Default constructor
    }

    public Purchases(int purchaseID, int customerID, int shoeID, int electronicID, Date purchaseDate, int quantity,
                     double totalPrice) {
        this.purchaseID = purchaseID;
        this.customerID = customerID;
        this.shoeID = shoeID;
        this.electronicID = electronicID;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public void setPurchaseID(int purchaseID) {
        this.purchaseID = purchaseID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getShoeID() {
        return shoeID;
    }

    public void setShoeID(int shoeID) {
        this.shoeID = shoeID;
    }

    public int getElectronicID() {
        return electronicID;
    }

    public void setElectronicID(int electronicID) {
        this.electronicID = electronicID;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getPurchaseID() {
        return purchaseID;
    }

    @Override
    public String toString() {
        return "Purchases{" +
                "purchaseID=" + purchaseID +
                ", customerID=" + customerID +
                ", shoeID=" + shoeID +
                ", electronicID=" + electronicID +
                ", purchaseDate=" + purchaseDate +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
