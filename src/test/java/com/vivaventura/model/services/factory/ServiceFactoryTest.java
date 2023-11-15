package com.vivaventura.model.services.factory;

import com.vivaventura.model.business.exception.ServiceLoadException;
import com.vivaventura.model.services.IService;
import com.vivaventura.model.services.itineraryservice.IItineraryService;
import com.vivaventura.model.services.itineraryservice.ItineraryServiceImpl;
import com.vivaventura.model.services.loginservice.ILoginService;
import com.vivaventura.model.services.loginservice.LoginServiceImpl;
import com.vivaventura.model.services.userservice.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import static org.junit.jupiter.api.Assertions.*;

class ServiceFactoryTest {
    private ServiceFactory serviceFactory;

    @BeforeEach
    void setUp() {
        serviceFactory = ServiceFactory.getInstance();
    }

    @Test
    void getInstance() {
        ServiceFactory factory1 = ServiceFactory.getInstance();
        ServiceFactory factory2 = ServiceFactory.getInstance();

        //check that both instances are the same
        assertNotNull(factory1);
        assertNotNull(factory2);
        assertSame(factory1, factory2);
    }

    @Test
    void getService() {
        ILoginService loginService;
        try {
            loginService = (ILoginService)serviceFactory.getService("loginService");
            assertTrue(loginService instanceof LoginServiceImpl);
            System.out.println("testGetLoginService PASSED");
        } catch (ServiceLoadException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void getUserService() {
        IUserService userService;
        try {
            userService = (IUserService) serviceFactory.getService("userService");
            assertNotNull(userService);
        } catch (ServiceLoadException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void getItineraryService() {
        IItineraryService itineraryService;
        try {
            itineraryService = (IItineraryService) serviceFactory.getService("itineraryService");
            assertNotNull(itineraryService);
        } catch (ServiceLoadException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testPropertyFile() {
        // Specify the location of your properties file
        String propertyFileLocation = "/Users/ypham/Desktop/danielProjects/msse670Java/viva-ventura/src/main/resources/application.properties";

        // Load properties from the file
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(propertyFileLocation)) {
            properties.load(fis);
        } catch (IOException e) {
            System.out.println("LAST TEST "+e.getMessage());
        }
        //testing keys in properties file
        assertNotNull(properties.getProperty("loginService"));
        assertNotNull(properties.getProperty("userService"));
        assertNotNull(properties.getProperty("itineraryService"));
    }

}