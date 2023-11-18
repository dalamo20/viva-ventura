package com.vivaventura.model.services.compositeservice;

import com.vivaventura.model.business.exception.PropertyFileNotFoundException;
import com.vivaventura.model.domain.*;
import com.vivaventura.model.services.exception.CompositeException;
import com.vivaventura.model.services.manager.PropertyManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompositeServiceImplTest {
    private static ICompositeService compositeService;
    private static ItineraryComposite itineraryComposite;

    @BeforeAll
    static void setUp() {
        // Hmmm, we have to load the properties via the PropertyManager
        String propertyFileLocation = System.getProperty("prop_location");

        // Now that we have the property file location, let's have the
        // PropertyManager class load it up
        try {
            PropertyManager.loadProperties(propertyFileLocation);
        } catch (PropertyFileNotFoundException e) {
            e.printStackTrace();
            fail("PropertyFileNotFoundException");
        }

        compositeService = new CompositeServiceImpl();

        User user = new User("CatsAreCool", "catDaddy@pawmail.com", new Profile("Johnny Blaze", "222-222-2222", "Berlin", true), new Subscription(true, true), "catDaddy");
        itineraryComposite = new ItineraryComposite();
        itineraryComposite.setUser(user);
    }

    @Test
    void createItinerary() {
        try {
            assertTrue(compositeService.createItinerary(itineraryComposite, itineraryComposite.getUser()));
        } catch (CompositeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void listUserItineraries() {
        try {
            List<Itinerary> userItineraries = compositeService.listUserItineraries(itineraryComposite.getUser());
            assertNotNull(userItineraries);
        } catch (CompositeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getItineraryById() {
        try {
            Itinerary itinerary = compositeService.getItineraryById(itineraryComposite.getId());
            assertNotNull(itinerary);
        } catch (CompositeException e) {
            e.printStackTrace();
        }
    }

//    @Test
//    void updateItinerary() {
//        try {
//            assertTrue(compositeService.updateItinerary(itineraryComposite));
//        } catch (CompositeException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    void deleteItinerary() {
//        try {
//            assertTrue(compositeService.deleteItinerary(itineraryComposite.getId()));
//        } catch (CompositeException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    void listActivitiesInItinerary() {
        try {
            List<Activity> activities = compositeService.listActivitiesInItinerary(itineraryComposite.getId());
            assertNotNull(activities);
        } catch (CompositeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void createActivity() {
        Activity activity = new Activity("Explore Crazy House", "2023-11-23", "09:00",
                new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                        11.935173970248758, 108.4307517539685, 4.3f));
        try {
            assertTrue(compositeService.createActivity(activity, itineraryComposite.getId()));
        } catch (CompositeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void updateActivity() {
        Activity activity = new Activity("Explore Crazy House", "2023-11-23", "09:00",
                new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                        11.935173970248758, 108.4307517539685, 4.3f));
        try {
            assertTrue(compositeService.updateActivity(activity, itineraryComposite.getId()));
        } catch (CompositeException e) {
            e.printStackTrace();
        }
    }

//    @Test
//    void deleteActivity() {
//        Activity activityToDelete = new Activity("Hiking", "Enjoying nature", "09:00 AM");
//        try {
//            assertTrue(compositeService.deleteActivity(activityToDelete.getId(), itineraryComposite.getId()));
//        } catch (CompositeException e) {
//            e.printStackTrace();
//        }
//    }
}