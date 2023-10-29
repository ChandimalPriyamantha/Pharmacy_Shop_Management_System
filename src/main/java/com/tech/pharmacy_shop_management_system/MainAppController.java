package com.tech.pharmacy_shop_management_system;

import Email.Email;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;


public class MainAppController implements Initializable {

    @FXML
    private Button emailPage;

    @FXML
    private WebView webView;

    // FXML variables for Direct Customer Order page -- > Start

    @FXML
    private Button dcoAddButton;

    @FXML
    private AnchorPane dcoBackground;

    @FXML
    private Button dcoClearButton;

    @FXML
    private Label dcoLableChangeAmount;

    @FXML
    private Label dcoLableTotalAmount;

    @FXML
    private Button dcoManageButton;

    @FXML
    private TableView<?> dcoMedicineOrderTable;

    @FXML
    private TableView<?> dcoMedicineStockTable;

    @FXML
    private TableColumn<?, ?> dcoOrderMedID;

    @FXML
    private TableColumn<?, ?> dcoOrderMedName;

    @FXML
    private TableColumn<?, ?> dcoOrderMedPrice;

    @FXML
    private TableColumn<?, ?> dcoOrderMedQty;

    @FXML
    private Button dcoPayButton;

    @FXML
    private Button dcoRemoveButton;

    @FXML
    private TableColumn<?, ?> dcoStockMedID;

    @FXML
    private TableColumn<?, ?> dcoStockMedName;

    @FXML
    private TableColumn<?, ?> dcoStockMedPrice;

    @FXML
    private TableColumn<?, ?> dcoStockMedStock;

    @FXML
    private TextField dcoTextFieldMedID;

    @FXML
    private TextField dcoTextFieldMedName;

    @FXML
    private TextField dcoTextFieldMedPrice;

    @FXML
    private TextField dcoTextFieldMedQty;

    @FXML
    private TextField dcoTextFieldSettledAmount;

    // FXML variables for Direct Customer Order page -- > End



          // This method can help to move through the windows
          public void controlPanel(ActionEvent event){
                 if(event.getSource() == emailPage){
                    Email email = new  Email(webView);
                    email.emailServer();
                 } else if(event.getSource() == dcoManageButton){

                  dcoBackground.setVisible(true);
              }
          }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Email email = new  Email(webView);
        //email.emailServer();
    }
}


