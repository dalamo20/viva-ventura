package com.vivaventura.model.services.loginservice;

import com.vivaventura.model.domain.User;

public interface ILoginService {
    public boolean authenticateUser(User user);
}
