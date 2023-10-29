package com.tech.pharmacy_shop_management_system;

import Email.Email;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;


public class MainAppController implements Initializable {

    @FXML
    private Button emailPage;

    @FXML
    private WebView webView;


          // This method can help to move through the windows
          public void controlPanel(ActionEvent event){
                 if(event.getSource() == emailPage){
                    Email email = new  Email(webView);
                    email.emailServer();
                 }
          }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Email email = new  Email(webView);
        email.emailServer();
    }
}


