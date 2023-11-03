package com.vivaventura.model.services.loginservice;

import com.vivaventura.model.domain.User;

public interface IUserService {
    //add User
    public default void addUser(User user){};

    //get User
    public default void getUser(User user){};

    //update User
    public default void updateUser(User user){};

    //delete User
    public default void deleteUser(User user){};

    //list all users
    public default void listUsers(User user){};
}
