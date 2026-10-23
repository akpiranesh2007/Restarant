package com.rest.repository;

import java.util.ArrayList;
import java.util.List;
import com.rest.models.Menu;

public class Menurepository{
    private final List<Menu> items = new ArrayList<>();

    public Menurepository() {
        items.add(new Menu(1, "Masala Dosa", 80.0));
        items.add(new Menu(2, "Veg Biryani", 150.0));
        items.add(new Menu(3, "Filter Coffee", 30.0));
    }

    public List<Menu> getItems() {
        return items;
    }

    public List<Menu> add(int id, String name, double price) {
        items.add(new Menu(id, name, price));
        return items;
    }

    public List<Menu> remove(int id) {
        items.removeIf(item -> item.getId() == id);
        return items;
    }
}