package com.vivaventura.model.domain;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


public class ItineraryComposite implements Serializable {
    private static final long serialVersionUID = -334371602256955290L;
    private List<Activity> activities;
    private List<Location> locations;
    private List<Itinerary> itineraries;

    public ItineraryComposite(){}
    public ItineraryComposite(List<Activity> activities, List<Location> locations, List<Itinerary> itineraries) {
        this.activities = activities;
        this.locations = locations;
        this.itineraries = itineraries;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Itinerary> getItineraries() {
        return itineraries;
    }

    public void setItineraries(List<Itinerary> itineraries) {
        this.itineraries = itineraries;
    }


    @Override
    public String toString() {
        return "ItineraryComposite{" +
                "activities=" + activities +
                ", locations=" + locations +
                ", itineraries=" + itineraries +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItineraryComposite that)) return false;
        return Objects.equals(getActivities(), that.getActivities()) && Objects.equals(getLocations(), that.getLocations()) && Objects.equals(getItineraries(), that.getItineraries());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivities(), getLocations(), getItineraries());
    }
}
