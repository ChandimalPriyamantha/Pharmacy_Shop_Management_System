package com.tech.pharmacy_shop_management_system;

import Email.Email;
import Connection.DatabaseConnection;
import RemortCustomer.RemoteCustomerOrderMedicineDetails;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;

import java.net.URL;
import java.sql.*;
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


    @FXML
    private AnchorPane DOCManagePanale;

    @FXML
    private Button RCO_BTN;

    @FXML
    private AnchorPane WEB_VIEW;


    @FXML
    private TableColumn<RemoteCustomerOrderMedicineDetails, String> RCO_ADDRESS;


    @FXML
    private TableColumn<RemoteCustomerOrderMedicineDetails, String> RCO_CONTACT_NO;

    @FXML
    private TableColumn<RemoteCustomerOrderMedicineDetails, String> RCO_ITEM;

    @FXML
    private TableColumn<RemoteCustomerOrderMedicineDetails, String> RCO_PRICE;

    @FXML
    private TableColumn<RemoteCustomerOrderMedicineDetails, String> ROC_ID;

    @FXML
    private TableView<RemoteCustomerOrderMedicineDetails> TABLE_VIEW;

    @FXML
    private TableColumn<RemoteCustomerOrderMedicineDetails, String> ROC_NAME;



    private  Connection connect;

    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;





    // This method can help to move through the windows
          public void controlPanel(ActionEvent event){
                 if(event.getSource() == emailPage){
                     DOCManagePanale.setVisible(false);
                     WEB_VIEW.setVisible(true);
                    Email email = new  Email(webView);
                    email.emailServer();
                 } else if(event.getSource() == dcoManageButton){

                  dcoBackground.setVisible(true);
                 }else if (event.getSource() == RCO_BTN ) {
                     DOCManagePanale.setVisible(true);
                     WEB_VIEW.setVisible(false);

              }
          }

    public ObservableList<RemoteCustomerOrderMedicineDetails> getData(){

        String sql = "SELECT * FROM rcoshippingdetail";


        ObservableList<RemoteCustomerOrderMedicineDetails> listData = FXCollections.observableArrayList();
        connect = DatabaseConnection.ConnectionDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            RemoteCustomerOrderMedicineDetails remoteCustomerOrderMedicineDetails;

            while (result.next()){

                remoteCustomerOrderMedicineDetails = new RemoteCustomerOrderMedicineDetails(result.getString("orderID"),

                        result.getString("name"),result.getString("address"),
                        result.getString("phoneNo"),result.getString("dateAndTime"));
                System.out.println(result.getString("name"));

                listData.add(remoteCustomerOrderMedicineDetails);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return  listData;
    }



    private ObservableList<RemoteCustomerOrderMedicineDetails> ROCListData;
    public  void ShowData(){

        ROCListData = getData();

        ROC_ID.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        ROC_NAME.setCellValueFactory(new PropertyValueFactory<>("name"));
        RCO_ADDRESS.setCellValueFactory(new PropertyValueFactory<>("address"));
        RCO_CONTACT_NO.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));




        TABLE_VIEW.setItems(ROCListData);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Email email = new  Email(webView);
        //email.emailServer();


        ShowData();


    }
}


