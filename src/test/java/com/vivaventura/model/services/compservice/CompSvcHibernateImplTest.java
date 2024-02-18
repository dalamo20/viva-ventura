package com.vivaventura.model.services.compservice;

import com.vivaventura.model.domain.Activity;
import com.vivaventura.model.domain.Itinerary;
import com.vivaventura.model.domain.Location;
import com.vivaventura.model.services.exception.CompSvcEx;
import com.vivaventura.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CompSvcHibernateImplTest {

    private static CompSvcHibernateImpl compSvc;

    @BeforeAll
    public static void setUp() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        compSvc = new CompSvcHibernateImpl(sessionFactory);
    }

    @AfterEach
    public void tearDown() {
        try (Session session = compSvc.getSessionFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }
    }

    @Test
    public void testAddItinerary() {
        Itinerary itinerary = new Itinerary();
        itinerary.setName("1st Itinerary");

        assertDoesNotThrow(() -> compSvc.addItinerary(itinerary));
    }

    @Test
    public void testGetItinerary() throws CompSvcEx {
        Itinerary itinerary = new Itinerary();
        itinerary.setName("1st Itinerary");
        compSvc.addItinerary(itinerary);

        int id = itinerary.getId();
        assertDoesNotThrow(() -> assertNotNull(compSvc.getItinerary(id)));
    }

    @Test
    public void testUpdateItinerary() throws CompSvcEx {
        Itinerary itinerary = new Itinerary();
        itinerary.setName("1st Itinerary");
        compSvc.addItinerary(itinerary);

        itinerary.setName("Newest Updated Itinerary");
        assertDoesNotThrow(() -> compSvc.updateItinerary(itinerary));
    }

    @Test
    public void testDeleteItinerary() throws CompSvcEx {
        Itinerary itinerary = new Itinerary();
        itinerary.setName("Delete ME Itinerary");
        compSvc.addItinerary(itinerary);

        int id = itinerary.getId();
        assertDoesNotThrow(() -> compSvc.deleteItinerary(id));
    }

//    @Test
//    public void testGetAllItineraries() throws CompSvcEx {
//        Itinerary itinerary1 = new Itinerary();
//        itinerary1.setName("Itinerary 1");
//
//        Itinerary itinerary2 = new Itinerary();
//        itinerary2.setName("Itinerary 2");
//
//        compSvc.addItinerary(itinerary1);
//        compSvc.addItinerary(itinerary2);
//
//        List<Itinerary> itineraries = assertDoesNotThrow(() -> compSvc.getAllItineraries());
//        assertEquals(4, itineraries.size());
//    }

    @Test
    public void testAddActivity() {
        Activity activity = new Activity();
        activity.setName("1st Activity");
        assertDoesNotThrow(() -> compSvc.addActivity(activity));
    }

    @Test
    public void testGetActivity() throws CompSvcEx {
        Activity activity = new Activity();
        activity.setName("1st Activity");
        compSvc.addActivity(activity);

        int id = activity.getId();
        assertDoesNotThrow(() -> assertNotNull(compSvc.getActivity(id)));
    }

    @Test
    public void testUpdateActivity() throws CompSvcEx {
        Activity activity = new Activity();
        activity.setName("Old Activity");
        compSvc.addActivity(activity);

        activity.setName("New Activity");
        assertDoesNotThrow(() -> compSvc.updateActivity(activity));
    }

    @Test
    public void testDeleteActivity() throws CompSvcEx {
        Activity activity = new Activity();
        activity.setName("Delete ME Activity");
        compSvc.addActivity(activity);

        int id = activity.getId();
        assertDoesNotThrow(() -> compSvc.deleteActivity(id));
    }

    @Test
    public void testGetAllActivities() throws CompSvcEx {
        Activity activity1 = new Activity();
        activity1.setName("Activity 1");

        Activity activity2 = new Activity();
        activity2.setName("Activity 2");

        compSvc.addActivity(activity1);
        compSvc.addActivity(activity2);

        List<Activity> activities = assertDoesNotThrow(() -> compSvc.getAllActivities());
        assertEquals(3, activities.size());
    }

    @Test
    public void testAddLocation() {
        Location location = new Location();
        location.setName("New Location");
        assertDoesNotThrow(() -> compSvc.addLocation(location));
    }

    @Test
    public void testGetLocation() throws CompSvcEx {
        Location location = new Location();
        location.setName("New Location");
        compSvc.addLocation(location);

        int id = location.getId();
        assertDoesNotThrow(() -> assertNotNull(compSvc.getLocation(id)));
    }

    @Test
    public void testUpdateLocation() throws CompSvcEx {
        Location location = new Location();
        location.setName("1st Location");
        compSvc.addLocation(location);

        location.setName("Updated Location");
        assertDoesNotThrow(() -> compSvc.updateLocation(location));
    }

    @Test
    public void testDeleteLocation() throws CompSvcEx {
        Location location = new Location();
        location.setName("Delete ME Location");
        compSvc.addLocation(location);

        int id = location.getId();
        assertDoesNotThrow(() -> compSvc.deleteLocation(id));
    }

//    @Test
//    public void testGetAllLocations() throws CompSvcEx {
//        Location location1 = new Location();
//        location1.setName("Location 1");
//
//        Location location2 = new Location();
//        location2.setName("Location 2");
//
//        compSvc.addLocation(location1);
//        compSvc.addLocation(location2);
//
//        List<Location> locations = assertDoesNotThrow(() -> compSvc.getAllLocations());
//        assertEquals(5, locations.size());
//    }
}
