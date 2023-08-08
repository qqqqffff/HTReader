module com.apollo.htreader {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.apollo.htreader to javafx.fxml;
    exports com.apollo.htreader;
    exports com.apollo.htreader.controllers;
    opens com.apollo.htreader.controllers;
}