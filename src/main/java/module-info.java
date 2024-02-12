module viva.ventura {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.datatransfer;
    requires java.desktop;
    requires org.apache.logging.log4j;
    requires c3p0;
    requires spring.beans;
    requires spring.context;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.orm;
    requires org.slf4j;
    requires java.naming;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    opens com.vivaventura.presentation to javafx.fxml;
    opens com.vivaventura.database to javafx.base;
    opens com.vivaventura.util to javafx.base;
    opens com.vivaventura.model.domain to org.hibernate.orm.core;
    exports com.vivaventura.presentation;
}
