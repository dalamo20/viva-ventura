package com.vivaventura.model.services.compositeservice;

import com.vivaventura.model.domain.ItineraryComposite;
import com.vivaventura.model.services.IService;

public interface ICompositeService extends IService {
    public final String NAME = "ICompositeService";
    ItineraryComposite createItineraryComposite(ItineraryComposite itineraryComposite);

    ItineraryComposite getItineraryCompositeById(long id);

    void updateItineraryComposite(ItineraryComposite itineraryComposite);

    void deleteItineraryComposite(long id);
}
