package com.tech.pharmacy_shop_management_system;

import Email.Email;
import Purchase.PlacePurchase;
import Purchase.Purchase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("MainFrame.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1133, 650);
        stage.setTitle("Pharmacy Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

    }
}