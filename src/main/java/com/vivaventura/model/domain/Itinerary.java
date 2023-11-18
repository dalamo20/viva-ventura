package com.vivaventura.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Itinerary implements Serializable {
    //Instance variables
    private static final long serialVersionUID = 1L;
    private long id;
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

    public void addActivity(Activity activity) {
        if (activities == null) {
            activities = new ArrayList<>();
        }
        //add activity to the list
        activities.add(activity);
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    //Here I am going to generate the random id's
    //using Math.abs to get positive numbers only
    public long generateId() {
        if (id == 0) {
            Random rand = new Random();
            id = Math.abs(rand.nextLong());
        }
        return id;
    }
}
