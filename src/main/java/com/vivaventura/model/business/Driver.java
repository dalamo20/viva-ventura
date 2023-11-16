package com.vivaventura.model.business;

import com.vivaventura.model.business.exception.ServiceLoadException;
import com.vivaventura.model.domain.*;
import com.vivaventura.model.services.IService;
import com.vivaventura.model.services.factory.ServiceFactory;
import com.vivaventura.model.services.loginservice.ILoginService;

import java.util.List;

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

        //WEEK 5
        //creating activities for the itinerary and use the composite class
        Activity activity1 = new Activity("Food Tour", "2024-02-04", "09:00 AM", new Location("District 1"));
        Activity activity2 = new Activity("Shopping", "2024-02-04", "07:00 PM", new Location("Ben Thanh Market"));
        Activity activity3 = new Activity("Visit Island", "2024-02-10", "07:00 AM", new Location("Phú Quốc Island"));

        Location location1 = new Location("Saigon");
        Location location2 = new Location("Phú Quốc");

        Itinerary itinerary1 = new Itinerary("Big City", List.of(activity1, activity2));
        Itinerary itinerary2 = new Itinerary("Island Fun", List.of(activity3));

//        ItineraryComposite itineraryComposite = new ItineraryComposite(
//                List.of(activity1, activity2),
//                List.of(location1, location2),
//                List.of(itinerary1, itinerary2)
//        );
        //print ItineraryComposite
//        System.out.println(itineraryComposite);


    }
}

