package Email;


import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import  javafx.scene.web.WebView;

public class Email{

    @FXML
    private WebView webView;
    private WebEngine engine;

    public Email(WebView webView) {
        this.webView = webView;
        emailServer();
    }

    public void emailServer(){

        //call the email service
        engine = webView.getEngine();
        engine.load("https://outlook.office.com/owa/?realm=fot.ruh.ac.lk&exsvurl=1&ll-cc=1033&modurl=0&login_hint");

    }

}
