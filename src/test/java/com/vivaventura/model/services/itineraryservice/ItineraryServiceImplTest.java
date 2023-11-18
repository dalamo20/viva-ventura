package com.vivaventura.model.services.itineraryservice;

import com.vivaventura.model.domain.Activity;
import com.vivaventura.model.domain.Itinerary;
import com.vivaventura.model.domain.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItineraryServiceImplTest {
    private IItineraryService itineraryService;

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
    }

    @Test
    void getItinerary() {
        //create an instance of Itinerary
        Itinerary itinerary1 = new Itinerary("1st Itinerary",
                List.of(new Activity("Da Lat Vacation", "2023-11-23", "09:00",
                        new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                                11.935173970248758, 108.4307517539685, 4.3f)))
        );
        //create another itinerary using the service
        itineraryService.createItinerary("1st Itinerary", itinerary1.getActivities());

        //grab the
        Itinerary findItinerary = itineraryService.getItinerary("1st Itinerary");

        //check if itinerary is not null
        assertNotNull(findItinerary);

        //check if the created itinerary is the same as the one retrieved
        assertEquals(itinerary1, findItinerary);
    }

    @Test
    void getAllItineraries() {
        //check list of itineraries is not null
        assertNotNull(itineraryService.getAllItineraries());
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
        assertNotNull(res);
        assertEquals(updatedItinerary, res);

        //checks if the first itinerary is in the list
        assertFalse(itineraryService.getAllItineraries().contains(itinerary1));
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
    }
}