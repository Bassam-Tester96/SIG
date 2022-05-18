/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udacity.salesinvoiceapp;

import java.util.ArrayList;

/**
 *
 * @author Bassam
 */
public class InvoiceHeader {

    private String id;
    private String date;
    private String customer;
    private String total;
    private ArrayList<InvoiceLine> invoiceLines;

    public InvoiceHeader(String id, String date, String customer) {
        this.id = id;
        this.date = date;
        this.customer = customer;
    }

    public InvoiceHeader(String id, String date, String customer, String total) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public ArrayList<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }

    public void setInvoiceLines(ArrayList<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }

    @Override
    public String toString() {
        return "InvoiceHeader{" + "id=" + id + ", date=" + date + ", customer=" + customer + ", total=" + total + ", invoiceLines=" + invoiceLines + '}';
    }

}
