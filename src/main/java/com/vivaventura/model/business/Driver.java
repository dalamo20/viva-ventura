package com.vivaventura.model.business;

import com.vivaventura.model.business.exception.ServiceLoadException;
import com.vivaventura.model.domain.Profile;
import com.vivaventura.model.domain.Subscription;
import com.vivaventura.model.domain.User;
import com.vivaventura.model.services.IService;
import com.vivaventura.model.services.factory.ServiceFactory;
import com.vivaventura.model.services.loginservice.ILoginService;

public class Driver {
    public static void main(String[] args) throws ServiceLoadException {
        //WEEK 1
        User user1 = new User("CatsAreCool", "catDaddy@pawmail.com", new Profile("Johnny Blaze", "222-222-2222", "Berlin", true), new Subscription(true, true), "catDaddy");

        User user = new User();
        user.setEmail("test@example.com");
        System.out.println("This is a test : " + user.getEmail());

        // Print the user1 object
        System.out.println("User1 object: ");
        System.out.println("Username: " + user1.getUsername());
        System.out.println("Email: " + user1.getEmail());
        //Access Profile class from User class
        System.out.println("Profile name: " + user1.getProfile().getName());


        //WEEK 4
        try {
            //store key service name in variable from applicaiton.properties
            String serviceName = "loginService";
            //create instance
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            //call service using key service name
            IService loginService = serviceFactory.getService(serviceName);

            System.out.println("Service loaded successfully: " + loginService.getClass().getName());
        } catch (ServiceLoadException e) {
            System.out.println("Error loading service: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

