package com.vivaventura.model.services.loginservice;

import com.vivaventura.model.domain.Profile;
import com.vivaventura.model.domain.Subscription;
import com.vivaventura.model.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceImplTest {

    @Test
    void authenticateUser() {
        //creating instance of LoginServiceImpl
        ILoginService loginService = new LoginServiceImpl();

        User user1 = new User("CatsAreCoolest", "catDaddy@pawmail.com", new Profile("Johnny Blaze", "222-222-2222", "Berlin", false), new Subscription(false, false), "catDaddy");

        //call the authenticateUser method from LoginServiceImpl
        boolean result = loginService.authenticateUser(user1);
        assertTrue(result);
    }
}