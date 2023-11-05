package com.vivaventura.model.business;

import com.vivaventura.model.domain.Profile;
import com.vivaventura.model.domain.Subscription;
import com.vivaventura.model.domain.User;

public class Driver {
    public static void main(String[] args) {
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
        // Print other properties as needed
    }
}

