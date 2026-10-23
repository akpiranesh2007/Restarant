package com.rest.repository;

import java.util.ArrayList;
import java.util.List;
import com.rest.models.Payment;

public class PaymentRepository {
    private final List<Payment> payments = new ArrayList<>();

    public List<Payment> getPayments() {
        return payments;
    }

    public Payment add(int id, int orderId, double amount, Payment.method method) {
        Payment payment = new Payment(id, orderId, amount, method);
        payments.add(payment);
        return payment;
    }

    public Payment findById(int id) {
        for (Payment payment : payments) {
            if (payment.getId() == id) {
                return payment;
            }
        }
        return null;
    }
}