package com.vivaventura.model.services.userservice;

import com.vivaventura.model.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
