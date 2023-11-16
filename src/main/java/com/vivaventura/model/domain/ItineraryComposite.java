package com.vivaventura.model.domain;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ItineraryComposite implements Serializable {
    private static final long serialVersionUID = -334371602256955290L;
    private long id;
    private List<Activity> activities;
    private List<Location> locations;
    private List<Itinerary> itineraries;

    public ItineraryComposite(){generateId();}
    public ItineraryComposite(long id, List<Activity> activities, List<Location> locations, List<Itinerary> itineraries) {
        generateId();
        this.activities = activities;
        this.locations = locations;
        this.itineraries = itineraries;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    //Here I am going to generate the random id's
    public long generateId() {
        this.id = UUID.randomUUID().getMostSignificantBits();
        System.out.println("ID generated: " + id);
        return id;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItineraryComposite that)) return false;
        return getId() == that.getId() && Objects.equals(getActivities(), that.getActivities()) && Objects.equals(getLocations(), that.getLocations()) && Objects.equals(getItineraries(), that.getItineraries());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getActivities(), getLocations(), getItineraries());
    }

    @Override
    public String toString() {
        return "ItineraryComposite{" +
                "id=" + id +
                ", activities=" + activities +
                ", locations=" + locations +
                ", itineraries=" + itineraries +
                '}';
    }
}
