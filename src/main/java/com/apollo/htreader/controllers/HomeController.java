package com.apollo.htreader.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class HomeController {
    @FXML Button previousElement;
    @FXML ComboBox<String> htmlFilterCombobox;
    @FXML Button nextElement;
    @FXML TextField urlTextbox;
    @FXML Button readURLButton;
    @FXML Button saveFileButton;
    @FXML Button loadFileButton;

    @FXML
    public void initialize(){

    }
}
