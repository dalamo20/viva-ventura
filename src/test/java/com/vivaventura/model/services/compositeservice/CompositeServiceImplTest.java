package com.vivaventura.model.services.compositeservice;

import com.vivaventura.model.business.exception.PropertyFileNotFoundException;
import com.vivaventura.model.domain.*;
import com.vivaventura.model.services.exception.CompositeException;
import com.vivaventura.model.services.manager.PropertyManager;
import org.junit.jupiter.api.BeforeAll;
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

        User user = new User("CatsAreCool", "catDaddy@pawmail.com", new Profile("Johnny Blaze", "222-222-2222", "Berlin", true), new Subscription(true, true), "catDaddy");
        itineraryComposite = new ItineraryComposite();
        itineraryComposite.setUser(user);

        compositeService = new CompositeServiceImpl();
    }

    //Create Itinerary
    @Test
    void createItinerary() {
        //create a user
        User user = new User("CatsAreCool", "catDaddy@pawmail.com", new Profile("Johnny Blaze", "222-222-2222", "Berlin", true), new Subscription(true, true), "catDaddy");

        //create an itinerary
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Da Lat Vacation", "2023-11-23", "09:00",
                new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                        11.935173970248758, 108.4307517539685, 4.3f)));
        activities.add(new Activity("2nd Activity", "2023-11-23", "09:00",
                new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                        11.935173970248758, 108.4307517539685, 4.3f)));

        //add activities to itinerary
        Itinerary itinerary = new Itinerary("1st Itinerary", activities);
        //create an itinerary composite and store user and itinerary information
        ItineraryComposite itineraryComposite = new ItineraryComposite(1, user, null, null, null, null, List.of(itinerary));
        try {
            assertTrue(compositeService.createItinerary(itineraryComposite, itineraryComposite.getUser()));
        } catch (CompositeException e) {
            e.printStackTrace();
            fail("Failed to create itinerary");
        }
    }

    @Test
    void listUserItineraries() {
        try {
            List<Itinerary> userItineraries = compositeService.listUserItineraries(itineraryComposite.getUser());
            assertNotNull(userItineraries, "User itinerary list is null");
        } catch (CompositeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getItineraryById() {
        //create a user
        User user = new User("CatsAreCool", "catDaddy@pawmail.com", new Profile("Johnny Blaze", "222-222-2222", "Berlin", true), new Subscription(true, true), "catDaddy");

        //create an itinerary
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Da Lat Vacation", "2023-11-23", "09:00",
                new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                        11.935173970248758, 108.4307517539685, 4.3f)));
        activities.add(new Activity("2nd Activity", "2023-11-23", "09:00",
                new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                        11.935173970248758, 108.4307517539685, 4.3f)));

        //add activities to itinerary
        Itinerary itinerary = new Itinerary("1st Itinerary", activities);
        //create an itinerary composite and store user and itinerary information
        ItineraryComposite itineraryComposite = new ItineraryComposite(1, user, null, null, null, null, List.of(itinerary));
        try {
            Itinerary retrievedItinerary = compositeService.getItineraryById(itineraryComposite.getId());
            assertNotNull(retrievedItinerary, "Retrieved Itinerary is null");
        } catch (CompositeException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void updateItinerary() {
        //create a user
        User user = new User("CatsAreCool", "catDaddy@pawmail.com", new Profile("Johnny Blaze", "222-222-2222", "Berlin", true), new Subscription(true, true), "catDaddy");

        //create an itinerary
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Da Lat Vacation", "2023-11-23", "09:00",
                new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                        11.935173970248758, 108.4307517539685, 4.3f)));
        activities.add(new Activity("2nd Activity", "2023-11-23", "09:00",
                new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                        11.935173970248758, 108.4307517539685, 4.3f)));

        //add activities to itinerary
        Itinerary itinerary = new Itinerary("1st Itinerary", activities);
        //create an itinerary composite and store user and itinerary information
        ItineraryComposite itineraryComposite = new ItineraryComposite(1, user, null, null, null, null, List.of(itinerary));

        //add the itinerary composite to the service
        try {
            assertTrue(compositeService.createItinerary(itineraryComposite, user));
        } catch (CompositeException e) {
            e.printStackTrace();
        }

        System.out.println("Before Update:");
        System.out.println(itineraryComposite);
        System.out.println("Name: "+itineraryComposite.getItineraries().get(0).getName());
        //update the itinerary name
        Itinerary updatedItinerary = new Itinerary("Updated Itinerary", activities);
        //find the itinerary in the composite and update it
        boolean updated = itineraryComposite.getItineraries().stream()
                .filter(it -> it.getId() == itinerary.getId())
                .findFirst()
                .map(it -> {
                    // Update activities with new information
                    for (int i = 0; i < it.getActivities().size(); i++) {
                        Activity existingActivity = it.getActivities().get(i);
                        Activity updatedActivity = updatedItinerary.getActivities().get(i);
                        existingActivity.setName(updatedActivity.getName());
                        existingActivity.setDate(updatedActivity.getDate());
                        existingActivity.setTime(updatedActivity.getTime());
                        existingActivity.setLocation(updatedActivity.getLocation());
                    }
                    it.setName(updatedItinerary.getName());
                    return true;
                })
                .orElse(false);
        assertTrue(updated);
        System.out.println("\nAfter Update:");
        System.out.println(itineraryComposite);
        assertEquals("Updated Itinerary", itineraryComposite.getItineraries().get(0).getName());
        System.out.println("Name: "+itineraryComposite.getItineraries().get(0).getName());
    }



    @Test
    void deleteItinerary() {
        //create a user
        User user = new User("CatsAreCool", "catDaddy@pawmail.com", new Profile("Johnny Blaze", "222-222-2222", "Berlin", true), new Subscription(true, true), "catDaddy");

        //create an itinerary
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Da Lat Vacation", "2023-11-23", "09:00",
                new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                        11.935173970248758, 108.4307517539685, 4.3f)));
        activities.add(new Activity("2nd Activity", "2023-11-23", "09:00",
                new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                        11.935173970248758, 108.4307517539685, 4.3f)));

        //add activities to itinerary
        Itinerary itinerary = new Itinerary("1st Itinerary", activities);
        //create an itinerary composite and store user and itinerary information
        ItineraryComposite itineraryComposite = new ItineraryComposite(1, user, null, null, null, null, List.of(itinerary));
        try {
            assertTrue(compositeService.deleteItinerary(itineraryComposite.getId()));
        } catch (CompositeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void listActivitiesInItinerary() {
        //create a user
        User user = new User("CatsAreCool", "catDaddy@pawmail.com", new Profile("Johnny Blaze", "222-222-2222", "Berlin", true), new Subscription(true, true), "catDaddy");

        //create an itinerary
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Da Lat Vacation", "2023-11-23", "09:00",
                new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                        11.935173970248758, 108.4307517539685, 4.3f)));
        activities.add(new Activity("2nd Activity", "2023-11-23", "09:00",
                new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                        11.935173970248758, 108.4307517539685, 4.3f)));

        //add activities to itinerary
        Itinerary itinerary = new Itinerary("1st Itinerary", activities);
        //create an itinerary composite and store user and itinerary information
        ItineraryComposite itineraryComposite = new ItineraryComposite(1, user, null, null, null, null, List.of(itinerary));
        try {
            List<Activity> listActivities = compositeService.listActivitiesInItinerary(itineraryComposite.getId());
            assertNotNull(listActivities);
        } catch (CompositeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void createActivity() {
        // create a user
        User user = new User("CatsAreCool", "catDaddy@pawmail.com", new Profile("Johnny Blaze", "222-222-2222", "Berlin", true), new Subscription(true, true), "catDaddy");
        // create an activity
        Activity activity = new Activity("Da Lat Vacation", "2023-11-23", "09:00",
                new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                        11.935173970248758, 108.4307517539685, 4.3f));
        // create an itinerary
        List<Activity> activities = new ArrayList<>();
        activities.add(activity);

        // add activities to itinerary
        Itinerary itinerary = new Itinerary("1st Itinerary", activities);
        // create an itinerary composite and store user and itinerary information
        ItineraryComposite itineraryComposite = new ItineraryComposite(1, user, null, null, null, null, List.of(itinerary));
        try {
            assertTrue(compositeService.createActivity(activity, itineraryComposite.getId()));
        } catch (CompositeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void updateActivity() {
        // create a user
        User user = new User("CatsAreCool", "catDaddy@pawmail.com", new Profile("Johnny Blaze", "222-222-2222", "Berlin", true), new Subscription(true, true), "catDaddy");

        //create activities
        List<Activity> activities = new ArrayList<>();
        Activity activity1 = new Activity("Da Lat Vacation", "2023-11-23", "09:00",
                new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                        11.935173970248758, 108.4307517539685, 4.3f));
        Activity activity2 = new Activity("2nd Activity", "2023-11-23", "09:00",
                new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                        11.935173970248758, 108.4307517539685, 4.3f));
        activities.add(activity1);
        activities.add(activity2);

        //add activities to itinerary
        Itinerary itinerary = new Itinerary("1st Itinerary", activities);
        // create an itinerary composite and store user and itinerary information
        ItineraryComposite itineraryComposite = new ItineraryComposite(1, user, null, null, null, null, List.of(itinerary));
        //update the name of the first activity
        activity1.setName("Updated Name");
        try {
            assertTrue(compositeService.updateActivity(activity1, itineraryComposite.getId()));
        } catch (CompositeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteActivity() {
        //create a user
        User user = new User("CatsAreCool", "catDaddy@pawmail.com", new Profile("Johnny Blaze", "222-222-2222", "Berlin", true), new Subscription(true, true), "catDaddy");

        //create an itinerary
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Da Lat Vacation", "2023-11-23", "09:00",
                new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                        11.935173970248758, 108.4307517539685, 4.3f)));
        activities.add(new Activity("2nd Activity", "2023-11-23", "09:00",
                new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                        11.935173970248758, 108.4307517539685, 4.3f)));

        //add activities to itinerary
        Itinerary itinerary = new Itinerary("1st Itinerary", activities);
        //create an itinerary composite and store user and itinerary information
        ItineraryComposite itineraryComposite = new ItineraryComposite(1, user, null, null, null, null, List.of(itinerary));
        try {
            assertTrue(compositeService.deleteItinerary(itineraryComposite.getId()));
        } catch (CompositeException e) {
            e.printStackTrace();
        }
    }
}