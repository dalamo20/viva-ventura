package com.vivaventura.model.services.loginservice;

import com.vivaventura.model.domain.ItineraryComposite;
import com.vivaventura.model.domain.User;

public class LoginServiceImpl implements ILoginService {
    public boolean authenticateUser(ItineraryComposite itineraryComposite) {
        System.out.println("Entering method LoginServiceImpl::authenticateUser");
        return true;
    }
}
