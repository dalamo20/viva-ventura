package com.vivaventura.model.services.userservice;

import com.vivaventura.model.domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private static final Logger logger = LogManager.getLogger(IUserService.class);
    private List<User> users;

    //initialize users
    public UserServiceImpl(List<User> users) {
        this.users = users;
    }

    //create new user
    public void createUser(User user) {
        users.add(user);
        logger.info("User " + user.getUsername() + " created.");
    }

    //get username
    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                logger.info("User " + username + " retrieved.");
                return user;
            }
        }
        logger.warn("User " + username + " not found!");
        return null; // User not found
    }

    //update user
    public void updateUser(String username, User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getUsername().equals(username)) {
                users.set(i, updatedUser);
                logger.info("Updated user: " + username);
                return;
            }
        }
        logger.warn("User " + username + " not found!");
    }

    //delete using username
    public void deleteUser(String username) {
        boolean remove = users.removeIf(user -> user.getUsername().equals(username));
        if (remove) {
            logger.info("User " + username +  " deleted.");
        } else {
            logger.warn("User " + username + " not found!");
        }
    }
}
