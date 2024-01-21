package com.vivaventura.model.services.loginservice;

import com.vivaventura.model.domain.ItineraryComposite;
import com.vivaventura.model.domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginServiceImpl implements ILoginService {
    private static final Logger logger = LogManager.getLogger(LoginServiceImpl.class);
    public boolean authenticateUser(ItineraryComposite itineraryComposite) {
        logger.debug("Entering method LoginServiceImpl::authenticateUser");
        return true;
    }
}
