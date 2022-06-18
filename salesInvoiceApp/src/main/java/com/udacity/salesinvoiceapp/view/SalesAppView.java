/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.udacity.salesinvoiceapp.view;

import com.udacity.salesinvoiceapp.model.InvoiceLine;
import com.udacity.salesinvoiceapp.model.InvoiceHeader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.CellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bassam
 */
public class SalesAppView extends javax.swing.JFrame {

    public SalesAppView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        panelLeft = new javax.swing.JPanel();
        labelInvoices = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableInvoices = new javax.swing.JTable();
        buttonCreateInvoice = new javax.swing.JButton();
        buttonDeleteInvoice = new javax.swing.JButton();
        panelRight = new javax.swing.JPanel();
        panelInvoiceItems = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableInvoiceItems = new javax.swing.JTable();
        buttonAddItem = new javax.swing.JButton();
        buttonRemoveItem = new javax.swing.JButton();
        labelInvoiceNumber = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttonSave = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        textFieldInvoiceDate = new javax.swing.JTextField();
        textFieldCustomer = new javax.swing.JTextField();
        textFieldInvoiceTotal = new javax.swing.JTextField();
        textFieldInvoiceNumber = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemLoad = new javax.swing.JMenuItem();
        menuItemSave = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMain.setBackground(new java.awt.Color(204, 204, 204));

        labelInvoices.setText("Invoices Tables");

        tableInvoices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Date", "Customer", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableInvoices.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableInvoices.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tableInvoices);

        buttonCreateInvoice.setText("Create New Invoice");

        buttonDeleteInvoice.setText("Delete Invoice");

        javax.swing.GroupLayout panelLeftLayout = new javax.swing.GroupLayout(panelLeft);
        panelLeft.setLayout(panelLeftLayout);
        panelLeftLayout.setHorizontalGroup(
            panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLeftLayout.createSequentialGroup()
                .addGroup(panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLeftLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelInvoices)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLeftLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(buttonCreateInvoice)
                        .addGap(18, 18, 18)
                        .addComponent(buttonDeleteInvoice)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        panelLeftLayout.setVerticalGroup(
            panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelInvoices)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCreateInvoice)
                    .addComponent(buttonDeleteInvoice))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        panelInvoiceItems.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 1), "Invoice Items"));

        tableInvoiceItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No.", "Item Name", "Item Price", "Count", "Item Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableInvoiceItems);

        buttonAddItem.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        buttonAddItem.setText("Add Item");

        buttonRemoveItem.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        buttonRemoveItem.setText("Remove Item");

        javax.swing.GroupLayout panelInvoiceItemsLayout = new javax.swing.GroupLayout(panelInvoiceItems);
        panelInvoiceItems.setLayout(panelInvoiceItemsLayout);
        panelInvoiceItemsLayout.setHorizontalGroup(
            panelInvoiceItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInvoiceItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInvoiceItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                    .addGroup(panelInvoiceItemsLayout.createSequentialGroup()
                        .addComponent(buttonAddItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonRemoveItem)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelInvoiceItemsLayout.setVerticalGroup(
            panelInvoiceItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInvoiceItemsLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelInvoiceItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRemoveItem, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        labelInvoiceNumber.setText("Invoice Number");

        jLabel2.setText("Invoice Date");

        jLabel3.setText("Customer Name");

        jLabel4.setText("Invoice Total");

        buttonSave.setText("Save");

        buttonCancel.setText("Cancel");

        textFieldInvoiceTotal.setEditable(false);
        textFieldInvoiceTotal.setBorder(null);

        textFieldInvoiceNumber.setEditable(false);
        textFieldInvoiceNumber.setBorder(null);

        javax.swing.GroupLayout panelRightLayout = new javax.swing.GroupLayout(panelRight);
        panelRight.setLayout(panelRightLayout);
        panelRightLayout.setHorizontalGroup(
            panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelInvoiceItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRightLayout.createSequentialGroup()
                        .addGroup(panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelInvoiceNumber)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(28, 28, 28)
                        .addGroup(panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldInvoiceTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldInvoiceDate, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(textFieldCustomer)
                            .addComponent(textFieldInvoiceNumber))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRightLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonSave)
                .addGap(18, 18, 18)
                .addComponent(buttonCancel)
                .addGap(168, 168, 168))
        );

        panelRightLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, labelInvoiceNumber});

        panelRightLayout.setVerticalGroup(
            panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelInvoiceNumber)
                    .addComponent(textFieldInvoiceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRightLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(6, 6, 6)
                        .addGroup(panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldInvoiceTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(panelRightLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textFieldInvoiceDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelInvoiceItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSave)
                    .addComponent(buttonCancel))
                .addContainerGap())
        );

        panelRightLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, labelInvoiceNumber});

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addComponent(panelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        menuItemLoad.setText("Load");
        jMenu1.add(menuItemLoad);

        menuItemSave.setText("Save");
        jMenu1.add(menuItemSave);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void showMessageDialog(String msg) {
        JOptionPane.showMessageDialog(rootPane, msg);
    }

    public String chooseFileToOpen() throws IOException {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.csv", "csv");
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(filter);

        int response = fc.showOpenDialog(rootPane);
        if (response != JFileChooser.APPROVE_OPTION) {
            return null;
        }
        return fc.getSelectedFile().getAbsolutePath();
    }

    public String chooseFileToSave() throws IOException {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.csv", "csv");
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(filter);

        int response = fc.showSaveDialog(rootPane);
        if (response != JFileChooser.APPROVE_OPTION) {
            return null;
        }
        return fc.getSelectedFile().getCanonicalPath();
    }

    public void createInvoicesTable(Map<String, InvoiceHeader> invoiceHeaders, ArrayList<InvoiceLine> invoiceLines) {
        DefaultTableModel dtm = (DefaultTableModel) tableInvoices.getModel();
        dtm.setRowCount(0);

        for (Map.Entry<String, InvoiceHeader> entry : invoiceHeaders.entrySet()) {
            float total = 0;
            ArrayList<InvoiceLine> ils = new ArrayList<>();
            for (InvoiceLine il : invoiceLines) {
                if (il.getId().equals(entry.getKey())) {
                    total = total + Float.valueOf(il.getItemTotal());
                    ils.add(il);
                }
            }
            entry.getValue().setInvoiceLines(ils);
            entry.getValue().setTotal(Float.toString(total));

            String tableRow[] = {entry.getValue().getId(), entry.getValue().getDate(), entry.getValue().getCustomer(), Float.toString(total)};
            dtm.addRow(tableRow);
        }
    }

    public int getSelectedInvoiceRow() {
        return tableInvoices.getSelectedRow();
    }

    public int getSelectedInvoiceRowCount() {
        return ((DefaultTableModel) tableInvoiceItems.getModel()).getRowCount();
    }

    public String getSelectedInvoiceId(int rowIndex) {
        return (String) tableInvoices.getModel().getValueAt(rowIndex, 0);
    }

    public void setInvoiceValue(Object val, int row, int column) {
        DefaultTableModel dt = (DefaultTableModel) tableInvoices.getModel();
        dt.setValueAt(val, row, column);
    }

    public void addInvoice(String id) {
        DefaultTableModel dtm = (DefaultTableModel) tableInvoices.getModel();
        String row[] = {id};
        dtm.addRow(row);
    }

    public void deleteInvoice(int rowIndex) {
        DefaultTableModel dtm = (DefaultTableModel) tableInvoices.getModel();
        dtm.removeRow(rowIndex);
        textFieldInvoiceNumber.setText("");
        textFieldInvoiceDate.setText("");
        textFieldCustomer.setText("");
        textFieldInvoiceTotal.setText("");
        ((DefaultTableModel) tableInvoiceItems.getModel()).setRowCount(0);
    }

    public void showInvoiceDetails(InvoiceHeader ih) {
        int rowIndex = tableInvoices.getSelectedRow();
        if (rowIndex != -1) {

            String invoiceNumber = "";
            String invoiceDate = "";
            String customerName = "";
            String invoiceTotal = "";

            if (tableInvoices.getModel().getValueAt(rowIndex, 0) != null) {
                invoiceNumber = (String) tableInvoices.getModel().getValueAt(rowIndex, 0);
            }
            if (tableInvoices.getModel().getValueAt(rowIndex, 1) != null) {
                invoiceDate = (String) tableInvoices.getModel().getValueAt(rowIndex, 1);
            }
            if (tableInvoices.getModel().getValueAt(rowIndex, 2) != null) {
                customerName = (String) tableInvoices.getModel().getValueAt(rowIndex, 2);
            }
            if (tableInvoices.getModel().getValueAt(rowIndex, 3) != null) {
                invoiceTotal = (String) tableInvoices.getModel().getValueAt(rowIndex, 3);
            }

            textFieldInvoiceNumber.setText(invoiceNumber);
            textFieldInvoiceDate.setText(invoiceDate);
            textFieldCustomer.setText(customerName);
            textFieldInvoiceTotal.setText(invoiceTotal);

            DefaultTableModel dtm = (DefaultTableModel) tableInvoiceItems.getModel();
            if (ih != null) {
                ArrayList<InvoiceLine> ils = ih.getInvoiceLines();
                if (ils != null) {
                    dtm.setRowCount(0);
                    for (InvoiceLine il : ils) {
                        String row[] = {il.getId(), il.getItemName(), il.getItemPrice(), il.getItemCount(), il.getItemTotal()};
                        dtm.addRow(row);
                    }
                } else {
                    dtm.setRowCount(0);
                }
            } else {
                dtm.setRowCount(0);
            }

        }
    }

    public void AddItem() {
        if (!textFieldInvoiceNumber.getText().isBlank()) {
            DefaultTableModel dtm = (DefaultTableModel) tableInvoiceItems.getModel();
            String row[] = {textFieldInvoiceNumber.getText()};
            dtm.addRow(row);
        }
    }

    public void removeItem() {
        int rowIndex = tableInvoiceItems.getSelectedRow();
        if (rowIndex != -1) {
            DefaultTableModel dtm = (DefaultTableModel) tableInvoiceItems.getModel();
            dtm.removeRow(rowIndex);
        }
    }

    public Object getInvoiceItemDetail(int row, int column) {
        DefaultTableModel dtm = (DefaultTableModel) tableInvoiceItems.getModel();
        return dtm.getValueAt(row, column);
    }

    public void clearInvoiceDetails() {
        textFieldInvoiceNumber.setText("");
        textFieldInvoiceDate.setText("");
        textFieldCustomer.setText("");
        textFieldInvoiceTotal.setText("");
        ((DefaultTableModel) tableInvoiceItems.getModel()).setRowCount(0);
    }

    /**
     * ******* Variables geters ********
     */
    public JButton getButtonAddItem() {
        return buttonAddItem;
    }

    public JButton getButtonRemoveItem() {
        return buttonRemoveItem;
    }

    public JButton getButtonSave() {
        return buttonSave;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    public JButton getButtonCreateInvoice() {
        return buttonCreateInvoice;
    }

    public JButton getButtonDeleteInvoice() {
        return buttonDeleteInvoice;
    }

    public JMenuItem getMenuItemLoad() {
        return menuItemLoad;
    }

    public JMenuItem getMenuItemSave() {
        return menuItemSave;
    }

    public JTable getTableInvoices() {
        return tableInvoices;
    }

    public JTextField getTextFieldCustomer() {
        return textFieldCustomer;
    }

    public JTextField getTextFieldInvoiceDate() {
        return textFieldInvoiceDate;
    }

    public JTextField getTextFieldInvoiceNumber() {
        return textFieldInvoiceNumber;
    }

    public JTextField getTextFieldInvoiceTotal() {
        return textFieldInvoiceTotal;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddItem;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonCreateInvoice;
    private javax.swing.JButton buttonDeleteInvoice;
    private javax.swing.JButton buttonRemoveItem;
    private javax.swing.JButton buttonSave;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelInvoiceNumber;
    private javax.swing.JLabel labelInvoices;
    private javax.swing.JMenuItem menuItemLoad;
    private javax.swing.JMenuItem menuItemSave;
    private javax.swing.JPanel panelInvoiceItems;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelRight;
    private javax.swing.JTable tableInvoiceItems;
    private javax.swing.JTable tableInvoices;
    private javax.swing.JTextField textFieldCustomer;
    private javax.swing.JTextField textFieldInvoiceDate;
    private javax.swing.JTextField textFieldInvoiceNumber;
    private javax.swing.JTextField textFieldInvoiceTotal;
    // End of variables declaration//GEN-END:variables
}
