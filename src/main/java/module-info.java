module viva.ventura {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.datatransfer;
    requires java.desktop;
    opens com.vivaventura.presentation to javafx.fxml;
    exports com.vivaventura.presentation;
}