package com.vivaventura.model.services.userservice;

import com.vivaventura.model.domain.User;
import com.vivaventura.model.services.IService;

public interface IUserService extends IService {
    public final String NAME = "IUserService";
    void createUser(User user);
    User getUserByUsername(String username);
    void updateUser(String username, User updatedUser);
    void deleteUser(String username);
}
