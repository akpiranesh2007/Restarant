package com.rest.service;

import com.rest.models.Payment;
import com.rest.repository.PaymentRepository;

public class PaymentServices {
    private final PaymentRepository paymentRepository;

    public PaymentServices() {
        paymentRepository = new PaymentRepository();
    }

    public void displayAllPayments() {
        for (Payment payment : paymentRepository.getPayments()) {
            System.out.println("Payment ID: " + payment.getId()
                    + " Order ID: " + payment.getOrderId()
                    + " Amount: " + payment.getAmount()
                    + " Method: " + payment.getPaymentMethod()
                    + " Status: " + payment.getStatus());
        }
    }

    public void createPayment(int id, int orderId, double amount, Payment.method method) {
        if (paymentRepository.findById(id) != null) {
            System.out.println("Payment ID already exists");
            return;
        }
        paymentRepository.add(id, orderId, amount, method);
    }

    public void pay(int id) {
        Payment payment = paymentRepository.findById(id);
        if (payment == null) {
            System.out.println("Payment not found");
        } else if (payment.getStatus() == Payment.paymentStatus.paid) {
            System.out.println("Already paid");
        } else {
            payment.pay();
            System.out.println("Payment successful");
        }
    }
}