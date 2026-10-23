package com.rest.models;

public class Payment {
    public enum method {
        cash, card, upi
    }

    public enum paymentStatus {
        pending, paid
    }

    private int id;
    private int orderId;
    private double amount;
    private method paymentMethod;
    private paymentStatus status;

    public Payment(int id, int orderId, double amount, method paymentMethod) {
        this.id = id;
        this.orderId = orderId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = paymentStatus.pending;
    }

    public int getId() {
        return id;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    public method getPaymentMethod() {
        return paymentMethod;
    }

    public paymentStatus getStatus() {
        return status;
    }

    public void pay() {
        this.status = paymentStatus.paid;
    }
}