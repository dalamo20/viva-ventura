package com.vivaventura.model.services.manager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PropertyManagerTest {

    @Test
    public void loadProperties() {
        //setting vm options
        String propertyFileLocation = System.getProperty("prop_location");
        assertDoesNotThrow(() -> PropertyManager.loadProperties(propertyFileLocation));
    }

    @Test
    public void getProperty() {
        String propertyFileLocation = System.getProperty("prop_location");
        assertDoesNotThrow(() -> PropertyManager.loadProperties(propertyFileLocation));
        // Check if ICompSvc key returns path ref to the Impl class, also with jdbc
        assertEquals("com.vivaventura.model.services.compservice.CompSvcHibernateImpl", PropertyManager.getPropertyValue("ICompSvc"));
        assertEquals("jdbc:mysql://localhost:3306/vivadb", PropertyManager.getPropertyValue("jdbc.url"));
        assertEquals("root", PropertyManager.getPropertyValue("jdbc.user"));
    }
}