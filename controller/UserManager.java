package controller;

import model.User;

import java.util.HashMap;

public class UserManager {
    private HashMap<String, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public User getUser(String username) {
        return users.get(username);
    }
}


