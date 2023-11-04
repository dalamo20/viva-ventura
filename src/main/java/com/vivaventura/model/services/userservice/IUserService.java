package com.vivaventura.model.services.userservice;

import com.vivaventura.model.domain.User;

public interface IUserService {
    void createUser(User user);
    User getUserByUsername(String username);
    void updateUser(String username, User updatedUser);
    void deleteUser(String username);
}
