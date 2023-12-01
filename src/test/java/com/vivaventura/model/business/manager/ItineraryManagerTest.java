//package com.vivaventura.model.business.manager;
//
//import com.vivaventura.model.business.exception.ServiceLoadException;
//import com.vivaventura.model.domain.Itinerary;
//import com.vivaventura.model.domain.ItineraryComposite;
//import com.vivaventura.model.domain.User;
//import com.vivaventura.model.services.compositeservice.ICompositeService;
//import com.vivaventura.model.services.exception.CompositeException;
//import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ItineraryManagerTest {
//    private ItineraryManager itineraryManager;
//    private ItineraryComposite itineraryComposite;
//    private User user;
//
//    @Before
//    public void setUp() throws Exception {
//        itineraryManager = ItineraryManager.getInstance();
//
//        // Initialize user and itineraryComposite
//        user = new User("testPassword", "test@example.com", null, null, "testUser");
//        itineraryComposite = new ItineraryComposite(1, user, null, null, null, null, null);
//    }
//
//    @Test
//    public void createItinerary() {
//        try {
//            boolean isCreated = itineraryManager.createItinerary(ICompositeService.NAME, itineraryComposite, user);
//            assertTrue(isCreated);
//
//            // Retrieve the created itinerary from the manager for further assertions
//            Itinerary retrievedItinerary = itineraryManager.getItineraryById(itineraryComposite.getItineraries().get(0).getId());
//            assertNotNull(retrievedItinerary);
//            assertEquals(user, retrievedItinerary.getUser());
//
//            // Clean up: delete the created itinerary
//            assertTrue(itineraryManager.deleteItinerary(retrievedItinerary.getId()));
//        } catch (ServiceLoadException e) {
//            fail("Exception thrown: " + e.getMessage());
//        }
//    }
//
//    @Test
//    public void getItineraryById() {
//        try {
//            boolean isCreated = itineraryManager.createItinerary(ICompositeService.NAME, itineraryComposite, user);
//            assertTrue(isCreated);
//
//            // Retrieve the created itinerary from the manager for further assertions
//            Itinerary retrievedItinerary = itineraryManager.getItineraryById(itineraryComposite.getItineraries().get(0).getId());
//            assertNotNull(retrievedItinerary);
//            assertEquals(user, retrievedItinerary.getUser());
//
//            // Clean up: delete the created itinerary
//            assertTrue(itineraryManager.deleteItinerary(retrievedItinerary.getId()));
//        } catch (ServiceLoadException e) {
//            fail("Exception thrown: " + e.getMessage());
//        }
//    }
//
//    @Test
//    public void deleteItinerary() {
//        try {
//            boolean isCreated = itineraryManager.createItinerary(ICompositeService.NAME, itineraryComposite, user);
//            assertTrue(isCreated);
//
//            // Retrieve the created itinerary from the manager for further assertions
//            Itinerary retrievedItinerary = itineraryManager.getItineraryById(itineraryComposite.getItineraries().get(0).getId());
//            assertNotNull(retrievedItinerary);
//            assertEquals(user, retrievedItinerary.getUser());
//
//            // Delete the created itinerary
//            assertTrue(itineraryManager.deleteItinerary(retrievedItinerary.getId()));
//
//            // Ensure that the itinerary is deleted
//            assertNull(itineraryManager.getItineraryById(retrievedItinerary.getId()));
//        } catch (ServiceLoadException e) {
//            fail("Exception thrown: " + e.getMessage());
//        }
//    }
//}