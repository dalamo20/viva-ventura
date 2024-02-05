package com.vivaventura.model.services.compservice;

import com.vivaventura.model.domain.Activity;
import com.vivaventura.model.domain.Itinerary;
import com.vivaventura.model.domain.Location;
import com.vivaventura.model.services.exception.CompSvcEx;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompSvcImpl implements ICompSvc{
    private final Logger logger = LogManager.getLogger(CompSvcImpl.class);

    private Map<Integer, Itinerary> itineraries = new HashMap<>();
    private Map<Integer, Activity> activities = new HashMap<>();
    private Map<Integer, Location> locations = new HashMap<>();
    private int nextItineraryId = 1;
    private int nextActivityId = 1;
    private int nextLocationId = 1;

    @Override
    public void addItinerary(Itinerary itinerary) throws CompSvcEx {
        itinerary.setId(nextItineraryId++);
        itineraries.put(itinerary.getId(), itinerary);
        logger.info("Itinerary with ID: " + itinerary.getId() + " created.");
    }

    @Override
    public Itinerary getItinerary(int id) throws CompSvcEx {
        logger.info("Fetching Itinerary with ID: " + id);
        return itineraries.get(id);
    }

    @Override
    public void updateItinerary(Itinerary itinerary) throws CompSvcEx {
        if (itineraries.containsKey(itinerary.getId())) {
            itineraries.replace(itinerary.getId(), itinerary);
            logger.info("Itinerary with ID: " + itinerary.getId() + " is updated.");
        } else {
            throw new CompSvcEx("Itinerary not found for updating");
        }
    }

    @Override
    public void deleteItinerary(int id) throws CompSvcEx {
        logger.info("Deleted Itinerary with ID: "+ id);
        itineraries.remove(id);
    }

    @Override
    public void addActivity(Activity activity) throws CompSvcEx {
        activity.setId(nextActivityId++);
        activities.put(activity.getId(), activity);
        logger.info("Activity with ID: " + activity.getId() + " created.");
    }

    @Override
    public Activity getActivity(int id) throws CompSvcEx {
        logger.info("Fetching Activity with ID: " + id);
        return activities.get(id);
    }

    @Override
    public void updateActivity(Activity activity) throws CompSvcEx {
        if (activities.containsKey(activity.getId())) {
            activities.replace(activity.getId(), activity);
            logger.info("Updated Activity with ID: " + activity.getId());
        } else {
            throw new CompSvcEx("Activity not found for updating");
        }
    }

    @Override
    public void deleteActivity(int id) throws CompSvcEx {
        logger.info("Deleted Activity with ID: " + id);
        activities.remove(id);
    }

    @Override
    public void addLocation(Location location) throws CompSvcEx {
        location.setId(nextLocationId++);
        locations.put(location.getId(), location);
        logger.info("Location with ID: " + location.getId() + " created.");
    }

    @Override
    public Location getLocation(int id) throws CompSvcEx {
        logger.info("Fetching Location with ID: " + id);
        return locations.get(id);
    }

    @Override
    public void updateLocation(Location location) throws CompSvcEx {
        if (locations.containsKey(location.getId())) {
            locations.replace(location.getId(), location);
            logger.info("Updated Location with ID: " + location.getId());
        } else {
            throw new CompSvcEx("Location not found for updating");
        }
    }

    @Override
    public void deleteLocation(int id) throws CompSvcEx {
        logger.info("Deleted Location with ID: " + id);
        locations.remove(id);
    }

    @Override
    public List<Itinerary> getAllItineraries() throws CompSvcEx {
        List<Itinerary> allItineraries = new ArrayList<>(itineraries.values());
        logger.debug("Fetching itineraries ", allItineraries.size());
        return List.copyOf(allItineraries);
    }

    @Override
    public List<Activity> getAllActivities() throws CompSvcEx {
        List<Activity> allActivities = new ArrayList<>(activities.values());
        logger.debug("Fetching activities ", allActivities.size());
        return List.copyOf(allActivities);
    }

    @Override
    public List<Location> getAllLocations() throws CompSvcEx {
        List<Location> allLocations = new ArrayList<>(locations.values());
        logger.debug("Fetching all locations ", allLocations.size());
        return List.copyOf(allLocations);
    }
}
