package com.vivaventura.presentation;

import com.vivaventura.database.*;
import com.vivaventura.model.business.exception.ServiceLoadException;
import com.vivaventura.model.business.manager.ItineraryManager;
import com.vivaventura.model.domain.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Driver extends Application {
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"));
        URL cssResource = getClass().getResource("styles.css");
        if (cssResource != null) {
            scene.getStylesheets().add(cssResource.toExternalForm());
        } else {
            System.err.println("Styles.css not found!");
        }
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Driver.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws ServiceLoadException {
        launch(args);

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
//        // Create a new database
//        CreateDB.createNewDatabase("vivaventura.db");
//
//        // Establish a connection to the database
//        Connect.connect();
//
//        // Create new tables
//        CreateTable.createNewTable();
//
//        // Insert new records
//        InsertRecord insertRec = new InsertRecord();
//        // Insert into users table
//        insertRec.insertUser("pass1", "mrCats@gmail.com", "MrCats Profile", "222-222-2222", "Hawaii", true, true, "Mr.CoolCat");
//        insertRec.insertUser("password2", "javaIsFun@gmail.com", "Java Profile", "222-333-4444", "Chicago", false, false, "OOP_Rock");
//
//        // Insert into profile table
//        insertRec.insertProfile("Victor Timely", "222-222-2222", "Hawaii", true);
//        insertRec.insertProfile("Johnny Blaze", "222-333-4444", "Illinois", false);
//
//        // Insert into subscription table
//        insertRec.insertSubscription(true, true);
//        insertRec.insertSubscription(false, false);
//
//        // Insert into activity table
//        insertRec.insertActivity("Activity 1", "2023-01-01", "10:00 AM", 1, 1);
//        insertRec.insertActivity("Activity 2", "2023-01-02", "02:00 PM", 2, 2);
//
//        // Insert into location table
//        insertRec.insertLocation("Location 1", "Address 1", 20.7961, 156.3319, 4.5f, 1, 1);
//        insertRec.insertLocation("Location 2", "Address 2", 40.6331, 89.3985, 4.8f, 2, 2);
//
//        // Insert into itinerary table
//        insertRec.insertItinerary("Hawaii Trip");
//        insertRec.insertItinerary("Illinois Trip");

        // Select Records
        SelectRecord select = new SelectRecord();

        // Select from all tables
//        select.selectAll();

        //********************** WEEK 7 ****************************************************************
        // Select from activity table
        select.selectTable("activity");

        // Update activity table
//        UpdateRecord updatedRecord = new UpdateRecord();

        //i must 1st select the id to update, then set the new name, date and time
//        updatedRecord.updateActivity(2, "Updated_Activity", "2023-11-29", "14:00");

        // Delete from activity table
//        DeleteRecord deleteRec = new DeleteRecord();

//        deleteRec.deleteRecord(3, "activity");

    }

}

