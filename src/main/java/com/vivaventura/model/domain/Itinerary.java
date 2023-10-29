package com.vivaventura.model.domain;

import java.util.List;
import java.util.Objects;

public class Itinerary {
    //Instance variables
    private String name;
    private List<Activity> activities;

    //Default constructor
    public Itinerary(){
        System.out.println("Itinerary created");
    }

    //Overloaded constructor
    public Itinerary(String name, List<Activity> activities) {
        this.name = name;
        this.activities = activities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return Objects.equals(getName(), itinerary.getName()) && Objects.equals(getActivities(), itinerary.getActivities());
    }

    //Hashcode
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getActivities());
    }
}
