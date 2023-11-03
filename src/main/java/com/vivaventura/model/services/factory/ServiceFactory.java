package com.vivaventura.model.services.factory;

import com.vivaventura.model.services.loginservice.ILoginService;
import com.vivaventura.model.services.loginservice.LoginServiceImpl;

public class ServiceFactory {
    public ILoginService getLoginService() {
        return new LoginServiceImpl();
    }
}
