package com.jap.sales;


import java.util.Objects;

public class SalesRecord {

    private String date;
    private int customerId;
    private int productCategory;
    private String paymentMethod;
    private double amount;
    private double timeOnSite;
    private int clicksInSite;


    public SalesRecord() {
    }

    public SalesRecord(String date, int customerId, int productCategory, String paymentMethod, double amount, double timeOnSite, int clicksInSite) {
        this.date = date;
        this.customerId = customerId;
        this.productCategory = productCategory;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.timeOnSite = timeOnSite;
        this.clicksInSite = clicksInSite;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(int productCategory) {
        this.productCategory = productCategory;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTimeOnSite() {
        return timeOnSite;
    }

    public void setTimeOnSite(double timeOnSite) {
        this.timeOnSite = timeOnSite;
    }

    public int getClicksInSite() {
        return clicksInSite;
    }

    public void setClicksInSite(int clicksInSite) {
        this.clicksInSite = clicksInSite;
    }

    // Override the toString method


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesRecord that = (SalesRecord) o;
        return customerId == that.customerId && productCategory == that.productCategory && Double.compare(that.amount, amount) == 0 && Double.compare(that.timeOnSite, timeOnSite) == 0 && clicksInSite == that.clicksInSite && Objects.equals(date, that.date) && Objects.equals(paymentMethod, that.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, customerId, productCategory, paymentMethod, amount, timeOnSite, clicksInSite);
    }

    @Override
    public String toString() {
        return "SalesRecord{" +
                "date='" + date + '\'' +
                ", customerId=" + customerId +
                ", productCategory=" + productCategory +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", amount=" + amount +
                ", timeOnSite=" + timeOnSite +
                ", clicksInSite=" + clicksInSite +
                '}';
    }
}
