package com.tech.pharmacy_shop_management_system;

import Email.Email;
import Purchase.Purchase;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.Connection;



public class MainAppController implements Initializable {

    @FXML
    private Button emailPage;

    @FXML
    private WebView webView;

    @FXML
    private TableColumn<Purchase, String> pno;

    @FXML
    private TableColumn<Purchase, String> name;

    @FXML
    private TableColumn<Purchase, Integer> id;

    @FXML
    private TableColumn<Purchase, String> addressNo;

    @FXML
    private TableView<Purchase> purchaseTbl;

    ObservableList<Purchase> listM;

    int index = -1;


    // This method can help to move through the windows
          public void controlPanel(ActionEvent event){
                 if(event.getSource() == emailPage){
                    Email email = new  Email(webView);
                    email.emailServer();
                    emailPage.setVisible(false);
                 }
          }

          public void displayDetails(){

              id.setCellValueFactory(new PropertyValueFactory<Purchase,Integer>("id"));
              name.setCellValueFactory(new PropertyValueFactory<Purchase,String>("name"));
              pno.setCellValueFactory(new PropertyValueFactory<Purchase,String>("pno"));
              addressNo.setCellValueFactory(new PropertyValueFactory<Purchase,String>("addressNo"));

              listM = Purchase.getData();
              purchaseTbl.setItems(listM);

          }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Email email = new  Email(webView);
        email.emailServer();

        displayDetails();

    }





}


