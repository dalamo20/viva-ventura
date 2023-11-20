package com.vivaventura.presentation;

import com.vivaventura.model.business.exception.ServiceLoadException;
import com.vivaventura.model.business.manager.ItineraryManager;
import com.vivaventura.model.domain.*;
import com.vivaventura.model.services.IService;
import com.vivaventura.model.services.factory.ServiceFactory;
import com.vivaventura.model.services.loginservice.ILoginService;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) throws ServiceLoadException {
        String message = "";
        System.out.println("Current Working Directory: " + System.getProperty("user.dir"));

        ItineraryManager manager = ItineraryManager.getInstance();

        User user = new User("Password1", "catDaddy@gmail.com",
                new Profile("Johnny Blaze", "222-222-2222", "Berlin", true),
                new Subscription(true, true), "catDaddy");
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Da Lat Vacation", "2023-11-23", "09:00",
                new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                        11.935173970248758, 108.4307517539685, 4.3f)));
        activities.add(new Activity("2nd Activity", "2023-11-23", "09:00",
                new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
                        11.935173970248758, 108.4307517539685, 4.3f)));

        //add activities to itinerary
        Itinerary itinerary = new Itinerary("1st Itinerary", activities);

        ItineraryComposite itineraryComposite = new ItineraryComposite(1, user, null, null, null, null, List.of(itinerary));

        boolean isCreated = manager.performAction("CREATE_ITINERARY", itineraryComposite, user);

        if (isCreated) {
            message = "SUCCESS: ItineraryMain:: - Itinerary created.";
        } else {
            message = "FAIL: ItineraryMain:: - Itinerary not created.";
        }

        System.out.println(message);

    }
}

