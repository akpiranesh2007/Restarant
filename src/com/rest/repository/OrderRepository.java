package com.rest.repository;

import java.util.ArrayList;
import java.util.List;
import com.rest.models.Order;

public class OrderRepository {
    private final List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    public Order add(int id, int tableId) {
        Order order = new Order(id, tableId);
        orders.add(order);
        return order;
    }

    public Order findById(int id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }
}