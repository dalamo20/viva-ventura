package com.vivaventura.model.services.factory;

import com.vivaventura.model.services.loginservice.ILoginService;
import com.vivaventura.model.services.loginservice.IUserService;
import com.vivaventura.model.services.loginservice.LoginServiceImpl;
import com.vivaventura.model.services.loginservice.UserServiceImpl;

public class ServiceFactory {
    public ILoginService getLoginService() {
        return new LoginServiceImpl();
    }

    public IUserService getUserService() {
        return new UserServiceImpl();
    }
}
