package com.vivaventura.presentation;

import com.vivaventura.model.business.exception.ServiceLoadException;
import com.vivaventura.model.domain.*;
import com.vivaventura.model.services.IService;
import com.vivaventura.model.services.factory.ServiceFactory;
import com.vivaventura.model.services.loginservice.ILoginService;

import java.util.List;

public class Driver {
    public static void main(String[] args) throws ServiceLoadException {
        String message = "";
//        FlightReservationManager manager = FlightReservationManager.getInstance();
//
//        User user1 = new User("Password1", "catDaddy@gmail.com",
//                new Profile("Johnny Blaze", "222-222-2222", "Berlin", true),
//                new Subscription(true, true), "catDaddy");
//        Flight flight = new Flight(200, "New York", "Los Angeles",
//                LocalDateTime.parse("2021-04-15T12:00"),
//                LocalDateTime.parse("2021-04-15T14:00"),
//                "Airbus A320", 150);
//
//        Composite composite = new Composite();
//        composite.setTraveler(traveler);
//        composite.setFlight(flight);
//
//        //composite.setTraveler(null);;
//
//        boolean isBooked = manager.performAction("BOOKRESERVATION", composite);

        // Ignore the weird code in the sample code, which does the same thing as this.   It's a Java short cut.
//        if (isBooked) {
//            message = "SUCCESS:  FlightReservationMain:: - Traveler resistered.";
//        } else {
//            message = "FAIL:  FlightReservationMain:: - Traveler not registered.";
//        }

        System.out.println(message);

    }
}

