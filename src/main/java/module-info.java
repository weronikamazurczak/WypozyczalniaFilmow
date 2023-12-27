module WypozyczalniaFilmow {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires org.slf4j;
    requires java.sql;
    requires com.oracle.database.jdbc;

    opens Client to javafx.fxml, javafx.graphics;
    exports Client;
}