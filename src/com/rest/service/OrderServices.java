package com.rest.service;

import com.rest.models.Menu;
import com.rest.models.Order;
import com.rest.models.Table;
import com.rest.repository.OrderRepository;

public class OrderServices {
    private final OrderRepository orderRepository;
    private final TableServices tableServices;
    private final MenuServices menuServices;

    public OrderServices(TableServices tableServices, MenuServices menuServices) {
        this.orderRepository = new OrderRepository();
        this.tableServices = tableServices;
        this.menuServices = menuServices;
    }

    public void displayAllOrders() {
        for (Order order : orderRepository.getOrders()) {
            System.out.println("Order ID: " + order.getId()
                    + " Table ID: " + order.getTableId()
                    + " Items: " + order.getItems().size()
                    + " Total: " + order.getTotal()
                    + " Status: " + order.getOrderStatus());
        }
    }

    public void createOrder(int id, int tableId) {
        if (orderRepository.findById(id) != null) {
            System.out.println("Order ID already exists");
            return;
        }
        Table table = tableServices.getTable(tableId);
        if (table == null) {
            System.out.println("Table not found");
            return;
        }
        if (table.getStatus() == Table.availability.occupied) {
            System.out.println("Table is already occupied");
            return;
        }
        table.bookTable();
        orderRepository.add(id, tableId);
        System.out.println("Order created");
    }

    public void addItemToOrder(int orderId, int menuId) {
        Order order = orderRepository.findById(orderId);
        if (order == null) {
            System.out.println("Order not found");
            return;
        }
        if (order.getOrderStatus() == Order.status.completed) {
            System.out.println("Order is already completed");
            return;
        }
        Menu item = menuServices.getItem(menuId);
        if (item == null) {
            System.out.println("Menu item not found");
            return;
        }
        order.addItem(item);
        System.out.println("Added " + item.getName());
    }

    public void viewOrder(int orderId) {
        Order order = orderRepository.findById(orderId);
        if (order == null) {
            System.out.println("Order not found");
            return;
        }
        System.out.println("Order ID: " + order.getId() + " Table ID: " + order.getTableId()
                + " Status: " + order.getOrderStatus());
        for (Menu item : order.getItems()) {
            System.out.println("  " + item.getName() + " - " + item.getPrice());
        }
        System.out.println("Total: " + order.getTotal());
    }

    public void completeOrder(int orderId) {
        Order order = orderRepository.findById(orderId);
        if (order == null) {
            System.out.println("Order not found");
            return;
        }
        if (order.getOrderStatus() == Order.status.completed) {
            System.out.println("Order is already completed");
            return;
        }
        order.complete();
        Table table = tableServices.getTable(order.getTableId());
        if (table != null) {
            table.freeTable();
        }
        System.out.println("Order completed. Total: " + order.getTotal());
    }
}