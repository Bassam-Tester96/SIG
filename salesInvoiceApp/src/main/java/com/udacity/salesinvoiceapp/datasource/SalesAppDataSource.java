package com.udacity.salesinvoiceapp.datasource;

import com.udacity.salesinvoiceapp.model.InvoiceHeader;
import com.udacity.salesinvoiceapp.model.InvoiceLine;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Bassam
 */
public class SalesAppDataSource {

    private static int maxId = 0;

    private static final LinkedHashMap<String, InvoiceHeader> invoiceHeaders = new LinkedHashMap<>();
    private static final ArrayList<InvoiceLine> invoiceLines = new ArrayList<>();

    public static int getMaxId() {
        maxId++;
        return maxId;
    }

    public static boolean isEmpty() {
        return invoiceHeaders.isEmpty();
    }

    public static LinkedHashMap<String, InvoiceHeader> getInvoiceHeaders() {
        return invoiceHeaders;
    }

    public static ArrayList<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }

    public static InvoiceHeader getInvoice(String InvoiceId) {
        return invoiceHeaders.get(InvoiceId);
    }

    public static void saveInvoice(String id, InvoiceHeader iv) {
        invoiceHeaders.put(id, iv);
    }

    public static void deleteInvoice(String InvoiceId) {
        invoiceHeaders.remove(InvoiceId);
    }

    public static void loadInvoices(String invoicesPath, String invoicesItemsPath) throws IOException {
        invoiceHeaders.clear();
        invoiceLines.clear();

        // read csv file
        String line = "";
        String splitBy = ",";

        BufferedReader br = new BufferedReader(new FileReader(invoicesPath));
        while ((line = br.readLine()) != null) //returns a Boolean value  
        {
            String[] row = line.split(splitBy);
            if (Integer.valueOf(row[0]) > maxId) {
                maxId = Integer.valueOf(row[0]);
            }
            InvoiceHeader ih = new InvoiceHeader(row[0], row[1], row[2]);
            invoiceHeaders.put(ih.getId(), ih);
        }
        br.close();

        BufferedReader brInvoiceLine = new BufferedReader(new FileReader(invoicesItemsPath));
        while ((line = brInvoiceLine.readLine()) != null) //returns a Boolean value  
        {
            String[] row = line.split(splitBy);
            InvoiceLine il = new InvoiceLine(row[0], row[1], row[2]);
            il.setItemCount(row[3]);
            float itemTotal = Integer.valueOf(il.getItemCount()) * Float.valueOf(il.getItemPrice());
            il.setItemTotal(Float.toString(itemTotal));
            invoiceLines.add(il);
        }
        brInvoiceLine.close();

    }

    public static void saveInvoices(String invoicesPath, String invoicesItemsPath) throws IOException {
        FileWriter ihw = new FileWriter(invoicesPath);
        FileWriter ilw = new FileWriter(invoicesItemsPath);

        for (Map.Entry<String, InvoiceHeader> e : invoiceHeaders.entrySet()) {
            ihw.write(e.getKey() + "," + e.getValue().getDate() + "," + e.getValue().getCustomer() + "\n");
            for (InvoiceLine i : e.getValue().getInvoiceLines()) {
                ilw.write(i.getId() + "," + i.getItemName() + "," + i.getItemPrice() + "," + i.getItemCount() + "\n");
            }
        }

        ihw.close();
        ilw.close();
    }

}
