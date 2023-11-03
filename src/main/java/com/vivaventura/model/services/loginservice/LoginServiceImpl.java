package com.vivaventura.model.services.loginservice;

import com.vivaventura.model.domain.User;

public class LoginServiceImpl implements ILoginService {
    @Override
    public boolean authenticateUser(User user) {
        System.out.println("Entering method LoginServiceImpl::authenticateUser");
        return true;
    }
}
