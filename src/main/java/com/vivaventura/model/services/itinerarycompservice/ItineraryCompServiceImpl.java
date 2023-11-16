package com.vivaventura.model.services.itinerarycompservice;

import com.vivaventura.model.domain.ItineraryComposite;

import java.util.HashMap;
import java.util.Map;

public class ItineraryCompServiceImpl implements IItineraryCompService{
    private final Map<Long, ItineraryComposite> itineraryComp = new HashMap<>();
    @Override
    public ItineraryComposite createItineraryComposite(ItineraryComposite itineraryComposite) {
        long id = itineraryComposite.generateId();
        itineraryComposite.setId(id);
        itineraryComp.put(id, itineraryComposite);
        return itineraryComposite;
    }

    @Override
    public ItineraryComposite getItineraryCompositeById(long id) {
        return itineraryComp.get(id);
    }

    @Override
    public void updateItineraryComposite(ItineraryComposite itineraryComposite) {
        long id = itineraryComposite.getId();
        if (itineraryComp.containsKey(id)) {
            itineraryComp.put(id, itineraryComposite);
        } else {
            throw new IllegalArgumentException("ID: " + id + " does not exist.");
        }
    }

    @Override
    public void deleteItineraryComposite(long id) {
        itineraryComp.remove(id);
    }
}
