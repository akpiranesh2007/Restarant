package com.rest.CLI;

import com.rest.models.Payment;
import com.rest.service.PaymentServices;
import java.util.Scanner;

public class PaymentCli {
    private final PaymentServices services;
    Scanner scanner = new Scanner(System.in);

    public PaymentCli(PaymentServices services) {
        this.services = services;
    }

    public void start() {
        int choice;
        do {
            System.out.println("Payment Management");
            System.out.println("1. All Payments");
            System.out.println("2. Create Payment");
            System.out.println("3. Pay");
            System.out.println("0. Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    services.displayAllPayments();
                    break;
                case 2:
                    System.out.println("Enter Payment ID:");
                    int id = scanner.nextInt();
                    System.out.println("Enter Order ID:");
                    int orderId = scanner.nextInt();
                    System.out.println("Enter Amount:");
                    double amount = scanner.nextDouble();
                    System.out.println("Method: 1. Cash  2. Card  3. UPI");
                    int m = scanner.nextInt();
                    Payment.method method;
                    switch (m) {
                        case 1:
                            method = Payment.method.cash;
                            break;
                        case 2:
                            method = Payment.method.card;
                            break;
                        case 3:
                            method = Payment.method.upi;
                            break;
                        default:
                            System.out.println("Invalid method");
                            continue;
                    }
                    services.createPayment(id, orderId, amount, method);
                    break;
                case 3:
                    System.out.println("Enter Payment ID:");
                    services.pay(scanner.nextInt());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }
}