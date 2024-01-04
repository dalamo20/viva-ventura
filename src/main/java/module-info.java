module viva.ventura {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.datatransfer;
    requires java.desktop;
    opens com.vivaventura.presentation to javafx.fxml;
    opens com.vivaventura.model.domain to javafx.base;
    opens com.vivaventura.database to javafx.base;
    exports com.vivaventura.presentation;
}