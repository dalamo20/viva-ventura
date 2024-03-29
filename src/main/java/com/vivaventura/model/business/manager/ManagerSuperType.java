package com.vivaventura.model.business.manager;

import com.vivaventura.model.business.exception.PropertyFileNotFoundException;
import com.vivaventura.model.domain.ItineraryComposite;
import com.vivaventura.model.domain.User;
import com.vivaventura.model.services.manager.PropertyManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

public abstract class ManagerSuperType {
    private static final Logger logger = LogManager.getLogger(ManagerSuperType.class);
    /**
     * What you're seeing below, is called a static initializer block,
     * which gets executed at the time when the class that contains it or extends it is referenced.
     *
     * What we hope to achieve in this application is that when the FleetRentalManager(which extends this class)
     * is referenced, we want the application properties to be loaded up so the properties contents are available
     * for use by all tiers under the business tier.
     *
     * Reference site on static initializer block:
     * http://www.developer.com/java/other/article.php/2238491/The-Essence-of-OOP-using-Java-Static-Initializer-Blocks.htm
     *
     */
    static
    {
        try
        {
            ManagerSuperType.loadProperties();
        }
        catch (PropertyFileNotFoundException propertyFileNotFoundException)
        {
            logger.info("Application Properties failed to be loaded - Application exiting...");
            System.exit(1); // since we can't load the properties and this being crucial we'll exit the application!
        }
    } // end of static initializer block

    /**
     * Generic method that all clients of this class can call to perform certain actions.
     *
     * @param commandString
     *                      Holds the service name to be invoked
     * @param Composite
     *                      Holds application specific domain state
     * @return
     *         false
     *              if action failed
     *         true
     *              if action is successful
     */
    public abstract boolean performAction(String commandString, ItineraryComposite itineraryComposite, User user);


    /**
     * Loads the property file into memory so its available for use by all tiers (business and below)
     * @throws PropertyFileNotFoundException
     *                                Properties file could bot be loaded.
     */
    public static void loadProperties () throws PropertyFileNotFoundException
    {
        /*
         * FAQ: How to pass in Properties file to app while I'm testing?
         *
         * Answer:
         *
         * If using ANT:
         * ============
         * Property file is located by making a call to
         * System.getProperty(prop_location), which actually
         * reads off from the target runTestDriver in build.xml
         *   <sysproperty key="prop_location" value="${prop.dir}services.xml"/>
         *
         * If running in Eclipse
         * =====================
         *
         * Right click on the unit test and navigate to
         *       1. Run As -> Run Configuration
         *       2. Select Arguments Tab
         *       3. In VM Arguments section, add the -D property
         * 	           -Dprop_location=<drive><location>\services.xml
         *            Example:
         * 	           -Dprop_location=E:\FleetRental\config\services.xml
         *
         * If running on command line
         * ==========================
         * you'd pass in the above -D option with the java command.
         */

        String propertyFileLocation = System.getProperty("prop_location");

        if (propertyFileLocation != null)
        {
            // Now that we have the property file location, lets have the
            // PropertyManager class load it up
            PropertyManager.loadProperties(propertyFileLocation);
        }
        else
        {
            logger.info("Property file location not set. Passed in value is: " + propertyFileLocation + ".");
            throw new PropertyFileNotFoundException ("Property file location not set", null);
        }


    } //end loadProperties
}
