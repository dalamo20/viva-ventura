package com.vivaventura.model.services.compservice;

import com.vivaventura.model.domain.Activity;
import com.vivaventura.model.domain.Itinerary;
import com.vivaventura.model.domain.Location;
import com.vivaventura.model.services.exception.CompSvcEx;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Query;

import java.util.List;

public class CompSvcHibernateImpl implements ICompSvc {
    private final Logger logger = LogManager.getLogger(CompSvcHibernateImpl.class);

    private final SessionFactory sessionFactory;

    public CompSvcHibernateImpl() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }
    public CompSvcHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    @Override
    public void addItinerary(Itinerary itinerary) throws CompSvcEx {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(itinerary);
            transaction.commit();
            session.close();
            logger.info("Itinerary added: " + itinerary);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Failed to add itinerary: " + itinerary.getName(), e);
            throw new CompSvcEx("Failed to add itinerary", e);
        }
    }

    @Override
    public Itinerary getItinerary(int id) throws CompSvcEx {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Itinerary itinerary = session.get(Itinerary.class, id);
            transaction.commit();
            session.close();
            return itinerary;
        } catch (HibernateException e) {
            throw new CompSvcEx("Failed to retrieve itinerary", e);
        }
    }


    @Override
    public void updateItinerary(Itinerary itinerary) throws CompSvcEx{
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(itinerary);
            transaction.commit();
            session.close();
            logger.info("Itinerary updated: " + itinerary);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Failed to update itinerary: " + itinerary.getName(), e);
            throw new CompSvcEx("Failed to update itinerary", e);
        }
    }

    @Override
    public void deleteItinerary(int id) throws CompSvcEx{
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Itinerary itinerary = session.get(Itinerary.class, id);
            if (itinerary != null) {
                session.delete(itinerary);
                transaction.commit();
                session.close();
            } else {
                throw new CompSvcEx("Itinerary with ID " + id + " does not exist.");
            }
        } catch (HibernateException e) {
            throw new CompSvcEx("Failed to delete itinerary", e);
        }
    }

    @Override
    public List<Itinerary> getAllItineraries() throws CompSvcEx{
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Itinerary> itineraries = session.createQuery("from Itinerary", Itinerary.class).list();
            transaction.commit();
            logger.info("Retrieved all activities: " + itineraries);
            return itineraries;
        } catch (Exception e) {
            logger.error("Failed to retrieve all itineraries", e);
            throw new CompSvcEx("Failed to retrieve all itineraries", e);
        }
    }

    @Override
    public void addActivity(Activity activity) throws CompSvcEx{
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(activity);
            transaction.commit();
            session.close();
            logger.info("Activity added: " + activity);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Failed to add activity: " + activity.getName(), e);
            throw new CompSvcEx("Failed to add activity", e);
        }
    }

    @Override
    public Activity getActivity(int id) throws CompSvcEx{
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Activity activity = session.get(Activity.class, id);
            transaction.commit();
            session.close();
            return activity;
        } catch (HibernateException e) {
            throw new CompSvcEx("Failed to retrieve activity", e);
        }
    }

    @Override
    public void updateActivity(Activity activity) throws CompSvcEx{
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(activity);
            transaction.commit();
            session.close();
            logger.info("Activity updated: " + activity);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Failed to update activity: " + activity.getName(), e);
            throw new CompSvcEx("Failed to update activity", e);
        }
    }

    @Override
    public void deleteActivity(int id) throws CompSvcEx{
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Activity activity = session.get(Activity.class, id);
            if (activity != null) {
                session.delete(activity);
                transaction.commit();
                session.close();
            } else {
                throw new CompSvcEx("Activity with ID " + id + " does not exist.");
            }
        } catch (HibernateException e) {
            throw new CompSvcEx("Failed to delete activity", e);
        }
    }

    @Override
    public List<Activity> getAllActivities() throws CompSvcEx {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Activity> activities = session.createQuery("from Activity", Activity.class).list();
            transaction.commit();
            logger.info("Retrieved all activities: " + activities);
            return activities;
        } catch (Exception e) {
            logger.error("Failed to retrieve all activities", e);
            throw new CompSvcEx("Failed to retrieve all activities", e);
        }
    }


    @Override
    public void addLocation(Location location) throws CompSvcEx{
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(location);
            transaction.commit();
            session.close();
            logger.info("Location added: " + location);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Failed to add location: " + location.getName(), e);
            throw new CompSvcEx("Failed to add location", e);
        }
    }

    @Override
    public Location getLocation(int id) throws CompSvcEx{
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Location location = session.get(Location.class, id);
            transaction.commit();
            session.close();
            return location;
        } catch (HibernateException e) {
            throw new CompSvcEx("Failed to retrieve location", e);
        }
    }

    @Override
    public void updateLocation(Location location) throws CompSvcEx{
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(location);
            transaction.commit();
            session.close();
            logger.info("Location updated: " + location);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Failed to update location: " + location.getName(), e);
            throw new CompSvcEx("Failed to update location", e);
        }
    }

    @Override
    public void deleteLocation(int id) throws CompSvcEx {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Location locationToDelete = session.get(Location.class, id);
            if (locationToDelete != null) {
                session.delete(locationToDelete);
                transaction.commit();
                session.close();
            } else {
                throw new CompSvcEx("Location with ID " + id + " does not exist.");
            }
        } catch (HibernateException e) {
            throw new CompSvcEx("Failed to delete location", e);
        }
    }

    @Override
    public List<Location> getAllLocations() throws CompSvcEx{
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Location> locations = session.createQuery("from Location", Location.class).list();
            transaction.commit();
            logger.info("Retrieved all activities: " + locations);
            return locations;
        } catch (Exception e) {
            logger.error("Failed to retrieve all locations", e);
            throw new CompSvcEx("Failed to retrieve all locations", e);
        }
    }
}
