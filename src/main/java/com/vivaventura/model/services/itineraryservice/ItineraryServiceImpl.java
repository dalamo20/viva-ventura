package com.vivaventura.model.services.itineraryservice;

import com.vivaventura.model.domain.Activity;
import com.vivaventura.model.domain.Itinerary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItineraryServiceImpl implements IItineraryService{
    private static final Logger logger = LogManager.getLogger(ItineraryServiceImpl.class);
    private final Map<String, Itinerary> itineraryMap = new HashMap<>();
    //create itinerary takes the itinerary name and a list of Activities as params
    //an instance of Itinerary is created and put into a Hashmap
    //the Map contains a key = itinerary name and a value = Itinerary object
    //thus returning the object
    @Override
    public Itinerary createItinerary(String itineraryItemName, List<Activity> activities) {
        Itinerary itinerary = new Itinerary(itineraryItemName, activities);
        itineraryMap.put(itineraryItemName, itinerary);
        logger.info("Itinerary created: " + itineraryItemName);
        return itinerary;
    }

    @Override
    public Itinerary getItinerary(String itineraryItemName) {
        logger.info("Retrieve itinerary: " + itineraryItemName);
        return itineraryMap.get(itineraryItemName);
    }

    @Override
    public Itinerary getItineraryById(int itineraryId) {
        logger.info("Getting itinerary by ID: " + itineraryId);
        return itineraryMap.values().stream()
                .filter(itinerary -> itinerary.getId() == itineraryId)
                .findFirst()
                .orElse(null);
    }

    //get all itineraries
    @Override
    public List<Itinerary> getAllItineraries() {
        logger.info("Getting all itineraries");
        return new ArrayList<>(itineraryMap.values());
    }
    //update an itinerary by name and Itinerary object as params
    //If Statement searches the maps key using .containsKey() method
    //If key is found, update Itinerary obj put back in Map, then return
    //updated Itinerary object. Else return null
    @Override
    public Itinerary updateItinerary(String itineraryItemName, Itinerary updatedItinerary) {
        if (itineraryMap.containsKey(itineraryItemName)) {
            itineraryMap.put(itineraryItemName, updatedItinerary);
            logger.info("Itinerary updated: " + itineraryItemName);
            return updatedItinerary;
        }
        logger.warn("Itinerary Not Found: " + itineraryItemName);
        return null;
    }
    //delete an itinerary by name
    @Override
    public boolean deleteItinerary(String itineraryItemName) {
        if (itineraryMap.containsKey(itineraryItemName)) {
            itineraryMap.remove(itineraryItemName);
            logger.info("Deleted itinerary: " + itineraryItemName);
            return true;
        } else {
            logger.warn("Itinerary Not Found: " + itineraryItemName);
            return false;
        }
    }
}
