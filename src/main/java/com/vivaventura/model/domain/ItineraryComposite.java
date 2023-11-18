package com.vivaventura.model.domain;
import java.io.Serializable;
import java.util.*;

public class ItineraryComposite implements Serializable {
    private static final long serialVersionUID = -334371602256955290L;
    private long id;
    private User user;
    private Subscription subscription;
    private Profile profile;
    private List<Activity> activities;
    private List<Location> locations;
    private List<Itinerary> itineraries;

    public ItineraryComposite(){
        generateId();
        this.activities = new ArrayList<>();
    }

    public ItineraryComposite(long id, User user, Subscription subscription, Profile profile, List<Activity> activities, List<Location> locations, List<Itinerary> itineraries) {
        generateId();
        this.id = id;
        this.user = user;
        this.subscription = subscription;
        this.profile = profile;
        this.activities = activities;
        this.locations = locations;
        this.itineraries = itineraries;
    }

    public ItineraryComposite(long id, List<Activity> activities, List<Location> locations, List<Itinerary> itineraries) {
        generateId();
        this.activities = new ArrayList<>();
        this.activities.addAll(activities);
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
    //using Math.abs to get positive numbers only
    public long generateId() {
        Random rand = new Random();
        this.id = Math.abs(rand.nextLong());
        return id;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
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
    public String toString() {
        return "ItineraryComposite{" +
                "id=" + id +
                ", user=" + user +
                ", subscription=" + subscription +
                ", profile=" + profile +
                ", activities=" + activities +
                ", locations=" + locations +
                ", itineraries=" + itineraries +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItineraryComposite that)) return false;
        return getId() == that.getId() && Objects.equals(getUser(), that.getUser()) && Objects.equals(getSubscription(), that.getSubscription()) && Objects.equals(getProfile(), that.getProfile()) && Objects.equals(getActivities(), that.getActivities()) && Objects.equals(getLocations(), that.getLocations()) && Objects.equals(getItineraries(), that.getItineraries());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getSubscription(), getProfile(), getActivities(), getLocations(), getItineraries());
    }
}
