package com.vivaventura.model.services.manager;

import com.vivaventura.model.business.exception.PropertyFileNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.*;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * NOTE: This class is not discussed in class slides, however recommended to understand and
 *       highly encouraged to apply in your homework. Its a neat way of loading properties into
 *       your application once and use it across all tiers (business, service etc)
 *
 * This manager class primary responsibility is to the load the property file
 * into memory and make it available for all other classes to use.
 *
 * This class's loadProperties method is called by the FleetRentalManager.
 *
 * Once loaded, any other class can call it and request for a property value.
 *
 * For example:
 *   1. The services.xml file that was loaded for this application
 *      has these values:
 *  		 jdbc.url = jdbc:odbc:TimeZone
 *      	 jdbc.user = Homer
 *   		 jdbc.password = Duff
 *   2. Once this file is loaded, if a class wants to get the value for the
 *      key jdbc.url, you would make the following call:
 *           PropertyManager.getPropertyValue("jdbc.url");
 *      This would return the string value, "jdbc:odbc:TimeZone"
 *
 *
 *   FAQ: How to pass in Properties file to app while unit testing?
 *
 *   Answer:
 *   	 If running in Eclipse
 *       =====================
 *       Right click on the unit test and navigate to
 *
 *       1. Run As -> Run Configuration
 *       2. Select Arguments Tab
 *       3. In VM Arguments section, add the -D property
 * 	           -Dprop_location=E:\FleetRental\config\services.xml
 *
 *       If running on command line
 *       ==========================
 *       You'd pass in the above -D option with the java command.
 *
 * @author Mike.Prasad
 *
 */

public class PropertyManager extends DefaultHandler {
    private static Properties properties;
    private static final Logger logger = LogManager.getLogger(PropertyManager.class);

    /**
     * Load the properties file so its contents are available
     * for classes in the Model tier.
     *
     * @param propertyFileLocation
     * @throws PropertyFileNotFoundException
     */
    public static void loadProperties(String propertyFileLocation) throws PropertyFileNotFoundException {
        properties = new Properties();
            try{
                SAXParserFactory factory = SAXParserFactory.newInstance();
                factory.setValidating(true);
                SAXParser parser = factory.newSAXParser();
                parser.parse(new File(propertyFileLocation), new DefaultHandler() {
                    private String curr;
                    @Override
                    public void startElement(String uri, String localName, String qName, Attributes attrib) throws SAXException {
                        if ("property".equals(qName)) {
                            String key = attrib.getValue("key");
                            if (key != null && !key.isEmpty()) {
                                curr = key;
                            }
                        }
                    }

                    @Override
                    public void characters(char[] ch, int start, int length) throws SAXException {
                        if (curr != null) {
                            String value = new String(ch, start, length).trim();
                            properties.setProperty(curr, value);
                            curr = null;
                        }
                    }
                });
                logger.info("Property file successfully loaded from location: {}", propertyFileLocation);
                logger.info("Property Contents: {}", properties.toString());
            } catch (ParserConfigurationException e) {
                logger.error("Parser config error loading props file: ", e.getMessage());
                throw new PropertyFileNotFoundException("Parser config error", e);
            } catch (IOException e) {
                logger.error("IO error loading props file:", e.getMessage());
                throw new PropertyFileNotFoundException("IO error", e);
            } catch (SAXException e) {
                logger.error("SAX parser error loading props file: ", e.getMessage());
                throw new PropertyFileNotFoundException("SAX parser error", e);
            }
    }

    /**
     * This methods returns the Value for the passed key.
     *
     * @param key - key whose value needs to be returned
     * @return String - value for the passed key
     */
    static public String getPropertyValue (String key)
    {
        return properties.getProperty(key);
    }
}


