package com.vivaventura.model.services.loginservice;

import com.vivaventura.model.domain.ItineraryComposite;
import com.vivaventura.model.domain.User;
import com.vivaventura.model.services.IService;
import com.vivaventura.model.services.exception.LoginException;

public interface ILoginService extends IService {
    public final String NAME = "ILoginService";
    public boolean authenticateUser(ItineraryComposite itineraryComposite) throws LoginException;
}
