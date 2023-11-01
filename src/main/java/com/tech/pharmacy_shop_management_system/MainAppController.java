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

    //DCO Dashboard FXML variables -->Start

    @FXML
    private Button DCOAddButton;

    @FXML
    private AnchorPane DCOBackground;

    @FXML
    private Label DCOChangeLable;

    @FXML
    private Button DCOClearButton;

    @FXML
    private Button DCOManageButton;

    @FXML
    private Button DCOPayButton;

    @FXML
    private TextField DCOPriceTextField;

    @FXML
    private TextField DCOQuantityTextField;

    @FXML
    private TextField DCOReadIDTextField;

    @FXML
    private Button DCORemoveButton;

    @FXML
    private TextField DCOSettledTextField;

    @FXML
    private TableView<?> DCOStockMedicineTable;

    @FXML
    private TableColumn<?, ?> DCOStockMedicineTableID;

    @FXML
    private TableColumn<?, ?> DCOStockMedicineTableName;

    @FXML
    private TableColumn<?, ?> DCOStockMedicineTablePrice;

    @FXML
    private TableColumn<?, ?> DCOStockMedicineTableStock;

    @FXML
    private TextField DCOTextFieldMedicineName;

    @FXML
    private Label DCOTotalLable;

    @FXML
    private TableView<?> OrderedMedicineTable;

    @FXML
    private TableColumn<?, ?> OrderedMedicineTableID;

    @FXML
    private TableColumn<?, ?> OrderedMedicineTableName;

    @FXML
    private TableColumn<?, ?> OrderedMedicineTablePrice;

    @FXML
    private TableColumn<?, ?> OrderedMedicineTableQuantity;

    ////DCO Dashboard FXML variables -->END

    @FXML
    private Button emailPage;

    @FXML
    private WebView webView;

    @FXML
    private AnchorPane RCOManagePanel;

    @FXML
    private Button RCO_BTN;

    @FXML
    private Button RCOPaymentBtn;

    @FXML
    private AnchorPane RCOPaymentPanel;

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
                 if(event.getSource() == emailPage){ // navigate into email page
                     RCOManagePanel.setVisible(false);
                     WEB_VIEW.setVisible(true);
                     RCOPaymentPanel.setVisible(false);
                     DCOBackground.setVisible(false);
                     Email email = new  Email(webView);
                     email.emailServer();
                 }else if (event.getSource() == RCO_BTN ) { // navigate into remote customer oder page
                     RCOManagePanel.setVisible(true);
                     WEB_VIEW.setVisible(false);
                     RCOPaymentPanel.setVisible(false);
                     DCOBackground.setVisible(false);
              }else if(event.getSource() ==RCOPaymentBtn){ // navigate into remote customer payment page
                     System.out.println("hi");
                     RCOManagePanel.setVisible(false);
                     WEB_VIEW.setVisible(false);
                     RCOPaymentPanel.setVisible(true);
                     DCOBackground.setVisible(false);
                 }else if(event.getSource()==DCOManageButton){ // navigate into Direct customer order page
                     DCOBackground.setVisible(true);
                     RCOPaymentPanel.setVisible(false);
                     RCOManagePanel.setVisible(false);
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

        ShowData();

    }
}


