package com.vivaventura.model.services.itineraryservice;

import com.vivaventura.model.domain.Activity;
import com.vivaventura.model.domain.CompositeTest;
import com.vivaventura.model.domain.Itinerary;
import com.vivaventura.model.domain.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class ItineraryServiceImplTest {
    private IItineraryService itineraryService;
    private static final Logger logger = Logger.getLogger(CompositeTest.class.getName());

    @BeforeEach
    void setUp() {
        itineraryService = new ItineraryServiceImpl();
    }
    @Test
    void createItinerary() {
        //create instance of itinerary
        //using List.of rather than Arrays.asList()
        Itinerary itinerary1 = new Itinerary("1st Vacation Plan",
                List.of(new Activity("Da Lat Vacation", "2023-11-23", "09:00",
                        new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                                11.935173970248758, 108.4307517539685, 4.3f)))
        );
        //use createItinerary from IItineraryService
        itineraryService.createItinerary("1st Vacation Plan", itinerary1.getActivities());
        //returns true if itineraryService contains the key "1st Vacation Plan"
        assertTrue(itineraryService.getItinerary("1st Vacation Plan") != null);
        Itinerary res = itineraryService.getItinerary("1st Vacation Plan");
//        logger.log(Level.INFO, "Created Itinerary: " + res);
    }

    @Test
    void getItineraryById() {
        Itinerary createdItinerary = itineraryService.createItinerary("New Itinerary", List.of(
                new Activity("New Activity", "2023-12-01", "10:00",
                        new Location("New Location", "New Address", 0.0, 0.0, 4.5f))
        ));

        Itinerary retrievedItinerary = itineraryService.getItineraryById(createdItinerary.getId());
        assertNotNull(retrievedItinerary);
        assertEquals(createdItinerary, retrievedItinerary);
//        logger.log(Level.INFO, "Retrieved Itinerary: " + retrievedItinerary);
    }

    @Test
    void getAllItineraries() {
        itineraryService.createItinerary("Itinerary 1", List.of(
                new Activity("Activity 1", "2023-12-01", "10:00",
                        new Location("Location 1", "Address 1", 0.0, 0.0, 4.5f))
        ));
        itineraryService.createItinerary("Itinerary 2", List.of(
                new Activity("Activity 2", "2023-12-02", "11:00",
                        new Location("Location 2", "Address 2", 0.0, 0.0, 4.0f))
        ));

        List<Itinerary> allItineraries = itineraryService.getAllItineraries();
        System.out.println("Get all itineraries: " + allItineraries);
        assertNotNull(allItineraries);
        assertEquals(2, allItineraries.size());
        logger.log(Level.INFO, "Retrieved All Itineraries: " + allItineraries);
    }

    @Test
    void updateItinerary() {
        //create instance of Itinerary
        Itinerary itinerary1 = new Itinerary("1st Vacation Plan",
                List.of(new Activity("Da Lat Vacation", "2023-11-23", "09:00",
                        new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                                11.935173970248758, 108.4307517539685, 4.3f)))
        );
        //create an itinerary using the itinerary1 instance above
        itineraryService.createItinerary("1st Vacation Plan", itinerary1.getActivities());

        //create updated itinerary
        Itinerary updatedItinerary = new Itinerary("Update 1st Vacation Plan",
                List.of(new Activity("Da Lat Vacation", "2023-11-23", "09:00",
                        new Location("Datanla Waterfall", "QL20 Đèo Prenn, Phường 3, Thành phố Đà Lạt, Lâm Đồng 66000, Vietnam",
                                11.90468337425614, 108.44939898465618, 4.3f)))
        );
        //use the updateItinerary method that takes the name of the original itinerary and updates it with new updated itinerary obj
        Itinerary res = itineraryService.updateItinerary("1st Vacation Plan", updatedItinerary);

        //checks if the updated obj is null, then checks if the results are the same as the updatedItinerary obj
        System.out.println("Before Update: " + itinerary1);
        assertNotNull(res);
        assertEquals(updatedItinerary, res);
        System.out.println("After Update: " + res);

        //checks if the first itinerary is in the list
        assertFalse(itineraryService.getAllItineraries().contains(itinerary1));
//        logger.log(Level.INFO, "Old Itinerary: " + itinerary1);
//        logger.log(Level.INFO, "Updated Itinerary: " + res);
    }

    @Test
    void deleteItinerary() {
        //create instance of Itinerary
        Itinerary itinerary1 = new Itinerary("1st Vacation Plan",
                List.of(new Activity("Da Lat Vacation", "2023-11-23", "09:00",
                        new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                                11.935173970248758, 108.4307517539685, 4.3f)))
        );
        //create an itinerary using the itinerary1 instance above
        itineraryService.createItinerary("1st Vacation Plan", itinerary1.getActivities());

        //call deleteItinerary method
        boolean res = itineraryService.deleteItinerary("1st Vacation Plan");

        //res should be true indicating that the itinerary has been deleted
        assertTrue(res);

        //check if itinerary is in list
        assertFalse(itineraryService.getAllItineraries().contains(itinerary1));

//        logger.log(Level.INFO, "Is Itinerary Deleted? " + res);
    }
}