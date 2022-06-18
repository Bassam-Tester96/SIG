package com.udacity.salesinvoiceapp.controller;

import com.udacity.salesinvoiceapp.model.InvoiceHeader;
import com.udacity.salesinvoiceapp.model.InvoiceLine;
import com.udacity.salesinvoiceapp.datasource.SalesAppDataSource;
import com.udacity.salesinvoiceapp.view.SalesAppView;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bassam
 */
public class SalesAppController {

    private final SalesAppView sav;

    public SalesAppController(SalesAppView sav) {
        this.sav = sav;
        this.sav.setVisible(true);

        this.sav.getButtonAddItem().addActionListener(e -> addItem(e));
        this.sav.getButtonRemoveItem().addActionListener(e -> removeItem(e));
        this.sav.getButtonSave().addActionListener(e -> saveInvoiceItems(e));
        this.sav.getButtonCancel().addActionListener(e -> cancel(e));
        this.sav.getButtonCreateInvoice().addActionListener(e -> createInvoice(e));
        this.sav.getButtonDeleteInvoice().addActionListener(e -> deleteInvoice(e));

        this.sav.getMenuItemLoad().addActionListener(e -> loadInvoices(e));
        this.sav.getMenuItemSave().addActionListener(e -> saveInvoices(e));

        this.sav.getTableInvoices().getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                showInvoiceDetails();
            }
        });
    }

    private void addItem(ActionEvent e) {
        this.sav.AddItem();
    }

    private void removeItem(ActionEvent e) {
        this.sav.removeItem();
    }

    private void cancel(ActionEvent e) {
        showInvoiceDetails();
    }

    private void showInvoiceDetails() {
        int rowIndex = this.sav.getSelectedInvoiceRow();
        if (rowIndex == -1) {
            this.sav.clearInvoiceDetails();
            return;
        }
        String id = this.sav.getSelectedInvoiceId(rowIndex);
        this.sav.showInvoiceDetails(SalesAppDataSource.getInvoice(id));
    }

    private void createInvoice(ActionEvent e) {
        String id = Integer.toString(SalesAppDataSource.getMaxId());
        this.sav.addInvoice(id);
    }

    private void deleteInvoice(ActionEvent e) {
        int rowIndex = this.sav.getSelectedInvoiceRow();
        if (rowIndex != -1) {
            String invoiceNumber = this.sav.getSelectedInvoiceId(rowIndex);
            SalesAppDataSource.deleteInvoice(invoiceNumber);
            this.sav.deleteInvoice(rowIndex);
            sav.showMessageDialog("Invoice Deleted Successfuly Test");
        }
    }

    private void loadInvoices(ActionEvent e) {

        try {
            this.sav.showMessageDialog("Choose Invoice Header File");
            String invoicesPath = this.sav.chooseFileToOpen();
            if (null == invoicesPath) {
                return;
            }

            this.sav.showMessageDialog("Choose Invoice Line File");
            String invoicesItemsPath = this.sav.chooseFileToOpen();
            if (null == invoicesItemsPath) {
                return;
            }

            SalesAppDataSource.loadInvoices(invoicesPath, invoicesItemsPath);

            this.sav.clearInvoiceDetails();
            this.sav.createInvoicesTable(SalesAppDataSource.getInvoiceHeaders(), SalesAppDataSource.getInvoiceLines());

        } catch (IOException ex) {
            this.sav.showMessageDialog("Failed To Load Invoices: " + ex.getMessage());
        }
    }

    private void saveInvoices(ActionEvent e) {
        try {
            if (SalesAppDataSource.isEmpty()) {
                this.sav.showMessageDialog("No Invoices To Save");
                return;
            }

            this.sav.showMessageDialog("Choose File Path To Save Invoice Header");
            String invoicesPath = this.sav.chooseFileToSave();

            if (null == invoicesPath) {
                return;
            }

            this.sav.showMessageDialog("Choose File Path To Save Invoice Items");
            String invoicesItemsPath = this.sav.chooseFileToSave();

            SalesAppDataSource.saveInvoices(invoicesPath, invoicesItemsPath);
            this.sav.showMessageDialog("Invoices Saved Successfully");
        } catch (IOException ex) {
            this.sav.showMessageDialog("Failed To Save Invoices");
        }

    }

    private void saveInvoiceItems(ActionEvent e) {
        String invoiceNumber = this.sav.getTextFieldInvoiceNumber().getText();
        String invoiceDate = this.sav.getTextFieldInvoiceDate().getText();
        String customerName = this.sav.getTextFieldCustomer().getText();

        int rowCount = this.sav.getSelectedInvoiceRowCount();
        if (invoiceNumber.isBlank() || invoiceDate.isBlank() || customerName.isBlank() || rowCount < 1) {
            this.sav.showMessageDialog("Invalid Invoice Data");
            return;
        }

        // construct invoice lines
        float total = 0;
        InvoiceHeader ihNew = new InvoiceHeader(invoiceNumber, invoiceDate, customerName);
        ArrayList<InvoiceLine> ilsNew = new ArrayList<>();
        for (int i = 0; i < rowCount; i++) {
            try {
                if (this.sav.getInvoiceItemDetail(i, 1) == null || this.sav.getInvoiceItemDetail(i, 2) == null || this.sav.getInvoiceItemDetail(i, 3) == null) {
                    this.sav.showMessageDialog("Invalid Invoice Data");
                    return;
                }
                String itemName = (String) this.sav.getInvoiceItemDetail(i, 1);
                String itemPrice = (String) this.sav.getInvoiceItemDetail(i, 2);
                String itemCount = (String) this.sav.getInvoiceItemDetail(i, 3);
                float itemTotal = Integer.valueOf(itemCount) * Float.valueOf(itemPrice);
                total += itemTotal;
                InvoiceLine ilNew = new InvoiceLine(invoiceNumber, itemName, itemPrice);
                ilNew.setItemCount(itemCount);
                ilNew.setItemTotal(Float.toString(itemTotal));
                ilsNew.add(ilNew);
            } catch (Exception ex) {
                this.sav.showMessageDialog("Invalid Invoice Data: " + ex.getMessage());
                return;
            }
        }

        int rowIndex = this.sav.getSelectedInvoiceRow();
        if (rowIndex != -1) {
            this.sav.setInvoiceValue(invoiceNumber, rowIndex, 0);
            this.sav.setInvoiceValue(invoiceDate, rowIndex, 1);
            this.sav.setInvoiceValue(customerName, rowIndex, 2);
            this.sav.setInvoiceValue(Float.toString(total), rowIndex, 3);

            ihNew.setTotal(Float.toString(total));
            ihNew.setInvoiceLines(ilsNew);
            SalesAppDataSource.saveInvoice(invoiceNumber, ihNew);
            showInvoiceDetails();
            this.sav.showMessageDialog("Invoice Saved Successfuly");
        } else {
            this.sav.showMessageDialog("No Selected Row");
        }

    }

}
