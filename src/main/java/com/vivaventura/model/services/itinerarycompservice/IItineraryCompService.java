package com.vivaventura.model.services.itinerarycompservice;

import com.vivaventura.model.domain.ItineraryComposite;
import com.vivaventura.model.services.IService;

public interface IItineraryCompService extends IService {
    ItineraryComposite createItineraryComposite(ItineraryComposite itineraryComposite);

    ItineraryComposite getItineraryCompositeById(long id);

    void updateItineraryComposite(ItineraryComposite itineraryComposite);

    void deleteItineraryComposite(long id);
}
