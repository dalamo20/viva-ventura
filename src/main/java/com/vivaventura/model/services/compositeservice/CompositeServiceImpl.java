package com.vivaventura.model.services.compositeservice;

import com.vivaventura.model.domain.Activity;
import com.vivaventura.model.domain.Itinerary;
import com.vivaventura.model.domain.ItineraryComposite;
import com.vivaventura.model.domain.User;
import com.vivaventura.model.services.exception.CompositeException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CompositeServiceImpl implements ICompositeService {
    private final List<ItineraryComposite> itineraryComposites = new ArrayList<>();

    @Override
    public List<Itinerary> listUserItineraries(User user) throws CompositeException {
        return itineraryComposites.stream()
                .filter(itinerary -> itinerary.getUser() != null && itinerary.getUser().equals(user))
                .map(ItineraryComposite::getItineraries)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @Override
    public Itinerary getItineraryById(int id) throws CompositeException {
        return itineraryComposites.stream()
                .flatMap(itineraryComposite -> itineraryComposite.getItineraries().stream())
                .filter(itinerary -> itinerary.getId() == id)
                .findFirst()
                .orElseThrow(() -> new CompositeException("Itinerary not found with ID: " + id));
    }

    @Override
    public boolean createItinerary(ItineraryComposite itineraryComposite, User user) throws CompositeException {
        itineraryComposite.setUser(user);
        return itineraryComposites.add(itineraryComposite);
    }

    @Override
    public boolean updateItinerary(ItineraryComposite updatedItineraryComposite, User user) throws CompositeException {
        //iterate through itineraryComposites to find matching user and itinerary ID
        for (int i = 0; i < itineraryComposites.size(); i++) {
            ItineraryComposite oldItineraryComposite = itineraryComposites.get(i);
            //check if the user is the owner and the ID matches
            if (oldItineraryComposite.getUser() != null && oldItineraryComposite.getUser().equals(user) &&
                    oldItineraryComposite.getId() == updatedItineraryComposite.getId()) {
                //update old itinerary with the new one
                itineraryComposites.set(i, updatedItineraryComposite);
                System.out.println("Itinerary with ID " + updatedItineraryComposite.getId() + " has been updated.");
                return true;
            }
        }
        throw new CompositeException("Itinerary not found or user does not have permission");
    }

    @Override
    public boolean deleteItinerary(int itineraryId) throws CompositeException {
        Itinerary itinerary = getItineraryById(itineraryId);
        if (itinerary == null) {
            throw new CompositeException("Itinerary not found");
        }
        System.out.println("Deleting itinerary with ID: " + itineraryId);
        //using iterator interface, using a while loop to search the list of itineraries for a matching id as the params to remove from the list
        Iterator<ItineraryComposite> iterator = itineraryComposites.iterator();
        while (iterator.hasNext()) {
            ItineraryComposite composite = iterator.next();
            if (composite.getId() == itineraryId) {
                iterator.remove();
                return true;
            }
        }
        throw new CompositeException("Itinerary not found");
    }

    @Override
    public List<Activity> listActivitiesInItinerary(int itineraryId) throws CompositeException {
        ItineraryComposite itineraryComposite = itineraryComposites.stream()
                .filter(itinerary -> itinerary.getItineraries().stream()
                        .anyMatch(innerItinerary -> innerItinerary.getId() == itineraryId))
                .findFirst()
                .orElseThrow(() -> new CompositeException("Itinerary not found"));
        return itineraryComposite.getActivities();
    }

    @Override
    public boolean createActivity(Activity activity, int itineraryId) throws CompositeException {
        //iterate through the itinerary composite for id's matching the itinerary id from params
        ItineraryComposite itineraryComposite = itineraryComposites.stream()
                .filter(itinerary -> itinerary.getItineraries().stream()
                        .anyMatch(innerItinerary -> innerItinerary.getId() == itineraryId))
                .findFirst()
                .orElseThrow(() -> new CompositeException("Itinerary not found"));
        //if a matching itinerary is found then add an activity
        return itineraryComposite.getActivities().add(activity);
    }

    @Override
    public boolean updateActivity(Activity activity, int itineraryId) throws CompositeException {
        ItineraryComposite itineraryComposite = itineraryComposites.stream()
                .filter(itinerary -> itinerary.getItineraries().stream()
                        .anyMatch(innerItinerary -> innerItinerary.getId() == itineraryId))
                .findFirst()
                .orElseThrow(() -> new CompositeException("Itinerary not found"));

        if (itineraryComposite.getActivities() != null) {
            return true;
        } else {
            throw new CompositeException("Activities list is null");
        }
    }

    public boolean deleteActivity(int activityId, int itineraryId) throws CompositeException {
        ItineraryComposite itineraryComposite = itineraryComposites.stream()
                .filter(itinerary -> itinerary.getItineraries().stream()
                        .anyMatch(innerItinerary -> innerItinerary.getId() == itineraryId))
                .findFirst()
                .orElseThrow(() -> new CompositeException("Itinerary not found"));
        //store itinerary id
        Itinerary itinerary = getItineraryById(itineraryId);
        //check if there is an itinerary
        if (itinerary == null) {
            throw new CompositeException("Itinerary not found");
        }
        //delete the activity from the itinerary associated with the activityId passed in the params
        return itinerary.getActivities().removeIf(activity -> activity.getId() == activityId);
    }

    @Override
    public boolean linkUserToItinerary(User user, int itineraryId) throws CompositeException {
        //iterating through the composites to find one with matching id
        ItineraryComposite itineraryComposite = itineraryComposites.stream()
                .filter(itinerary -> itinerary.getItineraries().stream()
                        .anyMatch(innerItinerary -> innerItinerary.getId() == itineraryId))
                .findFirst()
                .orElseThrow(() -> new CompositeException("Itinerary not found"));
        //setting the user to the composite/ links user to the itinerary
        itineraryComposite.setUser(user);
        return true;
    }
}
