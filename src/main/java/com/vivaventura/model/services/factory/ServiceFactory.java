package com.vivaventura.model.services.factory;

import com.vivaventura.model.services.loginservice.LoginService;
import com.vivaventura.model.services.loginservice.LoginServiceImpl;

public class ServiceFactory {

    public LoginService getLoginService() {
        return (LoginService) new LoginServiceImpl();
    }
}
