package com.vivaventura.model.services.compositeservice;

import com.vivaventura.model.domain.Activity;
import com.vivaventura.model.domain.ItineraryComposite;
import com.vivaventura.model.domain.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ICompositeServiceImplTest {
    private ICompositeService itineraryCompService;

    @BeforeEach
    void setUp() {
        itineraryCompService = new ICompositeServiceImpl();
    }

    @Test
    void createItineraryComposite() {
        //create an ItineraryComposite instance
        ItineraryComposite itineraryComposite = new ItineraryComposite();
        itineraryComposite.addActivity(new Activity("Food Tour", "2024-02-04", "09:00 AM", new Location("District 1")));

        //check if ID is generated
        ItineraryComposite createdItinerary = itineraryCompService.createItineraryComposite(itineraryComposite);
        assertNotNull(createdItinerary.getId());
    }

    @Test
    void getItineraryCompositeById() {
        ItineraryComposite itineraryComposite = new ItineraryComposite();
        itineraryComposite.addActivity(new Activity("Food Tour", "2024-02-04", "09:00 AM", new Location("District 1")));

        //get itineraryComposite by ID
        ItineraryComposite createdItinerary = itineraryCompService.createItineraryComposite(itineraryComposite);
        long id = createdItinerary.getId();
        ItineraryComposite retrievedItinerary = itineraryCompService.getItineraryCompositeById(id);

        assertNotNull(retrievedItinerary);
        assertEquals(createdItinerary, retrievedItinerary);
        System.out.println("Created Itinerary's ID: " + createdItinerary.getId());
        System.out.println("ID of Itinerary retrieved: " + retrievedItinerary.getId());
    }

    @Test
    void updateItineraryComposite() {
        ItineraryComposite itineraryComposite = new ItineraryComposite();
        itineraryComposite.addActivity(new Activity("Food Tour", "2024-02-04", "09:00 AM", new Location("District 1")));

        //create instance, update it, and check if the update is successful
        ItineraryComposite createdItinerary = itineraryCompService.createItineraryComposite(itineraryComposite);
        createdItinerary.addActivity(new Activity("Updated Food Tour", "2024-02-04", "10:00 AM", new Location("District 2")));

        itineraryCompService.updateItineraryComposite(createdItinerary);
        ItineraryComposite updatedItinerary = itineraryCompService.getItineraryCompositeById(createdItinerary.getId());

        assertNotNull(updatedItinerary);
        assertEquals(createdItinerary, updatedItinerary);
        System.out.println("ID before update: " + createdItinerary.getId());
        System.out.println("Updated Itinerary ID: " + updatedItinerary.getId());
    }

    @Test
    void deleteItineraryComposite() {
        ItineraryComposite itineraryComposite = new ItineraryComposite();
        itineraryComposite.addActivity(new Activity("Food Tour", "2024-02-04", "09:00 AM", new Location("District 1")));

        //create instance and delete it by id
        ItineraryComposite createdItinerary = itineraryCompService.createItineraryComposite(itineraryComposite);
        long id = createdItinerary.getId();
        System.out.println("ID before deleting: " + id);
        assertNotNull(itineraryCompService.getItineraryCompositeById(id));
        itineraryCompService.deleteItineraryComposite(id);
        assertNull(itineraryCompService.getItineraryCompositeById(id));
        System.out.println("Deleted ID: " + id);
    }
}