package com.vivaventura.model.services.compositeservice;

import com.vivaventura.model.domain.Activity;
import com.vivaventura.model.domain.Itinerary;
import com.vivaventura.model.domain.ItineraryComposite;
import com.vivaventura.model.domain.User;
import com.vivaventura.model.services.exception.CompositeException;

import java.util.ArrayList;
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
    public Itinerary getItineraryById(long id) throws CompositeException {
        return itineraryComposites.stream()
                .flatMap(itineraryComposite -> itineraryComposite.getItineraries().stream())
                .filter(itinerary -> itinerary.getId() == id)
                .findFirst()
                .orElseThrow(() -> new CompositeException("Itinerary not found"));
    }

    @Override
    public boolean createItinerary(ItineraryComposite itineraryComposite, User user) throws CompositeException {
        itineraryComposite.setUser(user);
        return itineraryComposites.add(itineraryComposite);
    }

    @Override
    public boolean updateItinerary(ItineraryComposite itineraryComposite) throws CompositeException {
        return itineraryComposites.contains(itineraryComposite);
    }

    @Override
    public boolean deleteItinerary(long itineraryId) throws CompositeException {
        return itineraryComposites.removeIf(itinerary -> itinerary.getId() == itineraryId);
    }

    @Override
    public List<Activity> listActivitiesInItinerary(long itineraryId) throws CompositeException {
        ItineraryComposite itineraryComposite = itineraryComposites.stream()
                .filter(itinerary -> itinerary.getItineraries().stream()
                        .anyMatch(innerItinerary -> innerItinerary.getId() == itineraryId))
                .findFirst()
                .orElseThrow(() -> new CompositeException("Itinerary not found"));

        return itineraryComposite.getActivities();
    }

    @Override
    public boolean createActivity(Activity activity, long itineraryId) throws CompositeException {
        ItineraryComposite itineraryComposite = itineraryComposites.stream()
                .filter(itinerary -> itinerary.getItineraries().stream()
                        .anyMatch(innerItinerary -> innerItinerary.getId() == itineraryId))
                .findFirst()
                .orElseThrow(() -> new CompositeException("Itinerary not found"));

        return itineraryComposite.getActivities().add(activity);
    }

    @Override
    public boolean updateActivity(Activity activity, long itineraryId) throws CompositeException {
        ItineraryComposite itineraryComposite = itineraryComposites.stream()
                .filter(itinerary -> itinerary.getItineraries().stream()
                        .anyMatch(innerItinerary -> innerItinerary.getId() == itineraryId))
                .findFirst()
                .orElseThrow(() -> new CompositeException("Itinerary not found"));

        return itineraryComposite.getActivities().removeIf(a -> a.getId() == activity.getId()) &&
                itineraryComposite.getActivities().add(activity);
    }

    @Override
    public boolean deleteActivity(long activityId, long itineraryId) throws CompositeException {
        ItineraryComposite itineraryComposite = itineraryComposites.stream()
                .filter(itinerary -> itinerary.getItineraries().stream()
                        .anyMatch(innerItinerary -> innerItinerary.getId() == itineraryId))
                .findFirst()
                .orElseThrow(() -> new CompositeException("Itinerary not found"));

        return itineraryComposite.getActivities().removeIf(activity -> activity.getId() == activityId);
    }

    @Override
    public boolean linkUserToItinerary(User user, long itineraryId) throws CompositeException {
        ItineraryComposite itineraryComposite = itineraryComposites.stream()
                .filter(itinerary -> itinerary.getItineraries().stream()
                        .anyMatch(innerItinerary -> innerItinerary.getId() == itineraryId))
                .findFirst()
                .orElseThrow(() -> new CompositeException("Itinerary not found"));

        itineraryComposite.setUser(user);
        return true;
    }
}
