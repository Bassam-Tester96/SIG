/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udacity.salesinvoiceapp;

import com.udacity.salesinvoiceapp.controller.SalesAppController;
import com.udacity.salesinvoiceapp.view.SalesAppView;

/**
 *
 * @author Bassam
 */
public class SalesAppMain {

    public static void main(String args[]) {
        new SalesAppController(new SalesAppView());
    }

}
