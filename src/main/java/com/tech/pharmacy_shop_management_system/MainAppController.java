package com.tech.pharmacy_shop_management_system;

import Email.Email;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MainAppController {

    @FXML
    private Button emailPage;

    @FXML
    private WebView webView;
    private WebEngine engine;

          // This method can help to move through the windows
          public void controlPanel(ActionEvent event){
                 if(event.getSource() == emailPage){
                      Email email = new Email();


                      //load the email service
//                     WebEngine webEngine = webView.getEngine();
//                     webEngine.load("https://outlook.office.com/owa/?realm=fot.ruh.ac.lk&exsvurl=1&ll-cc=1033&modurl=0&login_hint");
                 }
          }
    }


