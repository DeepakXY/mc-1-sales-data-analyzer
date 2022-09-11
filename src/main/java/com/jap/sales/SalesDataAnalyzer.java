package com.jap.sales;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SalesDataAnalyzer {
    // Read the data from the file and store in a List
    public List<SalesRecord> readFile(String fileName) {
        List<SalesRecord> salesRecords = new ArrayList<>();
        int countLines = 0;
        try (
                FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            String headers = bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                countLines++;
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("count " + countLines);
        SalesRecord[] salesRecord = new SalesRecord[countLines];
        try (
                FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            String line = bufferedReader.readLine();
            int index = 0;
            while ((line = bufferedReader.readLine()) != null) {
                // 2016 Survey Response Q9a The following adequately support my work-related needs: City Manager�s Office 31.4 40.6 9.5
                String[] dataInfo = line.split(",");
                int customerId = Integer.parseInt(dataInfo[1]);
                String date = dataInfo[0].trim();
                int productCategory = Integer.parseInt(dataInfo[2]);
                String paymentMethod = dataInfo[3].trim();
                double amount = Double.parseDouble(dataInfo[4].trim());
                double timeOnSite = Double.parseDouble(dataInfo[5].trim());
                int clicksInSite = Integer.parseInt(dataInfo[6]);
                SalesRecord newSalesRecord = new SalesRecord(date, customerId, productCategory,
                        paymentMethod, amount, timeOnSite, clicksInSite);
                salesRecord[index] = newSalesRecord;

                index++;
                salesRecords.add(newSalesRecord);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return salesRecords;

    }


    // Sort the customers based on purchase amount
    public List<SalesRecord> getAllCustomersSortedByPurchaseAmount(List<SalesRecord> salesData, AmountComparator amountComparator) {
        List<SalesRecord> list = new ArrayList<>();
        salesData.sort(amountComparator);
        return salesData;
    }

    // Find the top customer who spent the maximum time on the site
    public SalesRecord getTopCustomerWhoSpentMaxTimeOnSite(List<SalesRecord> salesData, TimeOnSiteComparator timeOnSiteComparator) {
        salesData.sort(timeOnSiteComparator);
        return salesData.get(0);
    }


}
