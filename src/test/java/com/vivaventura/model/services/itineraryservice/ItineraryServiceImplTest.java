package com.vivaventura.model.services.itineraryservice;

import com.vivaventura.model.domain.Activity;
import com.vivaventura.model.domain.Itinerary;
import com.vivaventura.model.domain.Location;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ItineraryServiceImplTest {
    private Map<String, Itinerary> itineraryMap = new HashMap<>();
    @Test
    void createItinerary() {
        Itinerary itinerary1 = new Itinerary("1st iteration", (List<Activity>) new Activity("Da Lat Vacation", "2023-11-23", "09:00", new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam", 11.935173970248758, 108.4307517539685, 4.3f)));

    }

    @Test
    void getItinerary() {
    }

    @Test
    void getAllItineraries() {
    }

    @Test
    void updateItinerary() {
    }

    @Test
    void deleteItinerary() {
    }
}