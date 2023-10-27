package Email;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import  javafx.scene.web.WebView;

public class Email extends VBox {
    private WebView webView;
    private WebEngine webEngine;

    public Email() {
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
