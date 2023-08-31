package com.tech.pharmacy_shop_management_system;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class TestUI extends Application {

    @FXML
    private Label printTest;
    public void displayTest(){

        String text = "Hello Group 7 javaFX developers";
        printTest.setText(text);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TestUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 735, 469);
        stage.setTitle("JavaFX");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {

        launch();
    }

}
