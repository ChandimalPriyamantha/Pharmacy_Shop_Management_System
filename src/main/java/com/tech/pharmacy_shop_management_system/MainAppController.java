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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.ResourceBundle;


public class MainAppController implements Initializable {

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
    private TextField RCO_ADD_ADDRESS;


    @FXML
    private Button RCO_ADD_BTN;

    @FXML
    private TextField RCO_ADD_CONTACT_NO;

    @FXML
    private TextField RCO_ADD_ID;

    @FXML
    private ImageView RCO_ADD_IMAGE;

    @FXML
    private TextField RCO_ADD_NAME;

    @FXML
    private Button RCO_M_ADD_BTN;

    @FXML
    private ImageView ROC_IMAGE_VIEW;

    @FXML
    private Label IMAGE_PATH_L;


    @FXML
    private Button RCO_PLACR_ORDER;




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

    private  Alert alert;

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
                     Email email = new  Email(webView);
                     email.emailServer();
                 }else if (event.getSource() == RCO_BTN ) { // navigate into remote customer oder page
                     RCOManagePanel.setVisible(true);
                     WEB_VIEW.setVisible(false);
                     RCOPaymentPanel.setVisible(false);
                     RCO_M_ADD_BTN.setDisable(true);
                     RCOrderID();
                     RCO_PLACR_ORDER.setDisable(true);
              }else if(event.getSource() ==RCOPaymentBtn){ // navigate into remote customer payment page
                     System.out.println("hi");
                     RCOManagePanel.setVisible(false);
                     WEB_VIEW.setVisible(false);
                     RCOPaymentPanel.setVisible(true);
                 }
          }

          // get data from rcoshippingdetail table in db.
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
    public  void ShowData(){ // DISPLAY RCO DETAILS ON THE  FXML TABLE

        ROCListData = getData();
        ROC_ID.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        ROC_NAME.setCellValueFactory(new PropertyValueFactory<>("name"));
        RCO_ADDRESS.setCellValueFactory(new PropertyValueFactory<>("address"));
        RCO_CONTACT_NO.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        TABLE_VIEW.setItems(ROCListData);
    }

    private  int RCO_ID;
    public void RCOrderID(){
        String sql = "SELECT MAX(orderID) FROM rcoshippingdetail";
        connect = DatabaseConnection.ConnectionDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if(result.next()){
                RCO_ID = result.getInt("MAX(orderID)");

            }

            if(RCO_ID == 0){
                RCO_ID += 1;
            }else {
                RCO_ID += 1;
            }
            RCO_ADD_ID.setText(String.valueOf("00000"+RCO_ID));
            RemoteCustomerOrderMedicineDetails.RCO_ID = String.valueOf(RCO_ID);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setReceipt(){

        FileChooser openFile = new FileChooser();
        openFile.getExtensionFilters().add(new FileChooser.ExtensionFilter("Open Image File", "*png","*jpg"));

        File file = openFile.showOpenDialog(RCOManagePanel.getScene().getWindow());

        if(file != null){

            RemoteCustomerOrderMedicineDetails.path = file.getAbsolutePath();
            Image image = new Image(file.toURI().toString(), 92, 78, false, true);
            ROC_IMAGE_VIEW.setImage(image);
            IMAGE_PATH_L.setText(RemoteCustomerOrderMedicineDetails.path);
        }

    }

    public void addRCOOrder(){ // to add RCO-Shipping details
            if(RCO_ADD_NAME.getText().isEmpty() ||
                    RCO_ADD_ADDRESS.getText().isEmpty() || RCO_ADD_CONTACT_NO.getText().isEmpty()|| IMAGE_PATH_L.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText("Error Alert");
                alert.setContentText("Please fill in all fields..!");
                alert.showAndWait();
            }else{
                //sendRCOShippingDetails();
                RCO_ADD_BTN.setDisable(true);
                RCO_M_ADD_BTN.setDisable(false);
                RCO_ADD_NAME.setDisable(true);
                RCO_ADD_ADDRESS.setDisable(true);
                RCO_ADD_CONTACT_NO.setDisable(true);
                RCO_ADD_ID.setDisable(true);


            }

    }

    public void  sendRCOShippingDetails(){
        RCOrderID();

        String insertDetails = "INSERT INTO rcoshippingdetail (orderID,name, address, phoneNo, dateAndTime,Image)" +
                "VALUES(?,?,?,?,?,?)";

        connect = DatabaseConnection.ConnectionDB();

        try{

            prepare = connect.prepareStatement(insertDetails);

            String path = RemoteCustomerOrderMedicineDetails.path;
            path = path.replace("\\","\\\\");
            prepare.setString(1,RemoteCustomerOrderMedicineDetails.RCO_ID);
            prepare.setString(2,RCO_ADD_NAME.getText());
            prepare.setString(3,RCO_ADD_ADDRESS.getText());
            prepare.setString(4,RCO_ADD_CONTACT_NO.getText());

            java.util.Date date = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            prepare.setString(5, String.valueOf(sqlDate));
            prepare.setString(6,path);

            prepare.executeUpdate();
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText("Successes Alert ");
            alert.setContentText("Customer is added..!");
            alert.showAndWait();


            clearRCOFields();
            RCO_ADD_ID.setText("00000"+RemoteCustomerOrderMedicineDetails.RCO_ID);



        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void clearRCOFields(){

        RCO_ADD_NAME.setText("");
        RCO_ADD_ADDRESS.setText("");
        RCO_ADD_CONTACT_NO.setText("");
        Image image = new Image("F:\\University Of Ruhuna\\lectur note\\Academic\\Level II - Semester - II\\Software Engineering\\Activities\\Project\\Pharmacy_Shop_Management_System\\src\\main\\resources\\com\\tech\\pharmacy_shop_management_system\\Icones\\icons8-receipt-100.png".toString(), 92, 78, false, true);
        ROC_IMAGE_VIEW.setImage(image);
        IMAGE_PATH_L.setText("");

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ShowData();



    }
}


