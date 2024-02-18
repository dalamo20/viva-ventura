package com.vivaventura.util;

import com.vivaventura.model.domain.Activity;
import com.vivaventura.model.domain.Itinerary;
import com.vivaventura.model.domain.Location;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class HibernateUtil {
    private static final Logger logger = LoggerFactory.getLogger(HibernateUtil.class);

    private static SessionFactory sessionFactory;
        public static SessionFactory getSessionFactory(){
            if (sessionFactory == null) {
                try {
                    Configuration configuration = new Configuration();

                    Properties settings = new Properties();
                    settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                    settings.put(Environment.URL, "jdbc:mysql://localhost:3306/vivadb");
                    settings.put(Environment.USER, "root");
                    settings.put(Environment.PASS, "root");
                    settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
                    settings.put(Environment.SHOW_SQL, "true");
                    settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                    settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                    configuration.setProperties(settings);
                    configuration.addAnnotatedClass(Itinerary.class);
                    configuration.addAnnotatedClass(Activity.class);
                    configuration.addAnnotatedClass(Location.class);

                    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                } catch (Exception e){
                    logger.error("Error building session factory: ", e);
                }
            }
            return sessionFactory;
        }
}
