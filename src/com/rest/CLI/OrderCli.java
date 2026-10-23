package com.rest.CLI;

import com.rest.service.OrderServices;
import java.util.Scanner;

public class OrderCli {
    private final OrderServices services;
    Scanner scanner = new Scanner(System.in);

    public OrderCli(OrderServices services) {
        this.services = services;
    }

    public void start() {
        int choice;
        do {
            System.out.println("Order Management");
            System.out.println("1. All Orders");
            System.out.println("2. Create Order");
            System.out.println("3. Add Item to Order");
            System.out.println("4. View Order");
            System.out.println("5. Complete Order");
            System.out.println("0. Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    services.displayAllOrders();
                    break;
                case 2:
                    System.out.println("Enter Order ID:");
                    int id = scanner.nextInt();
                    System.out.println("Enter Table ID:");
                    int tableId = scanner.nextInt();
                    services.createOrder(id, tableId);
                    break;
                case 3:
                    System.out.println("Enter Order ID:");
                    int orderId = scanner.nextInt();
                    System.out.println("Enter Menu Item ID:");
                    int menuId = scanner.nextInt();
                    services.addItemToOrder(orderId, menuId);
                    break;
                case 4:
                    System.out.println("Enter Order ID:");
                    services.viewOrder(scanner.nextInt());
                    break;
                case 5:
                    System.out.println("Enter Order ID:");
                    services.completeOrder(scanner.nextInt());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }
}