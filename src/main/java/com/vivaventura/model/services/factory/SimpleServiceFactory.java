package com.vivaventura.model.services.factory;

import com.vivaventura.model.domain.User;
import com.vivaventura.model.services.compositeservice.ICompositeService;
import com.vivaventura.model.services.compositeservice.CompositeServiceImpl;
import com.vivaventura.model.services.compservice.CompSvcJDBCImpl;
import com.vivaventura.model.services.compservice.ICompSvc;
import com.vivaventura.model.services.itineraryservice.IItineraryService;
import com.vivaventura.model.services.itineraryservice.ItineraryServiceImpl;
import com.vivaventura.model.services.loginservice.ILoginService;
import com.vivaventura.model.services.loginservice.LoginServiceImpl;
import com.vivaventura.model.services.userservice.IUserService;
import com.vivaventura.model.services.userservice.UserServiceImpl;

import java.util.List;

public class SimpleServiceFactory {
    public ILoginService getLoginService() {
        return new LoginServiceImpl();
    }
    public IItineraryService getItineraryService() {
        return new ItineraryServiceImpl();
    }
    public IUserService getUserService(List<User> users) {
        return new UserServiceImpl(users);
    }
    public ICompositeService getCompositeService() {
        return new CompositeServiceImpl();
    }
    public ICompSvc getCompSvc() {
        return new CompSvcJDBCImpl();
    }
}
