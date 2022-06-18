package com.udacity.salesinvoiceapp.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Bassam
 */
public class InvoiceLine {

    private String id;
    private String itemName;
    private String itemPrice;
    private String itemCount;
    private String itemTotal;

    public InvoiceLine(String id, String itemName, String itemPrice) {
        this.id = id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public InvoiceLine(String id, String itemName, String itemPrice, String itemCount, String itemTotal) {
        this.id = id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCount = itemCount;
        this.itemTotal = itemTotal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemCount() {
        return itemCount;
    }

    public void setItemCount(String itemCount) {
        this.itemCount = itemCount;
    }

    public String getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(String itemTotal) {
        this.itemTotal = itemTotal;
    }

    @Override
    public String toString() {
        return "InvoiceLine{" + "id=" + id + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemCount=" + itemCount + ", itemTotal=" + itemTotal + '}';
    }

}
