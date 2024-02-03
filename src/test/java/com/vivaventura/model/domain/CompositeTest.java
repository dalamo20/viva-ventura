package com.vivaventura.model.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class CompositeTest {
    private static final Logger logger = Logger.getLogger(CompositeTest.class.getName());

    private Composite composite;

    @BeforeEach
    void setUp() {
        composite = new Composite();
    }

    @Test
    void crudItinerary() {
        //add
        Itinerary itinerary = new Itinerary(1, "First Itinerary Test");
        composite.addItinerary(itinerary);
//        logger.log(Level.INFO, "Added Itinerary: " + itinerary);

        //get
        Itinerary retrievedItinerary = composite.getItinerary(1);
        assertNotNull(retrievedItinerary);
        assertEquals(itinerary.getName(), retrievedItinerary.getName());
//        logger.log(Level.INFO, "Retrieved Itinerary: " + retrievedItinerary);

        //update
        retrievedItinerary.setName("THIS Itinerary HAS BEEN UPDATED");
        composite.updateItinerary(retrievedItinerary);
        Itinerary updatedItinerary = composite.getItinerary(1);
        assertEquals("THIS Itinerary HAS BEEN UPDATED", updatedItinerary.getName());
//        logger.log(Level.INFO, "Updated Itinerary: " + updatedItinerary);

        //delete
        composite.deleteItinerary(1);
        assertNull(composite.getItinerary(1));
//        logger.log(Level.INFO, "Deleted Itinerary with ID: " + itinerary.getId());
    }

    @Test
    void crudActivity() {
        //add
        Activity activity = new Activity(1, "BUNGIE JUMPING", "2024-02-14", "13:00", new Location(1, "Grand Canyon", "Grand Canyon RD", 0.0, 0.0, 5.0f));
        composite.addActivity(activity);
//        logger.log(Level.INFO, "Added Activity: " + activity);

        //get
        Activity retrievedActivity = composite.getActivity(1);
        assertNotNull(retrievedActivity);
        assertEquals(activity.getName(), retrievedActivity.getName());
//        logger.log(Level.INFO, "Retrieved Activity: " + retrievedActivity);

        //update
        retrievedActivity.setName("DINNER DATE");
        retrievedActivity.setDate("2024-01-28");
        retrievedActivity.setLocation(new Location("McDonalds"));
        composite.updateActivity(retrievedActivity);
        Activity updatedActivity = composite.getActivity(1);
        assertEquals("DINNER DATE", updatedActivity.getName());
//        logger.log(Level.INFO, "Updated Activity: " + updatedActivity);

        //delete
        composite.deleteActivity(1);
        assertNull(composite.getActivity(1));
//        logger.log(Level.INFO, "Deleted Activity with ID: "+ activity.getId());
    }

    @Test
    void crudLocation() {
        //add
        Location location = new Location(1, "Grand Canyon", "Grand RD", 0.0, 0.0, 5.0f);
        composite.addLocation(location);
//        logger.log(Level.INFO, "Added location: " + location);

        //get
        Location retrievedLocation = composite.getLocation(1);
        assertNotNull(retrievedLocation);
        assertEquals(location.getName(), retrievedLocation.getName());
//        logger.log(Level.INFO, "Retrieved Location: " + retrievedLocation);

        //update
        retrievedLocation.setName("Movies");
        composite.updateLocation(retrievedLocation);
        Location updatedLocation = composite.getLocation(1);
        assertEquals("Movies", updatedLocation.getName());
//        logger.log(Level.INFO, "Updated Location: " + updatedLocation);

        //delete
        composite.deleteLocation(1);
        assertNull(composite.getLocation(1));
//        logger.log(Level.INFO, "Location DELETED with ID: " + location.getId());
    }

    @Test
    void getItineraries() {
        Itinerary itinerary1 = new Itinerary(1, "Itinerary 1");
        Itinerary itinerary2 = new Itinerary(2, "Itinerary 2");
        composite.addItinerary(itinerary1);
        composite.addItinerary(itinerary2);

        List<Itinerary> allItineraries = composite.getAllItineraries();
        assertNotNull(allItineraries);
        assertEquals(2, allItineraries.size());
//        logger.log(Level.INFO, "List of Itineraries: " + allItineraries);
    }

    @Test
    void getActivities() {
        Activity activity1 = new Activity(1, "DATE", "2024-02-14", "13:00", new Location(1, "RESTAURANT", "121 SOME STREET", 0.0, 0.0, 5.0f));
        Activity activity2 = new Activity(2, "HOMEWORK", "2024-01-29", "08:00", new Location(2, "HOME", "Some Address", 0.0, 0.0, 2.0f));
        composite.addActivity(activity1);
        composite.addActivity(activity2);

        List<Activity> allActivities = composite.getAllActivities();
        assertNotNull(allActivities);
        assertEquals(2, allActivities.size());
//        logger.log(Level.INFO, "List of Activities: " + allActivities);
    }

    @Test
    void getLocations() {
        Location location1 = new Location(1, "RESTAURANT", "121 SOME STREET", 0.0, 0.0, 5.0f);
        Location location2 = new Location(2, "HOME", "Some Address", 0.0, 0.0, 2.0f);
        composite.addLocation(location1);
        composite.addLocation(location2);

        List<Location> allLocations = composite.getAllLocations();
        assertNotNull(allLocations);
        assertEquals(2, allLocations.size());
//        logger.log(Level.INFO, "List of Locations: " + allLocations);
    }
}