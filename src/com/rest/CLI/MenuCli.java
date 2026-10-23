package com.rest.CLI;

import com.rest.service.MenuServices;
import java.util.Scanner;

public class MenuCli {
    private final MenuServices services;
    Scanner scanner = new Scanner(System.in);

    public MenuCli(MenuServices services) {
        this.services = services;
    }

    public void start() {
        int choice;
        do {
            System.out.println("Menu Management");
            System.out.println("1. All Items");
            System.out.println("2. Add Item");
            System.out.println("3. Remove Item");
            System.out.println("0. Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    services.displayAllItems();
                    break;
                case 2:
                    System.out.println("Enter ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.println("Enter Name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter Price:");
                    double price = scanner.nextDouble();
                    services.addItem(id, name, price);
                    break;
                case 3:
                    System.out.println("Enter ID:");
                    int removeId = scanner.nextInt();
                    services.removeItem(removeId);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }
}