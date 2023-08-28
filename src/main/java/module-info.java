module com.apollo.htreader {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires commons.validator;
    requires commons.beanutils;
    requires commons.collections;
    requires commons.digester;
    requires commons.logging;

    opens com.apollo.htreader to javafx.fxml;
    exports com.apollo.htreader;
    exports com.apollo.htreader.controllers;
    opens com.apollo.htreader.controllers;
}