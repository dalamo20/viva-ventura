package com.vivaventura.presentation;

import com.vivaventura.model.business.exception.PropertyFileNotFoundException;
import com.vivaventura.model.business.exception.ServiceLoadException;
import com.vivaventura.model.business.manager.ItineraryManager;
import com.vivaventura.model.domain.Activity;
import com.vivaventura.model.domain.Itinerary;
import com.vivaventura.model.domain.ItineraryComposite;
import com.vivaventura.model.domain.Location;
import com.vivaventura.model.domain.Profile;
import com.vivaventura.model.domain.Subscription;
import com.vivaventura.model.domain.User;
import com.vivaventura.model.services.compservice.CompSvcHibernateImpl;
import com.vivaventura.model.services.compservice.CompSvcImpl;
import com.vivaventura.model.services.compservice.CompSvcJDBCImpl;
import com.vivaventura.model.services.compservice.ICompSvc;
import com.vivaventura.model.services.exception.CompSvcEx;
import com.vivaventura.model.services.manager.PropertyManager;
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
        launch(args);

        String propertyFileLocation = "/Users/ypham/Desktop/danielProjects/msse670Java/viva-ventura/src/main/resources/config/services.xml";
        try {
            PropertyManager.loadProperties(propertyFileLocation);
        } catch (PropertyFileNotFoundException e) {
            logger.info("File not found: ", e);
        }
    }
}