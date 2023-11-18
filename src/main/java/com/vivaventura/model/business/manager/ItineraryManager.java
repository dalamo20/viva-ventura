package com.vivaventura.model.business.manager;

import java.awt.*;

/**
 *  FULL ARGUMENT (PUT THIS IN THE BOX AFTER CHANGING PATH)
 * WARNING:  follow this format exactly, no spaces anywhere.
 * -Dprop_location:prop_location=C:\Users\rgran\Dropbox\ECLIPSE-WORKSPACE\MSSE670-AIRLINE-RESERVATION\AirlineReservation\config\application.properties
 *
 * @author Randall Granier
 *
 */
public class ItineraryManager extends ManagerSuperType{
    private static ItineraryManager itineraryManager;

    private ItineraryManager() {};
    @Override
    public boolean performAction(String commandString, Composite composite) {
        return false;
    }


}
