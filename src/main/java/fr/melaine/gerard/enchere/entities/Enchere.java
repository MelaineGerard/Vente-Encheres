package fr.melaine.gerard.enchere.entities;

import java.util.ArrayList;
import java.util.List;

public class Enchere {
    private final List<Item> items;
    private final List<User> users;
    private final String name;

    public Enchere(String name) {
        this.items = new ArrayList<>();
        this.users = new ArrayList<>();
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<User> getUsers() {
        return users;
    }

    public String getName() {
        return name;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public String toString() {
        return "Enchère %s avec %d produits et %d utilisateurs".formatted(name, items.size(), users.size());
    }
}
