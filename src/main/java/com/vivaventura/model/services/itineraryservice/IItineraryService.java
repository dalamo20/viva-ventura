package com.vivaventura.model.services.itineraryservice;

import com.vivaventura.model.domain.Activity;
import com.vivaventura.model.domain.Itinerary;

import java.util.List;

public interface IItineraryService {
    Itinerary createItinerary(String itineraryItemName, List<Activity> activities);

    Itinerary getItinerary(String itineraryItemName);

    List<Itinerary> getAllItineraries();

    Itinerary updateItinerary(String itineraryItemName, Itinerary updatedItinerary);

    boolean deleteItinerary(String itineraryItemName);
}
