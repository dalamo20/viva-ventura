//package com.vivaventura.model.services.loginservice;
//
//import com.vivaventura.model.business.exception.PropertyFileNotFoundException;
//import com.vivaventura.model.business.exception.ServiceLoadException;
//import com.vivaventura.model.domain.ItineraryComposite;
//import com.vivaventura.model.domain.Profile;
//import com.vivaventura.model.domain.Subscription;
//import com.vivaventura.model.domain.User;
//import com.vivaventura.model.services.exception.LoginException;
//import com.vivaventura.model.services.factory.ServiceFactory;
//import com.vivaventura.model.services.manager.PropertyManager;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class LoginServiceImplTest {
//    private static ServiceFactory serviceFactory;
//    private static User user;
//    private static ItineraryComposite itineraryComposite = new ItineraryComposite();
//
//    @BeforeAll
//    static void setUp() {
//        // Hmmm, we have to load the properties via the PropertyManager
//        String propertyFileLocation = System.getProperty("prop_location");
//
//        // Now that we have the property file location, let's have the
//        // PropertyManager class load it up
//        try {
//            PropertyManager.loadProperties(propertyFileLocation);
//        } catch (PropertyFileNotFoundException e) {
//            e.printStackTrace();
//            fail("PropertyFileNotFoundException");
//        }
//
//        serviceFactory = ServiceFactory.getInstance();
//
//        user = new User("CatsAreCool", "catDaddy@pawmail.com", new Profile("Johnny Blaze", "222-222-2222", "Berlin", true), new Subscription(true, true), "catDaddy");
//        itineraryComposite.setUser(user);
//    }
//
//    @Test
//    public final void testAuthenticateCustomer() {
//
//        //
//        // USE THIS APPROOACH OF CASTING TO AN INTERFACE
//        //
//        // Here we are casting Factory output to ILoginService, which
//        // means that loginService will only see methods declared in
//        // the interface and implemented by LoginServiceImpl
//        //
//        ILoginService loginService;
//        try {
//            loginService = (ILoginService) serviceFactory
//                    .getService(ILoginService.NAME);
//            assertTrue(loginService.authenticateUser(itineraryComposite));
//        } catch (ServiceLoadException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            fail("ServiceLoadException");
//        } catch (LoginException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            fail("LoginException");
//
//        }
//
//        //
//        // THIS TO ILLUSTRATE THAT YOU BY CASTING TO AN IMPL AND THE METHOD
//        // VISIBILITY RULES THAT GET IMPOSED!!
//        //
//        // Here we are casting Factory output to LoginServiceImpl, which
//        // means that loginServiceImpl will see not only methods declared in
//        // the interface and implemented by LoginServiceImpl but also any
//        // other additional public methods declared in LoginServiceImpl
//        // but *not* private methods!!
//        //
//        // Good practice is to limit the impl to the methods declared in the
//        // interface and
//        // additional methods(if really needed) be declared as private!
//        //
//
//        try {
//            LoginServiceImpl loginServiceImpl = (LoginServiceImpl) serviceFactory
//                    .getService(ILoginService.NAME);
//            assertTrue(loginServiceImpl.authenticateUser(itineraryComposite));
//        } catch (ServiceLoadException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            fail("ServiceLoadException");
//        }
//    }
//}