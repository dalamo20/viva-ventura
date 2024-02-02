package com.vivaventura.model.services.userservice;

import com.vivaventura.model.domain.CompositeTest;
import com.vivaventura.model.domain.Profile;
import com.vivaventura.model.domain.Subscription;
import com.vivaventura.model.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    private IUserService userService;
    private List<User> users;
    private static final Logger logger = Logger.getLogger(CompositeTest.class.getName());

    //initialize empty arrayList
    @BeforeEach
    void setUp() {
        users = new ArrayList<>();
        userService = new UserServiceImpl(users);
    }
    @Test
    void createUser() {
        User user1 = new User("CatsAreCool", "catDaddy@pawmail.com", new Profile("Johnny Blaze", "222-222-2222", "Berlin", true), new Subscription(true, true), "catDaddy");

        userService.createUser(user1); //using createUser method from UserServiceImpl
        assertTrue(users.contains(user1)); //checking if arrayList contains the user
//        logger.log(Level.INFO, "Created User: " + user1);
    }

    @Test
    void getUserByUsername() {
        User user1 = new User("CatsAreCool", "catDaddy@pawmail.com", new Profile("Johnny Blaze", "222-222-2222", "Berlin", true), new Subscription(true, true), "catDaddy");
        users.add(user1); //using getUserByUs
        //calling getUserByUsername from UserServiceImpl
        User userExists = userService.getUserByUsername("catDaddy");
        assertNotNull(userExists);
        assertEquals(user1, userExists);
//        logger.log(Level.INFO, "Retrieve User: " + userExists);
    }

    @Test
    void updateUser() {
        User user1 = new User("CatsAreCool", "catDaddy@pawmail.com", new Profile("Johnny Blaze", "222-222-2222", "Berlin", true), new Subscription(true, true), "catDaddy");
        users.add(user1);

        User updateUser1 = new User("CatsAreMoreCoolerer", "catDaddy@gmail.com", new Profile("Johnny Blaze",  "Berlin"), new Subscription(false, false), "cat_Daddy");
        //calling updateUser from UserServiceImpl
        userService.updateUser("catDaddy", updateUser1);

        User userExist = users.stream().filter(user -> user.getUsername().equals("cat_Daddy")).findFirst().orElse(null);
        assertNotNull(userExist);
        assertEquals(updateUser1, userExist);
        assertFalse(users.contains(user1));
//        logger.log(Level.INFO, "Older User: " + user1);
//        logger.log(Level.INFO, "Updated User: " + userExist);
    }

    @Test
    void deleteUser() {
        User user1 = new User("CatsAreCool", "catDaddy@pawmail.com", new Profile("Johnny Blaze", "222-222-2222", "Berlin", true), new Subscription(true, true), "catDaddy");
        users.add(user1);
        //calling deleteUser from UserServiceImpl
        userService.deleteUser("catDaddy");
        assertFalse(users.contains(user1));
//        logger.log(Level.INFO, "User deleted: " + user1);
    }
}