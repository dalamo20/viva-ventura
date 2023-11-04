package com.vivaventura.model.services.factory;

import com.vivaventura.model.services.loginservice.ILoginService;
import com.vivaventura.model.services.userservice.IUserService;
import com.vivaventura.model.services.loginservice.LoginServiceImpl;

public class ServiceFactory {
    private IUserService userService;
    public ILoginService getLoginService() {
        return new LoginServiceImpl();
    }

    public IUserService getUserService() {
        return userService;
    }
}
