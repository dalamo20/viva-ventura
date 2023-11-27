package com.vivaventura.presentation;

import com.vivaventura.database.*;
import com.vivaventura.model.business.exception.ServiceLoadException;
import com.vivaventura.model.business.manager.ItineraryManager;
import com.vivaventura.model.domain.*;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) throws ServiceLoadException {
        String message = "";
        System.out.println("Current Working Directory: " + System.getProperty("user.dir"));

        ItineraryManager manager = ItineraryManager.getInstance();

        User user = new User("Password1", "catDaddy@gmail.com",
                new Profile("Johnny Blaze", "222-222-2222", "Berlin", true),
                new Subscription(true, true), "catDaddy");
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Da Lat Vacation", "2023-11-23", "09:00",
                new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                        11.935173970248758, 108.4307517539685, 4.3f)));
        activities.add(new Activity("2nd Activity", "2023-11-23", "09:00",
                new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                        11.935173970248758, 108.4307517539685, 4.3f)));

        //add activities to itinerary
        Itinerary itinerary = new Itinerary("1st Itinerary", activities);

        ItineraryComposite itineraryComposite = new ItineraryComposite(1, user, null, null, null, null, List.of(itinerary));

        boolean isCreated = manager.performAction("CREATE_ITINERARY", itineraryComposite, user);

        if (isCreated) {
            message = "SUCCESS: ItineraryMain:: - Itinerary created.";
        } else {
            message = "FAIL: ItineraryMain:: - Itinerary not created.";
        }

        System.out.println(message);

        //********************** WEEK 6 ****************************************************************
        // Create a new database
        CreateDB.createNewDatabase("vivaventura.db");

        // Establish a connection to the database
        Connect.connect();

        // Create new tables
        CreateTable.createNewTable();

        // Insert new records
        InsertRecord insertRec = new InsertRecord();
        // Insert into users table
        insertRec.insertUser("pass1", "mrCats@gmail.com", "MrCats Profile", "222-222-2222", "Hawaii", true, true, "Mr.CoolCat");
        insertRec.insertUser("password2", "javaIsFun@gmail.com", "Java Profile", "222-333-4444", "Chicago", false, false, "OOP_Rock");

        // Insert into profile table
        insertRec.insertProfile("Victor Timely", "222-222-2222", "Hawaii", true);
        insertRec.insertProfile("Johnny Blaze", "222-333-4444", "Illinois", false);

        // Insert into subscription table
        insertRec.insertSubscription(true, true);
        insertRec.insertSubscription(false, false);

        // Insert into activity table
        insertRec.insertActivity("Activity 1", "2023-01-01", "10:00 AM", 1, 1);
        insertRec.insertActivity("Activity 2", "2023-01-02", "02:00 PM", 2, 2);

        // Insert into location table
        insertRec.insertLocation("Location 1", "Address 1", 20.7961, 156.3319, 4.5f, 1, 1);
        insertRec.insertLocation("Location 2", "Address 2", 40.6331, 89.3985, 4.8f, 2, 2);

        // Insert into itinerary table
        insertRec.insertItinerary("Hawaii Trip");
        insertRec.insertItinerary("Illinois Trip");

        // Select Records
        SelectRecord select = new SelectRecord();

        // Select from all tables
        select.selectAll();


    }
}

