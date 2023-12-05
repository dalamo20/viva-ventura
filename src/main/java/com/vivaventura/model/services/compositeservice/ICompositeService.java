package com.vivaventura.model.services.compositeservice;

import com.vivaventura.model.domain.Activity;
import com.vivaventura.model.domain.Itinerary;
import com.vivaventura.model.domain.ItineraryComposite;
import com.vivaventura.model.domain.User;
import com.vivaventura.model.services.IService;
import com.vivaventura.model.services.exception.CompositeException;

import java.util.List;

public interface ICompositeService extends IService {
    public final String NAME = "ICompositeService";

    //itinerary CRUD
    List<Itinerary> listUserItineraries(User user) throws CompositeException;

    Itinerary getItineraryById(int id) throws CompositeException;

    boolean createItinerary(ItineraryComposite itineraryComposite, User user) throws CompositeException;

    boolean updateItinerary(ItineraryComposite itineraryComposite, User user) throws CompositeException;

    boolean deleteItinerary(int itineraryId) throws CompositeException;

    //activity CRUD
    List<Activity> listActivitiesInItinerary(int itineraryId) throws CompositeException;

    boolean createActivity(Activity activity, int itineraryId) throws CompositeException;

    boolean updateActivity(Activity activity, int itineraryId) throws CompositeException;

    boolean deleteActivity(int activityId, int itineraryId) throws CompositeException;

    //linking a user to an itinerary
    boolean linkUserToItinerary(User user, int itineraryId) throws CompositeException;

}
