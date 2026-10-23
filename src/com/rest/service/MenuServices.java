package com.rest.service;

import com.rest.models.Menu;
import com.rest.repository.Menurepository;

public class MenuServices {
    private final Menurepository menuRepository;

    public MenuServices() {
        menuRepository = new Menurepository();
    }

    public void displayAllItems() {
        for (Menu item : menuRepository.getItems()) {
            System.out.println("Item ID: " + item.getId() + " Name: " + item.getName() + " Price: " + item.getPrice());
        }
    }

    public void addItem(int id, String name, double price) {
        menuRepository.add(id, name, price);
    }

    public void removeItem(int id) {
        menuRepository.remove(id);
    }
}