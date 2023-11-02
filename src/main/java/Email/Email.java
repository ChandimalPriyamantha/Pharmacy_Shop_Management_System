package Email;

import javafx.scene.web.WebEngine;
import  javafx.scene.web.WebView;

public class Email{


    private WebView webView;
    private WebEngine engine;

    private String URL = "https://outlook.office.com/owa/?realm=fot.ruh.ac.lk&exsvurl=1&ll-cc=1033&modurl=0&login_hint";

    public Email(WebView webView) {
        this.webView = webView;
        emailServer();
    }

    public void emailServer(){

        //call the email service
        engine = webView.getEngine();
        engine.load(URL);

    }

}
