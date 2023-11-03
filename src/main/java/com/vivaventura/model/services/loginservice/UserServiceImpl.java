package com.vivaventura.model.services.loginservice;

import com.vivaventura.model.domain.User;

public class UserServiceImpl implements IUserService {
    //add User
    @Override
    public void addUser(User user) {
        IUserService.super.addUser(user);
    }

    //get User
    @Override
    public void getUser(User user) {
        IUserService.super.getUser(user);
    }

    //update User
    @Override
    public void updateUser(User user) {
        IUserService.super.updateUser(user);
    }

    //delete User
    @Override
    public void deleteUser(User user) {
        IUserService.super.deleteUser(user);
    }

    //list all users

    @Override
    public void listUsers(User user) {
        IUserService.super.listUsers(user);
    }
}
