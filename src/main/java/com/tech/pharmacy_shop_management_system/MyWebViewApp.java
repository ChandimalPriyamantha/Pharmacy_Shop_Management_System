package com.tech.pharmacy_shop_management_system;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MyWebViewApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("OOP WebView Example");

        // Create an instance of a custom WebViewContainer class
        WebViewContainer webViewContainer = new WebViewContainer();

        // Set up the scene
        Scene scene = new Scene(webViewContainer, 800, 600);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}

class WebViewContainer extends VBox {
    private WebView webView;
    private WebEngine webEngine;

    public WebViewContainer() {
        initializeWebView();
    }

    private void initializeWebView() {
        // Create a WebView and a WebEngine
        webView = new WebView();
        webEngine = webView.getEngine();

        // Load a web page
        webEngine.load("https://www.example.com");

        // Add the WebView to the container
        getChildren().add(webView);
    }
}
