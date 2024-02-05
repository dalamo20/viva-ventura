package com.vivaventura.presentation;

import com.vivaventura.model.business.exception.ServiceLoadException;
import com.vivaventura.model.business.manager.ItineraryManager;
import com.vivaventura.model.domain.Activity;
import com.vivaventura.model.domain.Itinerary;
import com.vivaventura.model.domain.ItineraryComposite;
import com.vivaventura.model.domain.Location;
import com.vivaventura.model.domain.Profile;
import com.vivaventura.model.domain.Subscription;
import com.vivaventura.model.domain.User;
import com.vivaventura.model.services.compservice.CompSvcImpl;
import com.vivaventura.model.services.compservice.CompSvcJDBCImpl;
import com.vivaventura.model.services.compservice.ICompSvc;
import com.vivaventura.model.services.exception.CompSvcEx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Driver extends Application {
    private static final Logger logger = LogManager.getLogger(Driver.class);

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"));
        URL cssResource = getClass().getResource("styles.css");
        if (cssResource != null) {
            scene.getStylesheets().add(cssResource.toExternalForm());
        } else {
            logger.error("Styles.css not found!");
        }
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Driver.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws ServiceLoadException, CompSvcEx {
//        launch(args);
        ICompSvc dao = new CompSvcJDBCImpl();
        Scanner sc = new Scanner(System.in);

        try {
            int choice;
            do {
                logger.info("1. Create itinerary");
                logger.info("2. Show all itineraries");
                logger.info("3. Show itinerary by id");
                logger.info("4. Update itinerary");
                logger.info("5. Delete itinerary by id");
                logger.info("6. Exit");
                logger.info("Enter choice:");

                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        //add itinerary
                        logger.info("Enter itinerary name:");
                        String itineraryName = sc.next();
                        Itinerary itinerary = new Itinerary();
                        itinerary.setName(itineraryName);
                        dao.addItinerary(itinerary);
                        break;
                    case 2:
                        //get all itineraries
                        List<Itinerary> allItineraries = dao.getAllItineraries();
                        for (Itinerary it : allItineraries) {
                            logger.info(it);
                        }
                        break;
                    case 3:
                        //get itinerary
                        logger.info("Enter itinerary id:");
                        int itineraryId = sc.nextInt();
                        Itinerary fetchedItinerary = dao.getItinerary(itineraryId);
                        logger.info("Fetched itinerary: " + fetchedItinerary);
                        break;
                    case 4:
                        //update itinerary
                        logger.info("Enter itinerary id to update:");
                        int updateId = sc.nextInt();
                        logger.info("Enter new name:");
                        String newName = sc.next();
                        Itinerary updatedItinerary = new Itinerary();
                        updatedItinerary.setId(updateId);
                        updatedItinerary.setName(newName);
                        dao.updateItinerary(updatedItinerary);
                        break;
                    case 5:
                        //delete itinerary
                        logger.info("Enter itinerary id to delete:");
                        int deleteId = sc.nextInt();
                        dao.deleteItinerary(deleteId);
                        break;
                    case 6:
                        logger.info("Thank you, Good bye!");
                        break;
                    default:
                        logger.info("Enter valid choice");
                        break;
                }
            } while (choice != 6);
        } catch (CompSvcEx | InputMismatchException e) {
            logger.error("Error occurred: ", e);
        } finally {
            sc.close();
        }
//
//        String message = "";
//        logger.info("Current Working Directory: " + System.getProperty("user.dir"));
//
//        ItineraryManager manager = ItineraryManager.getInstance();
//
//        User user = new User("Password1", "catDaddy@gmail.com",
//                new Profile("Johnny Blaze", "222-222-2222", "Berlin", true),
//                new Subscription(true, true), "catDaddy");
//        List<Activity> activities = new ArrayList<>();
//        activities.add(new Activity("Da Lat Vacation", "2023-11-23", "09:00",
//                new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
//                        11.935173970248758, 108.4307517539685, 4.3f)));
//        activities.add(new Activity("2nd Activity", "2023-11-23", "09:00",
//                new Location("Crazy House", "03 Đ. Huỳnh Thúc Kháng, Phường 4, Thành phố Đà Lạt, Lâm Đồng 66115, Vietnam",
//                        11.935173970248758, 108.4307517539685, 4.3f)));
//
//        Itinerary itinerary = new Itinerary("1st Itinerary", activities);
//
//        ItineraryComposite itineraryComposite = new ItineraryComposite(1, user, null, null, null, null, List.of(itinerary));
//
//        boolean isCreated = manager.performAction("CREATE_ITINERARY", itineraryComposite, user);
//
//        if (isCreated) {
//            message = "SUCCESS: ItineraryMain:: - Itinerary created.";
//        } else {
//            message = "FAIL: ItineraryMain:: - Itinerary not created.";
//        }
//
//        logger.info(message);
//
//        logger.trace("Trace Message!");
//        logger.debug("Debug Message!");
//        logger.info("Info Message!");
//        logger.warn("Warn Message!");
//        logger.error("Error Message!");
//        logger.fatal("Failure Message!");
//        logger.info("Hello World!");

    }
}
