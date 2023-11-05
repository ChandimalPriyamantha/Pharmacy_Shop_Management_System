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
    private Button Clear1;

    @FXML
    private Button add1;

    @FXML
    private Button add2;

    @FXML
    private Button clear2;

    @FXML
    private TableColumn<?, ?> companyPP;

    @FXML
    private AnchorPane completePurchase;

    @FXML
    private AnchorPane completePurchaseTbl;

    @FXML
    private TableColumn<?, ?> cpCompanyNo;

    @FXML
    private TextField cpCompanyrno;

    @FXML
    private TableColumn<?, ?> cpaddresstbl;

    @FXML
    private Button cpbtn;

    @FXML
    private TableColumn<?, ?> cpdate;

    @FXML
    private TableColumn<?, ?> cpid;

    @FXML
    private TableColumn<?, ?> cpidtbl;

    @FXML
    private TableColumn<?, ?> cpnametbl;

    @FXML
    private TableColumn<?, ?> cpqty;

    @FXML
    private TextField cpsupaddress;

    @FXML
    private TextField cpsupamount;

    @FXML
    private CheckBox cpsupcheck;

    @FXML
    private TextField cpsupcno;

    @FXML
    private TextField cpsupid;

    @FXML
    private TextField cpsupname;

    @FXML
    private Button cpsupupdate;

    @FXML
    private Button cptblbtn;

    @FXML
    private TableView<?> cptbldetails;

    @FXML
    private TableView<?> cptblsummery;

    @FXML
    private TableColumn<?, ?> datepp;

    @FXML
    private Button emailPage;

    @FXML
    private TableColumn<?, ?> idPP;

    @FXML
    private AnchorPane placePurchaseAP;

    @FXML
    private AnchorPane placePurchasetbl;

    @FXML
    private TextField ppAddress;

    @FXML
    private TextField ppCmpnyRegNo;

    @FXML
    private TextField ppContactNo;

    @FXML
    private TextField ppMedicineID;

    @FXML
    private TextField ppMedicineName;

    @FXML
    public TextField ppName;

    @FXML
    private Spinner<?> ppQty;

    @FXML
    private Button ppRemove;

    @FXML
    private TableColumn<?, ?> ppTableId;

    @FXML
    private TableView<?> ppTbl;

    @FXML
    private TableColumn<?, ?> ppTbleAddress;

    @FXML
    private Button ppbtn;

    @FXML
    public String ppsupplierID;

    @FXML
    private TableColumn<?, ?> pptblName;

    @FXML
    private Button pptblPlacePurchase;

    @FXML
    private AnchorPane purchaseAp;

    @FXML
    private TableView<?> purchaseTbl;

    @FXML
    private Button purchasebtn;

    @FXML
    private TableColumn<?, ?> qtypp;

    @FXML
    private WebView webView;

    @FXML
    private AnchorPane completePurchaseAP;

    int index = -1;


    // This method can help to move through the windows
          public void controlPanel(ActionEvent event){
                 if(event.getSource() == emailPage){
                    Email email = new  Email(webView);
                    email.emailServer();
                    emailPage.setVisible(false);
                 }else if (event.getSource()== purchasebtn) {

                     purchaseAp.setVisible(true);
                     placePurchasetbl.setVisible(true);
                     placePurchaseAP.setVisible(true);
                     completePurchaseTbl.setVisible(false);
                     completePurchaseAP.setVisible(false);
                 }
                 else if (event.getSource()== cpbtn) {

                     //purchaseAp.setVisible(true);
                     placePurchasetbl.setVisible(false);
                     placePurchaseAP.setVisible(false);
                     completePurchaseTbl.setVisible(true);
                     completePurchaseAP.setVisible(true);
                 }
                 else if (event.getSource()== ppbtn) {

                     //purchaseAp.setVisible(true);
                     placePurchasetbl.setVisible(true);
                     placePurchaseAP.setVisible(true);
                     completePurchaseTbl.setVisible(false);
                     completePurchaseAP.setVisible(false);
                 }

          }




    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }





}


