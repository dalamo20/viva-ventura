package com.vivaventura.model.domain;

import com.vivaventura.model.domain.Activity;
import com.vivaventura.model.domain.Itinerary;
import com.vivaventura.model.domain.Location;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.*;

public class Composite implements Serializable {
    private final Logger logger = LogManager.getLogger(Composite.class);
    private static final long serialVersionUID = 1L;
    private Map<Integer, Itinerary> itineraries;
    private Map<Integer, Activity> activities;
    private Map<Integer, Location> locations;

    public Composite() {
        this.itineraries = new HashMap<>();
        this.activities = new HashMap<>();
        this.locations = new HashMap<>();
    }

    public void addItinerary(Itinerary itinerary) {
        itineraries.put(itinerary.getId(), itinerary);
    }

    public Itinerary getItinerary(int id) {
        Itinerary itinerary = itineraries.get(id);
        return itinerary;
    }

    public void updateItinerary(Itinerary itinerary) {
        if(itineraries.containsKey(itinerary.getId())){
            itineraries.replace(itinerary.getId(), itinerary);
            logger.info("Updated Itinerary with id: " + itinerary.getId() + ": " + itinerary);
        }else{
            throw new IllegalArgumentException("Itinerary with ID: " + itinerary.getId() + " does not exist." );
        }
    }

    public void deleteItinerary(int id) {
        Itinerary removeItinerary = itineraries.remove(id);
        if(removeItinerary != null){
            logger.info("Deleted Itinerary with id " + id);
        }else{
            throw new IllegalArgumentException("Itinerary with ID: " + id + " does not exist.");
        }

    }

    public void addActivity(Activity activity) {
        activities.put(activity.getId(), activity);
    }

    public Activity getActivity(int id) {
        Activity activity = activities.get(id);
        return activity;
    }

    public void updateActivity(Activity activity) {
        if(activities.containsKey(activity.getId())){
            activities.replace(activity.getId(), activity);
        }else{
            throw new IllegalArgumentException("Activity with ID: " + activity.getId() + " does not exist.");
        }
    }

    public void deleteActivity(int id) {
        Activity removeActivity = activities.remove(id);
        if(removeActivity != null){
            logger.info("Deleted activity with id " + id);
        }else{
            throw new IllegalArgumentException("Activity with ID: " + id + " does not exist.");
        }
    }

    public void addLocation(Location location) {
        locations.put(location.getId(), location);
    }

    public Location getLocation(int id) {
        Location location = locations.get(id);
        return location;
    }

    public void updateLocation(Location location) {
        if (locations.containsKey(location.getId())) {
            locations.replace(location.getId(), location);
            logger.info("Updated location with ID: " + location.getId() + ": " + location);
        } else {
            throw new IllegalArgumentException("Location with ID: " + location.getId() + " does not exist.");
        }
    }

    public void deleteLocation(int id) {
        Location removeLocation = locations.remove(id);
        if(removeLocation != null){
            logger.info("Deleted location with ID: " + id + " is deleted.");
        } else {
            throw new IllegalArgumentException("Location with ID: " + id + " does not exist.");
        }
    }

    public List<Itinerary> getAllItineraries() {
        return new ArrayList<>(itineraries.values());
    }

    public List<Activity> getAllActivities() {
        return new ArrayList<>(activities.values());
    }

    public List<Location> getAllLocations() {
        return new ArrayList<>(locations.values());
    }

    @Override
    public String toString() {
        return "Composite{" +
                "itineraries=" + itineraries +
                ", activities=" + activities +
                ", locations=" + locations +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Composite composite)) return false;
        return Objects.equals(itineraries, composite.itineraries) && Objects.equals(activities, composite.activities) && Objects.equals(locations, composite.locations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itineraries, activities, locations);
    }
}
