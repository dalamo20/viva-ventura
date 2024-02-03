package com.vivaventura.model.services.compservice;

import com.vivaventura.model.domain.Activity;
import com.vivaventura.model.domain.Itinerary;
import com.vivaventura.model.domain.Location;
import com.vivaventura.model.services.IService;
import com.vivaventura.model.services.exception.CompSvcEx;

import java.util.List;

public interface ICompSvc extends IService {
    public final String NAME = "ICompSvc";
    void addItinerary(Itinerary itinerary) throws CompSvcEx;
    Itinerary getItinerary(int id) throws CompSvcEx;
    void updateItinerary(Itinerary itinerary) throws CompSvcEx;
    void deleteItinerary(int id) throws CompSvcEx;

    void addActivity(Activity activity) throws CompSvcEx;
    Activity getActivity(int id) throws CompSvcEx;
    void updateActivity(Activity activity) throws CompSvcEx;
    void deleteActivity(int id) throws CompSvcEx;

    void addLocation(Location location) throws CompSvcEx;
    Location getLocation(int id) throws CompSvcEx;
    void updateLocation(Location location) throws CompSvcEx;
    void deleteLocation(int id) throws CompSvcEx;

    List<Itinerary> getAllItineraries() throws CompSvcEx;
    List<Activity> getAllActivities() throws CompSvcEx;
    List<Location> getAllLocations() throws CompSvcEx;
}
