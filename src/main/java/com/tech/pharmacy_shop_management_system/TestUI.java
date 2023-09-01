package com.tech.pharmacy_shop_management_system;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TestUI extends Application {

    @FXML
    private Label printTest;


    @FXML
    private Button homeBtn;

    @FXML
    private AnchorPane homePage;

    @FXML
    private Button page1Btn;

    @FXML
    private AnchorPane page2;


    @FXML
    private AnchorPane mainWindow;
    public void displayTest(){

        String text = "Hello Group 7 javaFX developers";
        printTest.setText(text);
    }

    public void navigatePage(ActionEvent event){

        if(event.getSource() == homeBtn){
            homePage.setVisible(true);
            page2.setVisible(false);
        } else if (event.getSource() == page1Btn) {
            homePage.setVisible(false);
            page2.setVisible(true);
        }
    }

    public void loadPage2() throws IOException{

        Stage stage = new Stage();


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TestUI1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 735, 469);
        stage.setTitle("Window#2");
        stage.setScene(scene);
        stage.show();

        mainWindow.getScene().getWindow().hide();



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
