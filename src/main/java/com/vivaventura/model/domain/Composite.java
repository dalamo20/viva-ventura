package com.vivaventura.model.domain;

import com.vivaventura.model.domain.Activity;
import com.vivaventura.model.domain.Itinerary;
import com.vivaventura.model.domain.Location;

import java.io.Serializable;
import java.util.*;

public class Composite implements Serializable {
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
        return itineraries.get(id);
    }

    public void updateItinerary(Itinerary itinerary) {
        itineraries.put(itinerary.getId(), itinerary);
    }

    public void deleteItinerary(int id) {
        itineraries.remove(id);
    }

    public void addActivity(Activity activity) {
        activities.put(activity.getId(), activity);
    }

    public Activity getActivity(int id) {
        return activities.get(id);
    }

    public void updateActivity(Activity activity) {
        activities.put(activity.getId(), activity);
    }

    public void deleteActivity(int id) {
        activities.remove(id);
    }

    public void addLocation(Location location) {
        locations.put(location.getId(), location);
    }

    public Location getLocation(int id) {
        return locations.get(id);
    }

    public void updateLocation(Location location) {
        locations.put(location.getId(), location);
    }

    public void deleteLocation(int id) {
        locations.remove(id);
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
