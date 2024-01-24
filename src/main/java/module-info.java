module com.projects.wypozyczalniafilmow {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires org.testfx;
    requires org.testfx.junit5;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires org.slf4j;
    requires java.sql;
    requires com.oracle.database.jdbc;

    opens Client to javafx.fxml, javafx.graphics, org.testfx.junit5;
    exports Client;
}