package com.vivaventura.model.services.factory;

import com.vivaventura.model.services.compositeservice.ICompositeService;
import com.vivaventura.model.services.compositeservice.ICompositeServiceImpl;
import com.vivaventura.model.services.itineraryservice.IItineraryService;
import com.vivaventura.model.services.itineraryservice.ItineraryServiceImpl;
import com.vivaventura.model.services.loginservice.ILoginService;
import com.vivaventura.model.services.loginservice.LoginServiceImpl;
import com.vivaventura.model.services.userservice.IUserService;
import com.vivaventura.model.services.userservice.UserServiceImpl;

public class SimpleServiceFactory {
    public ILoginService getLoginService() {
        return new LoginServiceImpl();
    }
    public IItineraryService getItineraryService() {
        return new ItineraryServiceImpl();
    }
    public IUserService getUserService() {
        return new UserServiceImpl();
    }
    public ICompositeService getCompositeService() {
        return new ICompositeServiceImpl();
    }
}
