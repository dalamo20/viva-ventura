package com.vivaventura.model.services.loginservice;

import com.vivaventura.model.domain.User;
import com.vivaventura.model.services.IService;

public interface ILoginService extends IService {
    public final String NAME = "ILoginService";
    public boolean authenticateUser(User user);
}
