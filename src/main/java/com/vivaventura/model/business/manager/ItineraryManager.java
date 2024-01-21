package com.vivaventura.model.business.manager;

import com.vivaventura.model.business.exception.ServiceLoadException;
import com.vivaventura.model.domain.ItineraryComposite;
import com.vivaventura.model.domain.User;
import com.vivaventura.model.services.compositeservice.ICompositeService;
import com.vivaventura.model.services.exception.CompositeException;
import com.vivaventura.model.services.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *  FULL ARGUMENT (PUT THIS IN THE BOX AFTER CHANGING PATH)
 * WARNING:  follow this format exactly, no spaces anywhere.
 * -Dprop_location:prop_location=C:\Users\rgran\Dropbox\ECLIPSE-WORKSPACE\MSSE670-AIRLINE-RESERVATION\AirlineReservation\config\application.properties
 *
 * @author Randall Granier
 *
 */
public class ItineraryManager extends ManagerSuperType{
    private static final Logger logger = LogManager.getLogger(ItineraryManager.class);
    private static ItineraryManager myInstance;

    private ItineraryManager() {};
    /**
     * Assures that there is only one FleetRentalManager created.
     * @return FleetRentalManager instance
     */
    public static synchronized ItineraryManager getInstance() {
        if (myInstance == null) {
            myInstance = new ItineraryManager();
        }
        return myInstance;
    }

    /**
     * Generic method that all clients of this class can call to perform certain
     * actions.
     *
     * @param commandString
     *            Holds the service name to be invoked *
     * @param ItineraryComposite
     *            Holds application specific domain state
     * @return false if action failed true if action is successful
     */
    @Override
    public boolean performAction(String commandString, ItineraryComposite itineraryComposite, User user) {
        boolean action = false;
        if (commandString.equals("CREATE_ITINERARY")) {
            action = createItinerary(ICompositeService.NAME, itineraryComposite, user);
        }
        else {
            logger.info("INFO:  Add new workflows here using here using if/else.");
        }
        return action;
    }

    /**
     * Method delegates to the ServiceFactory to execute a service. Good part of
     * this approach is that the Manager knows the service by a string name -
     * thus achieving the decoupling effect that we so desire in the MVC
     * approach.
     *
     * @param ItineraryComposite contains the customer registration info needed
     * @param commandString      contains the service that needs to be performed
     */
    public boolean createItinerary(String commandString, ItineraryComposite itineraryComposite, User user) {
        boolean isCreated = false;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ICompositeService itineraryService;

        try {
            itineraryService = (ICompositeService) serviceFactory.getService(commandString);
            isCreated = itineraryService.createItinerary(itineraryComposite, user);
        } catch (ServiceLoadException e1) {
            logger.error("ERROR: ItineraryManager::failed to load Composite Service.", e1);
        } catch (CompositeException re) {
            logger.error("ERROR:  ItineraryManager::createItinerary() failed", re);
            re.printStackTrace();
        } catch (Exception ex) {
            logger.error("ERROR: ItineraryManager::Unknown error.", ex);
        }

        return isCreated;
    }

}
