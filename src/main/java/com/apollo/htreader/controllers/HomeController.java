package com.apollo.htreader.controllers;

import com.apollo.htreader.utilities.DataLoader;
import com.apollo.htreader.utilities.HTMLParser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.apache.commons.validator.routines.UrlValidator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class HomeController {
    @FXML Button previousElement;
    @FXML ComboBox<String> htmlFilterCombobox;
    @FXML Button nextElement;
    @FXML TextField urlTextbox;
    @FXML Button readURLButton;
    @FXML Button saveFileButton;
    @FXML Button loadFileButton;
    @FXML TextArea textDisplay;
    UrlValidator urlValidator = new UrlValidator();

    @FXML
    public void initialize(){
        urlTextbox.setText(DataLoader.fetchURL());

        urlTextbox.setOnKeyPressed(event -> {
            if(urlValidator.isValid(urlTextbox.getText())){
                if(DataLoader.saveURL(urlTextbox.getText()))
                    System.out.println("Successfully saved url");
                else
                    System.out.println("Unsuccessfully saved url");
            }
            else{
                System.out.println("Invalid URL");
            }

        });

        readURLButton.setOnAction(event -> {
            if(!urlTextbox.getText().isEmpty()){
                try {
                    URL url = new URL(urlTextbox.getText());
                    Scanner sc = new Scanner(url.openStream());

                    StringBuilder builder = new StringBuilder();
                    while(sc.hasNext()){
                        String line = HTMLParser.parseTag(sc.nextLine(), sc);
                        System.out.println(line);
                        if(!line.equals("")){
                            line =  HTMLParser.removeTags(line);
                            builder.append(line).append('\n');
                        }
                    }

                    textDisplay.setText(builder.toString());


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        saveFileButton.setOnAction(event -> {
            if(!textDisplay.getText().isEmpty()){

            }
        });

        if(!Objects.equals(urlTextbox.getText(), "")) readURLButton.fire();
    }
}
