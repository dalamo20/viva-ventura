package com.vivaventura.model.services.userservice;

import com.vivaventura.model.domain.User;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private List<User> users;

    //initialize users
    public UserServiceImpl(List<User> users) {
        this.users = users;
    }

    //create new user
    public void createUser(User user) {
        users.add(user);
    }

    //get username
    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; // User not found
    }

    //update user
    public void updateUser(String username, User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getUsername().equals(username)) {
                users.set(i, updatedUser);
                return;
            }
        }
    }

    //delete using username
    public void deleteUser(String username) {
        users.removeIf(user -> user.getUsername().equals(username));
    }
}
