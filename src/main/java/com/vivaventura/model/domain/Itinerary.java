package com.vivaventura.model.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Itinerary implements Serializable {
    //Instance variables
    private static final long serialVersionUID = 1L;
    private String itineraryItemName;
    private List<Activity> activities;

    //Default constructor
    public Itinerary(){}

    //Overloaded constructor
    public Itinerary(String itineraryItemName, List<Activity> activities) {
        this.itineraryItemName = itineraryItemName;
        this.activities = activities;
    }

    public String getItineraryItemName() {
        return itineraryItemName;
    }

    public void setItineraryItemName(String itineraryItemName) {
        this.itineraryItemName = itineraryItemName;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    //Custom toString method
    @Override
    public String toString() {
        return "Itinerary{" +
                "List of activities=" + activities +
                '}';
    }

    //Equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Itinerary itinerary)) return false;
        return Objects.equals(getItineraryItemName(), itinerary.getItineraryItemName()) && Objects.equals(getActivities(), itinerary.getActivities());
    }

    //Hashcode
    @Override
    public int hashCode() {
        return Objects.hash(getItineraryItemName(), getActivities());
    }
}
