package com.vivaventura.model.services.factory;

import com.vivaventura.model.business.exception.ServiceLoadException;
import com.vivaventura.model.services.IService;

import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;

public class ServiceFactory {
    //Below is a Singleton Pattern that ensures that the class can only have one object
    //1. Private constructor created
    private ServiceFactory() {
    }

    //2. private attribute that refers to the object
    private static ServiceFactory serviceFactory = new ServiceFactory();

    public static ServiceFactory getInstance() {
        return serviceFactory;
    }

    public IService getService(String serviceName) throws ServiceLoadException {
        try {
            // Class is a parametrizable class. By writing Class<?>, we're declaring a Class object
            // which can be of any type (? is a wildcard).
            // Reference about Generics and Wildcards:http://docs.oracle.com/javase/tutorial/java/generics/wildcards.html
            Class<?> c = Class.forName(getImplName(serviceName));
            return (IService) c.getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            serviceName = serviceName + " not loaded";
            throw new ServiceLoadException(serviceName, ex);
        }
    }

    private String getImplName(String serviceName) throws Exception {
        //provide the correct key to retrieve the property value
        String propertyKey = "Users.ypham.Desktop.danielProjects.msse670Java.viva-ventura.src.main.resources.application.properties";

        //retrieve the property value using the key
        String propertyFileLocation = System.getProperty(propertyKey);

        System.out.println("Property File Location passed : " + propertyFileLocation);

        try (FileInputStream fis = new FileInputStream(propertyFileLocation)) {
            Properties props = new Properties();
            props.load(fis);

            String implName = props.getProperty(serviceName);
            System.out.println("Service implementation for " + serviceName + ": " + implName);
            return implName;
        } catch (IOException e) {
            throw new ServiceLoadException("IOException while loading properties file", e);
        }
    }
}
