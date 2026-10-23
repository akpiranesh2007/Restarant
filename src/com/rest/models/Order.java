package com.rest.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public enum status {
        pending, completed
    }

    private int id;
    private int tableId;
    private status orderStatus;
    private final List<Menu> items = new ArrayList<>();

    public Order(int id, int tableId) {
        this.id = id;
        this.tableId = tableId;
        this.orderStatus = status.pending;
    }

    public int getId() {
        return id;
    }

    public int getTableId() {
        return tableId;
    }

    public status getOrderStatus() {
        return orderStatus;
    }

    public List<Menu> getItems() {
        return items;
    }

    public void addItem(Menu item) {
        items.add(item);
    }

    public double getTotal() {
        double total = 0;
        for (Menu item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void complete() {
        this.orderStatus = status.completed;
    }
}