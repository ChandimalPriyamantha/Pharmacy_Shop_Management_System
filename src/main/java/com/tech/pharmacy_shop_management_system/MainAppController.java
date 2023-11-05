package com.tech.pharmacy_shop_management_system;

import Email.Email;
import Connection.DatabaseConnection;
import RemortCustomer.RemoteCustomerOrderMedicineDetails;< Lakindu-3
import SalesTransaction.MedicineData;
import SalesTransaction.Sales;
import User.Admin;
import User.Staff;
import User.UserInfo;

import RemortCustomer.RemoteCustomerOrderShippingDetails;
import SalesTransaction.Sales;

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
import medicine.Medicine;

import java.io.File;
import java.net.URL;
import java.sql.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Calendar;
import java.util.HashMap;

import java.util.ResourceBundle;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;

import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


public class MainAppController implements Initializable {

    //UserManage FXML variables  ----------------------------------------------------------->Start
    @FXML
    private Button UserManageButton;
    @FXML
    private AnchorPane UserManageBackground;
    @FXML
    private Button UserManageAdminButton;
    @FXML
    private Button UserManageStaffButton;

    public String currentID=null;

    //User Manage FXML Variables ----------------------------------------------------------->END

    //Admin Manage FXML Variables -------------------------------------------------------->Start
    @FXML
    private Button AdminManageAddButton;

    @FXML
    private AnchorPane AdminManageBackground;

    @FXML
    private Button AdminManageClearButton;

    @FXML
    private TextField AdminManageContactNo;

    @FXML
    private Button AdminManageDeleteButton;

    @FXML
    private TextField AdminManageEmail;

    @FXML
    private TextField AdminManageID;

    @FXML
    private TextField AdminManageName;

    @FXML
    private PasswordField AdminManagePassword;

    @FXML
    private TextField AdminManageSalary;

    @FXML
    private Button AdminManageSearchButton;

    @FXML
    private TableView<UserInfo> AdminManageTable;

    @FXML
    private TableColumn<UserInfo, String> AdminManageTableContactNo;

    @FXML
    private TableColumn<UserInfo,String> AdminManageTableEmail;

    @FXML
    private TableColumn<UserInfo, String> AdminManageTableID;

    @FXML
    private TableColumn<UserInfo, String> AdminManageTableName;

    @FXML
    private TableColumn<UserInfo, Double> AdminManageTableSalary;

    @FXML
    private Button AdminManageUpdateButton;
    //Admin Manage FXML Variables ----------------------------------------------------------->END


    //Staff Manage FXML Variables ----------------------------------------------------------->Start
    @FXML
    private Button StaffManageAddButton;

    @FXML
    private AnchorPane StaffManageBackground;

    @FXML
    private Button StaffManageClearButton;

    @FXML
    private TextField StaffManageContactNo;

    @FXML
    private Button StaffManageDeleteButton;

    @FXML
    private TextField StaffManageEmail;

    @FXML
    private TextField StaffManageID;

    @FXML
    private TextField StaffManageName;

    @FXML
    private PasswordField StaffManagePassword;

    @FXML
    private TextField StaffManagePosition;

    @FXML
    private TextField StaffManageSalary;

    @FXML
    private Button StaffManageSearchButton;

    @FXML
    private TableView<UserInfo> StaffManageTable;

    @FXML
    private TableColumn<Staff, String> StaffManageTableContactNo;

    @FXML
    private TableColumn<Staff, String> StaffManageTableEmail;

    @FXML
    private TableColumn<Staff, String> StaffManageTableID;

    @FXML
    private TableColumn<Staff, String> StaffManageTableName;

    @FXML
    private TableColumn<Staff, String> StaffManageTablePosition;

    @FXML
    private TableColumn<Staff, Double> StaffManageTableSalary;

    @FXML
    private Button StaffManageUpdateButton;
    //Staff Manage FXML Variables ------------------------------------------------------------>END


    //DCO Dashboard FXML variables --------------------------------------------------------->Start

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
    private  TextField DCOQuantityTextField;
    @FXML
    private  TextField DCOReadIDTextField;
    @FXML
    private  TextField DCOTextFieldMedicineName;

    @FXML
    private Button DCORemoveButton;

    @FXML
    private TextField DCOSettledTextField;

    @FXML
    private TableView<MedicineData> DCOStockMedicineTable;

    @FXML
    private TableColumn<MedicineData, String> DCOStockMedicineTableID;

    @FXML
    private TableColumn<MedicineData, String> DCOStockMedicineTableName;

    @FXML
    private TableColumn<MedicineData, Double> DCOStockMedicineTablePrice;

    @FXML
    private TableColumn<MedicineData, Integer> DCOStockMedicineTableStock;

    @FXML
    private Label DCOTotalLable;

    @FXML
    private TableView<MedicineData> OrderedMedicineTable;

    @FXML
    private TableColumn<MedicineData, String> OrderedMedicineTableID;

    @FXML
    private TableColumn<MedicineData, String> OrderedMedicineTableName;

    @FXML
    private TableColumn<MedicineData, Double> OrderedMedicineTablePrice;

    @FXML
    private TableColumn<MedicineData, Integer> OrderedMedicineTableQuantity;

    ////DCO Dashboard FXML variables -------------------------------------------------------------------------------------->END

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
    private TextField RCO_M_ID;

    @FXML
    private TextField RCO_M_NAME;

    @FXML
    private TextField RCO_M_PRICE;

    @FXML
    private Spinner<Integer> RCO_M_QUANTITY;


    @FXML
    private Button RCO_CLEAR_BTN;

    @FXML
    private Label RCO_TOTAL;

    @FXML
    private TextField PM_ADDRESS;

    @FXML
    private TextField PM_ADD_ID;

    @FXML
    private Button PM_CLEAR_BTN;

    @FXML
    private TextField PM_CONTACT_NO;

    @FXML
    private Button PM_DELETE_BTN;

    @FXML
    private ImageView PM_IMAGE_VIEW;

    @FXML
    private TextField PM_NAME;


    @FXML
    private Label PM_TOTAL;

    @FXML
    private CheckBox PM_CHECK_BOX;


    @FXML
    private Button PM_PYAMENT_BTN;

    @FXML
    private Label PM_QUANTITY;



   // RCO CUSTOMER DETAILS TABLE
    @FXML
    private TableColumn<RemoteCustomerOrderMedicineDetails, String> RCO_ADDRESS;


    @FXML
    private TableColumn<RemoteCustomerOrderMedicineDetails, String> RCO_CONTACT_NO;

    @FXML
    private TableColumn<RemoteCustomerOrderMedicineDetails, String> RCO_DATE;


    @FXML
    private TableColumn<RemoteCustomerOrderMedicineDetails,Double> RCO_PRICE;

    @FXML
    private TableColumn<RemoteCustomerOrderMedicineDetails, String> ROC_ID;

    @FXML
    private TableView<RemoteCustomerOrderMedicineDetails> TABLE_VIEW;

    @FXML
    private TableColumn<RemoteCustomerOrderMedicineDetails, String> ROC_NAME;

   // MEDICINE DETAILS TABLE PROPERTIES
    @FXML
    private TableColumn<RemoteCustomerOrderShippingDetails, String> RCO_MT_ID;

    @FXML
    private TableColumn<RemoteCustomerOrderShippingDetails, String> RCO_MT_NAME;

    @FXML
    private TableColumn<RemoteCustomerOrderShippingDetails, Double> RCO_MT_PRICE;

    @FXML
    private TableColumn<RemoteCustomerOrderShippingDetails, Integer> RCO_MT_QUANTITY;

    @FXML
    private TableView<RemoteCustomerOrderShippingDetails> TABLE_MT_VIEW;

    @FXML
    private TableColumn<RemoteCustomerOrderMedicineDetails, String> TABLE_P_ADRESS;

    @FXML
    private TableColumn<RemoteCustomerOrderMedicineDetails, String> TABLE_P_CONTACT;

    @FXML
    private TableColumn<RemoteCustomerOrderMedicineDetails, String> TABLE_P_DATE;

    @FXML
    private TableColumn<RemoteCustomerOrderMedicineDetails, String> TABLE_P_ID;

    @FXML
    private TableColumn<RemoteCustomerOrderMedicineDetails, String> TABLE_P_NAME;

    @FXML
    private TableColumn<RemoteCustomerOrderMedicineDetails, Double> TABLE_P_PRICE;

    @FXML
    private TableView<RemoteCustomerOrderMedicineDetails> TABLE_P_VIEW;


    @FXML
    private TableColumn<RemoteCustomerOrderShippingDetails, String> PM_TABLE_ID;

    @FXML
    private TableColumn<RemoteCustomerOrderShippingDetails, String> PM_TABLE_NAME;

    @FXML
    private TableColumn<RemoteCustomerOrderShippingDetails, String> PM_TABLE_PRICE;

    @FXML
    private TableColumn<RemoteCustomerOrderShippingDetails, Integer> PM_TABLE_QUANTITY;

    @FXML
    private TableView<RemoteCustomerOrderShippingDetails> PM_TABLE_VIEW;



    private  Alert alert;

    private  Connection connect;

    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    private SpinnerValueFactory<Integer> spin;


    // This method can help to move through the windows
          public void controlPanel(ActionEvent event){
                 if(event.getSource() == emailPage){ // navigate into email page
                     RCOManagePanel.setVisible(false);
                     WEB_VIEW.setVisible(true);
                     RCOPaymentPanel.setVisible(false);
                     DCOBackground.setVisible(false);
                     UserManageBackground.setVisible(false);
                     Email email = new  Email(webView);
                     email.emailServer();
                 }else if (event.getSource() == RCO_BTN ) { // navigate into remote customer oder page
                     RCOManagePanel.setVisible(true);
                     WEB_VIEW.setVisible(false);
                     RCOPaymentPanel.setVisible(false);

                     ShowData();
                     RCOrderID();



                     DCOBackground.setVisible(false);
                     UserManageBackground.setVisible(false);

              }else if(event.getSource() ==RCOPaymentBtn){ // navigate into remote customer payment page
                    // System.out.println("hi");
                     RCOManagePanel.setVisible(false);
                     WEB_VIEW.setVisible(false);
                     RCOPaymentPanel.setVisible(true);

                     PM_PYAMENT_BTN.setDisable(true);
                     ShowPData();

                     DCOBackground.setVisible(false);
                     UserManageBackground.setVisible(false);
                 }else if(event.getSource()==DCOManageButton){ // navigate into Direct customer order page
                     getMedicine();    //Load stock medicine


                     DCOBackground.setVisible(true);
                     RCOPaymentPanel.setVisible(false);
                     RCOManagePanel.setVisible(false);
                     WEB_VIEW.setVisible(false);
                     UserManageBackground.setVisible(false);
                     DCOReadIDTextField.requestFocus();
                 }else if(event.getSource()==UserManageButton){ // navigate into User Manage page
                     getStaff();

                     DCOBackground.setVisible(false);
                     RCOPaymentPanel.setVisible(false);
                     RCOManagePanel.setVisible(false);
                     WEB_VIEW.setVisible(false);
                     UserManageBackground.setVisible(true);
                     StaffManageBackground.setVisible(true);
                     AdminManageBackground.setVisible(false);
                 }else if(event.getSource()==UserManageStaffButton){ // navigate into Staff Manage page
                     getStaff();

                     DCOBackground.setVisible(false);
                     RCOPaymentPanel.setVisible(false);
                     RCOManagePanel.setVisible(false);
                     WEB_VIEW.setVisible(false);
                     UserManageBackground.setVisible(true);
                     StaffManageBackground.setVisible(true);
                     AdminManageBackground.setVisible(false);
                 }else if(event.getSource()==UserManageAdminButton){ // navigate into Admin Manage page
                     getAdmin();

                     DCOBackground.setVisible(false);
                     RCOPaymentPanel.setVisible(false);
                     RCOManagePanel.setVisible(false);
                     WEB_VIEW.setVisible(false);
                     UserManageBackground.setVisible(true);
                     StaffManageBackground.setVisible(false);
                     AdminManageBackground.setVisible(true);

                 }else if(event.getSource()==DCOClearButton){ // Functionality to clear DCO
                     clearData();

                 }else if(event.getSource()==AdminManageAddButton){ // Functionality to Add ADMIN User
                     new Admin().addUser(AdminManageID.getText(),
                             AdminManageName.getText(),
                             AdminManageContactNo.getText(),
                             AdminManagePassword.getText(),
                             AdminManageSalary.getText(),
                             AdminManageEmail.getText());
                     getAdmin();
                     clearUserData();

                 }else if(event.getSource()==StaffManageAddButton){ // Functionality to Add Staff User
                     new Staff().addUser(StaffManageID.getText(),
                             StaffManageName.getText(),
                             StaffManageContactNo.getText(),
                             StaffManagePassword.getText(),
                             StaffManageSalary.getText(),
                             StaffManageEmail.getText(),
                             StaffManagePosition.getText());
                     getStaff();
                     clearUserData();

                 }else if(event.getSource()==AdminManageUpdateButton){ // Functionality to Update Admin User
                     new Admin().editUser(AdminManageName.getText(),
                             AdminManageContactNo.getText(),
                             AdminManagePassword.getText(),
                             AdminManageSalary.getText(),
                             AdminManageEmail.getText(),
                             currentID);
                     getAdmin();
                     clearUserData();

                 }else if(event.getSource()==StaffManageUpdateButton){ // Functionality to Update Staff User
                     new Staff().editUser(StaffManageName.getText(),
                             StaffManageContactNo.getText(),
                             StaffManagePassword.getText(),
                             StaffManageSalary.getText(),
                             StaffManageEmail.getText(),
                             StaffManagePosition.getText(),
                             currentID);
                     getStaff();
                     clearUserData();

                 }else if(event.getSource()==AdminManageDeleteButton){ // Functionality to delete Admin User
                     new Admin().deleteUser(currentID);
                     getAdmin();
                     clearUserData();

                 }else if(event.getSource()==StaffManageDeleteButton){ // Functionality to delete Staff User
                     new Staff().deleteUser(currentID);
                     getStaff();
                     clearUserData();

                 }else if(event.getSource()==AdminManageSearchButton){ // Functionality to Search ADMIN User
                     searchAdmin(AdminManageID.getText());
                     clearUserData();

                 }else if(event.getSource()==StaffManageSearchButton){ // Functionality to Search Staff User
                     searchStaff(StaffManageID.getText());
                     clearUserData();

                 }else if(event.getSource()==AdminManageClearButton||event.getSource()==StaffManageClearButton){ // Functionality to Clear User manage Text fields
                     clearUserData();
                     getAdmin();
                     getStaff();

                 }

          }

          // get data from rcoshippingdetail table in db.
    public ObservableList<RemoteCustomerOrderMedicineDetails> getData(){

        String sql = "SELECT rcoshippingdetail.orderID, rcoshippingdetail.name, " +
                "rcoshippingdetail.address,rcoshippingdetail.phoneNo,rcoshippingdetail.dateAndTime, " +
                "SUM(rcomedicinedetail.price) as price FROM rcoshippingdetail INNER JOIN rcomedicinedetail " +
                "ON rcoshippingdetail.orderID = rcomedicinedetail.RCOID GROUP BY rcoshippingdetail.orderID";


        ObservableList<RemoteCustomerOrderMedicineDetails> listData = FXCollections.observableArrayList();
        connect = DatabaseConnection.ConnectionDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            RemoteCustomerOrderMedicineDetails remoteCustomerOrderMedicineDetails;

            while (result.next()){

                remoteCustomerOrderMedicineDetails = new RemoteCustomerOrderMedicineDetails(result.getString("orderID"),

                        result.getString("name"),result.getString("address"),
                        result.getString("phoneNo"),result.getString("dateAndTime"),
                        result.getDouble("price"));




                listData.add(remoteCustomerOrderMedicineDetails);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return  listData;
    }

    public ObservableList<RemoteCustomerOrderShippingDetails> getMedicineData(){

        String sql = "SELECT * FROM rcomedicinedetail WHERE RCOID = '"+RCO_ADD_ID.getText()+"'";


        ObservableList<RemoteCustomerOrderShippingDetails> listData = FXCollections.observableArrayList();
        connect = DatabaseConnection.ConnectionDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            RemoteCustomerOrderShippingDetails remoteCustomerOrderShippingDetails;

            while (result.next()){

                remoteCustomerOrderShippingDetails  = new RemoteCustomerOrderShippingDetails(result.getString("RCOID"),

                        result.getString("medicineID"),result.getString("quantity"),
                        result.getString("medicineName"),result.getDouble("price"));




                listData.add(remoteCustomerOrderShippingDetails);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return  listData;
    }


    public ObservableList<RemoteCustomerOrderShippingDetails> getMedicineDataToPayment(){

        String sql = "SELECT * FROM rcomedicinedetail WHERE RCOID = '"+PM_ADD_ID.getText()+"'";


        ObservableList<RemoteCustomerOrderShippingDetails> listData = FXCollections.observableArrayList();
        connect = DatabaseConnection.ConnectionDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            RemoteCustomerOrderShippingDetails remoteCustomerOrderShippingDetails;

            while (result.next()){

                remoteCustomerOrderShippingDetails  = new RemoteCustomerOrderShippingDetails(result.getString("RCOID"),

                        result.getString("medicineID"),result.getString("quantity"),
                        result.getString("medicineName"),result.getDouble("price"));
                System.out.println(result.getString("price"));




                listData.add(remoteCustomerOrderShippingDetails);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return  listData;
    }
    public  void setQuaitynt() {

        spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        RCO_M_QUANTITY.setValueFactory(spin);

    }

    private double totalPayment;
    public void menuGetTotal(){

        String total = "SELECT SUM(price) FROM rcomedicinedetail WHERE RCOID =" + RCO_ADD_ID.getText();

        connect = DatabaseConnection.ConnectionDB();

        try {
            prepare = connect.prepareStatement(total);
            result = prepare.executeQuery();

            if(result.next()){
                totalPayment = result.getDouble("SUM(price)");
                RCO_TOTAL.setText(String.valueOf(totalPayment));
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void checkBOX(ActionEvent event){

        if(PM_CHECK_BOX.isSelected()){
            PM_PYAMENT_BTN.setDisable(false);
        }else {
            PM_PYAMENT_BTN.setDisable(true);
        }

    }

    private double totalPaymentToPay;
    private int quantity;
    public void menuGetTotalToPayment(){

        if(PM_ADD_ID.getText().isEmpty()){

            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Message");
            alert.setHeaderText("Warning Alert");
            alert.setContentText("Input is not Valid!");
            alert.showAndWait();

        }else{

            String total = "SELECT SUM(price),SUM(quantity) FROM rcomedicinedetail WHERE RCOID =" + PM_ADD_ID.getText();

            connect = DatabaseConnection.ConnectionDB();

            try {
                prepare = connect.prepareStatement(total);
                result = prepare.executeQuery();

                if(result.next()){
                    totalPaymentToPay = result.getDouble("SUM(price)");
                    quantity = result.getInt("SUM(quantity)");
                    PM_TOTAL.setText(String.valueOf(totalPaymentToPay));
                    PM_QUANTITY.setText(String.valueOf(quantity));
                }



            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }



    }

    private ObservableList<RemoteCustomerOrderMedicineDetails> ROCListData;
    public  void ShowData(){ // DISPLAY RCO DETAILS ON THE  FXML TABLE

        ROCListData = getData();
        ROC_ID.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        ROC_NAME.setCellValueFactory(new PropertyValueFactory<>("name"));
        RCO_ADDRESS.setCellValueFactory(new PropertyValueFactory<>("address"));
        RCO_CONTACT_NO.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        RCO_DATE.setCellValueFactory(new PropertyValueFactory<>("DateTime"));
        RCO_PRICE.setCellValueFactory(new PropertyValueFactory<>("price"));

        TABLE_VIEW.setItems(ROCListData);
    }

    private ObservableList<RemoteCustomerOrderMedicineDetails> PListData;
    public  void ShowPData(){ // DISPLAY RCO DETAILS ON THE  FXML TABLE

        PListData = getData();
        TABLE_P_ID.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        TABLE_P_NAME.setCellValueFactory(new PropertyValueFactory<>("name"));
        TABLE_P_ADRESS.setCellValueFactory(new PropertyValueFactory<>("address"));
        TABLE_P_CONTACT.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        TABLE_P_DATE.setCellValueFactory(new PropertyValueFactory<>("DateTime"));
        TABLE_P_PRICE.setCellValueFactory(new PropertyValueFactory<>("price"));

        TABLE_P_VIEW.setItems(PListData);
    }

    private ObservableList<RemoteCustomerOrderShippingDetails> ROCMListData;
    public  void ShowMedicineData(){ // DISPLAY RCO DETAILS ON THE  FXML TABLE

        ROCMListData = getMedicineData();
        RCO_MT_ID.setCellValueFactory(new PropertyValueFactory<>("medicineID"));
        RCO_MT_NAME.setCellValueFactory(new PropertyValueFactory<>("medicineName"));
        RCO_MT_QUANTITY.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        RCO_MT_PRICE.setCellValueFactory(new PropertyValueFactory<>("price"));



        TABLE_MT_VIEW.setItems( ROCMListData);
    }

    private ObservableList<RemoteCustomerOrderShippingDetails> ROCMPListData;
    public  void ShowMedicinePaymentData(){ // DISPLAY RCO DETAILS ON THE  FXML TABLE

        ROCMPListData = getMedicineDataToPayment();
        PM_TABLE_ID.setCellValueFactory(new PropertyValueFactory<>("medicineID"));
        PM_TABLE_NAME.setCellValueFactory(new PropertyValueFactory<>("medicineName"));
        PM_TABLE_QUANTITY.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        PM_TABLE_PRICE.setCellValueFactory(new PropertyValueFactory<>("price"));



        PM_TABLE_VIEW.setItems(ROCMPListData);
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
                //System.out.println(result.getInt("MAX(serialID)"));

            }

//            String checkCID = "SELECT MAX(RCOID) FROM rcomedicinedetail";
//            prepare = connect.prepareStatement(checkCID);
//            result = prepare.executeQuery();
//            int checkID =0;
//            if(result.next()){
//                checkID = result.getInt("MAX(RCOID)");
//            }
            if(RCO_ID == 0){
                RCO_ID += 1;
            }else{
                RCO_ID += 1;
            }
            RCO_ADD_ID.setText(String.valueOf(RCO_ID));
            RemoteCustomerOrderMedicineDetails.RCO_ID = String.valueOf(RCO_ID);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private  int SalesID;
    public void salesID(){
        String sql = "SELECT MAX(salesID) FROM sales";
        connect = DatabaseConnection.ConnectionDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if(result.next()){
                SalesID = result.getInt("MAX(salesID)");
                //System.out.println(result.getInt("MAX(serialID)"));

            }


            if(SalesID == 0){
                SalesID += 1;
            }else{
                SalesID+= 1;
            }

            Sales.salesID = SalesID;



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
                ROC_IMAGE_VIEW.setDisable(true);
                //RCO_CLEAR_BTN.setDisable(true);

            }

    }

    public void  getMedicine(){

        String sql = "SELECT * FROM medicine WHERE medicineID = '"+RCO_M_ID.getText()+"'";

        connect = DatabaseConnection.ConnectionDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){

                RCO_M_NAME.setText(result.getString("name"));
                RCO_M_PRICE.setText(result.getString("price"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void  getShippingDetails(){


        String sql = "SELECT * FROM rcoshippingdetail WHERE orderID = '"+PM_ADD_ID.getText()+"'";


        connect = DatabaseConnection.ConnectionDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()){

                PM_NAME.setText(result.getString("name"));
                PM_ADDRESS.setText(result.getString("address"));
                PM_CONTACT_NO.setText(result.getString("phoneNo"));
                Image image = new Image(result.getString("Image").toString(), 105, 71, false, true);
                PM_IMAGE_VIEW.setImage(image);


            }

            ShowMedicinePaymentData();
            menuGetTotalToPayment();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void getInvoice(){

        if(totalPayment == 0){
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Order first.");
            alert.showAndWait();
        }else {

            HashMap map = new HashMap();
            map.put("getReceipt", RCO_ADD_ID.getText());
            map.put("getTotal", RCO_TOTAL.getText());

            try {
                JasperDesign jasperDesign = JRXmlLoader.load("F:\\University Of Ruhuna\\lectur note\\Academic\\Level II - Semester - II\\Software Engineering\\Activities\\Project\\Pharmacy_Shop_Management_System\\Reports\\Invoice.jrxml");
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, connect);

                JasperViewer.viewReport(jasperPrint, false);
                //JasperPrintManager.printReport(jasperPrint, true);

            } catch (JRException e) {
                throw new RuntimeException(e);
            }


        }

    }




    int qty;
    public  void addBtn(){

        qty = RCO_M_QUANTITY.getValue();

        String check = "";
        String checkAvailable = "SELECT status FROM medicine WHERE medicineID = '"+
                RCO_M_ID.getText()+"'";
        connect = DatabaseConnection.ConnectionDB();

        try {

            int checkStockNumber = 0;
            String checkStock = "SELECT quantity FROM medicine WHERE medicineID= '"+RCO_M_ID.getText()+"'";

            prepare = connect.prepareStatement(checkStock);
            result = prepare.executeQuery();

            if(result.next()){
                checkStockNumber = result.getInt("quantity");
            }

            if(checkStockNumber == 0){

                String updateStock = "UPDATE medicine SET status='Unavailable' WHERE medicineID = '"+RCO_M_ID.getText()+"' ";

                prepare = connect.prepareStatement(updateStock);
                prepare.executeUpdate();
            }

            prepare = connect.prepareStatement(checkAvailable);
            result = prepare.executeQuery();

            if(result.next()){
                check = result.getString("status");
                System.out.println(check);
            }
            if(!check.equals("Available") || qty == 0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText("Error Alert!");
                alert.setContentText("Something Wrong!");
                alert.showAndWait();
            }else{


                if( checkStockNumber < qty){

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Out of stock!");
                    alert.showAndWait();

                }else {

                       // prod_image = prod_image.replace("\\", "\\\\");

                        String insertData = "INSERT INTO rcomedicinedetail " +
                                "(RCOID,medicineID,quantity,medicineName,price)" +
                                "VALUES(?,?,?,?,?)";

                        prepare = connect.prepareStatement(insertData);
                        prepare.setString(1, RCO_ADD_ID.getText());
                        prepare.setString(2, RCO_M_ID.getText());
                        prepare.setInt(3,RCO_M_QUANTITY.getValue());
                        prepare.setString(4, RCO_M_NAME.getText());

                        double price = Double.parseDouble(RCO_M_PRICE.getText());
                        double totalP = (qty * price );

                        prepare.setDouble(5, totalP);

                        prepare.executeUpdate();

                        int upStock = checkStockNumber - qty;

//                   String updateStock = "UPDATE product SET prod_name = '"
//                           +card_product_name.getText()+"', type= '"
//                           + type +"',stock= " +upStock+",price = " + pr
//                           +",status='"
//                           + check+"', image='"
//                           + prod_image+"',date='"+prod_date+"' WHERE prod_id = '"+prodID+"' ";

                        String updateStock = "UPDATE medicine SET quantity= '" + upStock + "' WHERE medicineID = '" +RCO_M_ID.getText()+ "' ";

                        prepare = connect.prepareStatement(updateStock);
                        prepare.executeUpdate();


                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText("Success Alert!");
                        alert.setContentText("Successfully Added!");
                        alert.showAndWait();

                        RCO_CLEAR_BTN.setDisable(true);

                        clearRCOMFields();
                        menuGetTotal();
                        ShowMedicineData();

                    }
                }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        if(qty == 0){
//
//        }
    }

    public void placeOrder(){

        sendRCOShippingDetails();
        RCO_ADD_BTN.setDisable(false);
        RCO_CLEAR_BTN.setDisable(false);
        RCO_M_ADD_BTN.setDisable(true);
        RCO_PLACR_ORDER.setDisable(true);
        RCO_CLEAR_BTN.setDisable(false);
        getInvoice();
        RCOrderID();
        ShowData();
        ShowMedicineData();
        RCO_TOTAL.setText("0.00");


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
            prepare.setString(1,RCO_ADD_ID.getText());
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
            alert.setContentText("Order is Successfully Place!");
            alert.showAndWait();


            clearRCOFields();
            RCO_ADD_ID.setText(RemoteCustomerOrderMedicineDetails.RCO_ID);



        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void clearRCOMFields(){

        RCO_M_ID.setText("");
        RCO_M_NAME.setText("");
        RCO_M_PRICE.setText("");
        setQuaitynt();
        RCO_PLACR_ORDER.setDisable(false);
    }

    public void clearRCOFields(){

        RCO_ADD_NAME.setText("");
        RCO_ADD_ADDRESS.setText("");
        RCO_ADD_CONTACT_NO.setText("");
        Image image = new Image("F:\\University Of Ruhuna\\lectur note\\Academic\\Level II - Semester - II\\Software Engineering\\Activities\\Project\\Pharmacy_Shop_Management_System\\src\\main\\resources\\com\\tech\\pharmacy_shop_management_system\\Icones\\icons8-receipt-100.png".toString(), 92, 78, false, true);
        ROC_IMAGE_VIEW.setImage(image);
        IMAGE_PATH_L.setText("");

        RCO_ADD_BTN.setDisable(false);
        RCO_M_ADD_BTN.setDisable(true);
        RCO_ADD_NAME.setDisable(false);
        RCO_ADD_ADDRESS.setDisable(false);
        RCO_ADD_CONTACT_NO.setDisable(false);
        RCO_ADD_ID.setDisable(false);
        ROC_IMAGE_VIEW.setDisable(false);

    }


    public  void updateSales(){

        salesID();
        String insertDetails = "INSERT INTO sales (salesID,name, type, quantity, dateandTime,amount)" +
                "VALUES(?,?,?,?,?,?)";

        connect = DatabaseConnection.ConnectionDB();

        try{

            prepare = connect.prepareStatement(insertDetails);


            prepare.setInt(1,Sales.salesID);
            prepare.setString(2,PM_NAME.getText());
            prepare.setString(3,"RCO");
            prepare.setInt(4, Integer.parseInt(PM_QUANTITY.getText()));

            java.util.Date date = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            prepare.setString(5, String.valueOf(sqlDate));
            prepare.setString(6,PM_TOTAL.getText());

            prepare.executeUpdate();

            String deleteData = "DELETE FROM rcoshippingdetail WHERE orderID = " + PM_ADD_ID.getText();
            prepare = connect.prepareStatement(deleteData);
            prepare.executeUpdate();

            String deleteMData = "DELETE FROM rcomedicinedetail WHERE RCOID = " + PM_ADD_ID.getText();
            prepare = connect.prepareStatement(deleteMData);
            prepare.executeUpdate();



            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText("Successes Alert ");
            alert.setContentText("Payment is successfully settled!");
            alert.showAndWait();
            clearMP();






        }catch (Exception e){
            e.printStackTrace();
        }



    }

    public void clearMP(){

        PM_ADD_ID.setText("");
        PM_NAME.setText("");
        PM_ADDRESS.setText("");
        PM_CONTACT_NO.setText("");
        PM_IMAGE_VIEW.setImage(null);
        PM_TOTAL.setText("");
        PM_QUANTITY.setText("");
        ShowPData();
        getShippingDetails();

    }

    //Method to load DCO stock medicine details to table ------------------------------------------------------>start
    private ObservableList<MedicineData> DCOListMedicine;
    public void getMedicine(){
        DCOListMedicine= new Sales().loadMedicine();

        DCOStockMedicineTableID.setCellValueFactory((new PropertyValueFactory<>("medicineID")));
        DCOStockMedicineTableName.setCellValueFactory((new PropertyValueFactory<>("name")));
        DCOStockMedicineTableStock.setCellValueFactory((new PropertyValueFactory<>("quantity")));
        DCOStockMedicineTablePrice.setCellValueFactory((new PropertyValueFactory<>("price")));

        DCOStockMedicineTable.setItems(DCOListMedicine);
    }
    //Method to load DCO stock medicine details to table ----------------------------------------------------------->End





    //Method to load Admin List to table ------------------------------------------------------------------------->start
    private ObservableList<UserInfo> userList;
    public void getAdmin(){
        userList= new UserInfo().loadUser();

        AdminManageTableID.setCellValueFactory((new PropertyValueFactory<>("id")));
        AdminManageTableName.setCellValueFactory((new PropertyValueFactory<>("name")));
        AdminManageTableEmail.setCellValueFactory((new PropertyValueFactory<>("email")));
        AdminManageTableContactNo.setCellValueFactory((new PropertyValueFactory<>("contactNo")));
        AdminManageTableSalary.setCellValueFactory((new PropertyValueFactory<>("salary")));


        AdminManageTable.setItems(userList);
    }

    //Method to load Admin List to table ------------------------------------------------------------------------->End





    //Method to load search Admin List to table ------------------------------------------------------------------------->start
    private ObservableList<UserInfo> serchAdminList;
    public void searchAdmin(String id){
        Alert alert;
        if((AdminManageID.getText()).isEmpty()){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Fill an Admin ID");
            alert.setContentText(null);
            alert.showAndWait();
            return;
        }
        AdminManageTable.getItems().clear();
        serchAdminList= new UserInfo().searchUser(id);

        AdminManageTableID.setCellValueFactory((new PropertyValueFactory<>("id")));
        AdminManageTableName.setCellValueFactory((new PropertyValueFactory<>("name")));
        AdminManageTableEmail.setCellValueFactory((new PropertyValueFactory<>("email")));
        AdminManageTableContactNo.setCellValueFactory((new PropertyValueFactory<>("contactNo")));
        AdminManageTableSalary.setCellValueFactory((new PropertyValueFactory<>("salary")));


        AdminManageTable.setItems(serchAdminList);
    }

    //Method to load Search Admin List to table ------------------------------------------------------------------------->End



    //Method to load search Admin List to table ------------------------------------------------------------------------->start
    private ObservableList<UserInfo> searchStaffList;
    public void searchStaff(String id){
        Alert alert;
        if((StaffManageID.getText()).isEmpty()){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Fill an Staff ID");
            alert.setContentText(null);
            alert.showAndWait();
            return;
        }
        StaffManageTable.getItems().clear();
        searchStaffList= new Staff().searchUser(id);

        StaffManageTableID.setCellValueFactory((new PropertyValueFactory<>("id")));
        StaffManageTableName.setCellValueFactory((new PropertyValueFactory<>("name")));
        StaffManageTableEmail.setCellValueFactory((new PropertyValueFactory<>("email")));
        StaffManageTableContactNo.setCellValueFactory((new PropertyValueFactory<>("contactNo")));
        StaffManageTableSalary.setCellValueFactory((new PropertyValueFactory<>("salary")));
        StaffManageTablePosition.setCellValueFactory((new PropertyValueFactory<>("position")));

        StaffManageTable.setItems(searchStaffList);
    }

    //Method to load Search Admin List to table ------------------------------------------------------------------------->End






    //Method to load Staff List to table ------------------------------------------------------------------------->start
    private ObservableList<UserInfo> staffList;
    public void getStaff(){
        staffList= new Staff().loadUser();

        StaffManageTableID.setCellValueFactory((new PropertyValueFactory<>("id")));
        StaffManageTableName.setCellValueFactory((new PropertyValueFactory<>("name")));
        StaffManageTableEmail.setCellValueFactory((new PropertyValueFactory<>("email")));
        StaffManageTableContactNo.setCellValueFactory((new PropertyValueFactory<>("contactNo")));
        StaffManageTableSalary.setCellValueFactory((new PropertyValueFactory<>("salary")));
        StaffManageTablePosition.setCellValueFactory((new PropertyValueFactory<>("position")));

        StaffManageTable.setItems(staffList);
    }


    //Method to load Staff List to table ------------------------------------------------------------------------->End










    //Method to autoload text fields in DCO add medicine to order--------------------------------------------------->Start
    public void fillDCOTextFields(){
        String id=DCOReadIDTextField.getText();
         String query="select medicineID,name,quantity,price from medicine where medicineID=?";
         connect=DatabaseConnection.ConnectionDB();

        try {
            prepare = connect.prepareStatement(query);
            prepare.setString(1,id);
            result = prepare.executeQuery();
            if (result==null){
                DCOTextFieldMedicineName.setText(null);
                DCOPriceTextField.setText("0.0");
                DCOQuantityTextField.setText("0");

            }
            else{
                result.next();
                DCOTextFieldMedicineName.setText(result.getString("name"));
                DCOPriceTextField.setText(String.valueOf(result.getDouble("price")));
                DCOQuantityTextField.setText("0");
                DCOQuantityTextField.requestFocus();
            }
        } catch (SQLException e) {
            DCOTextFieldMedicineName.setText("");
            DCOPriceTextField.setText("");
            DCOQuantityTextField.setText("");
            //System.out.println("Error in: "+e.getMessage());
        }
    }
    //Method to autoload text fields in DCO add medicine to order--------------------------------------------------------->End





    //Method to show added medicine on table in DCO add medicine to order---------------------------------------------->Start
    private ObservableList<MedicineData> orderedMedicineList;
    public void loadOrderMedicine(){
        Alert alert;
        if((DCOReadIDTextField.getText()).isEmpty()||(DCOTextFieldMedicineName.getText()).isEmpty()||(DCOPriceTextField.getText()).isEmpty()||(DCOQuantityTextField.getText()).isEmpty()){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText("Some fields are empty");
            alert.setContentText("Please fill them");
            alert.showAndWait(); // prompt error message to indicate  text field is empty.....
            return;
        }



        int j=OrderedMedicineTable.getItems().size();
        int i;
        for(i=0;i<j;i++){
            if((OrderedMedicineTableID.getCellData(i)).equals(DCOReadIDTextField.getText())){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText("Medicine is already added to the order");
                alert.setContentText(null);
                alert.showAndWait(); // prompt error message to indicate quantity text field is 0.....
                return;
            }
        }


        if(Integer.valueOf(DCOQuantityTextField.getText())==0){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText("Invalid quantity");
            alert.setContentText("Quantity is 0... please add a quantity");
            alert.showAndWait(); // prompt error message to indicate quantity text field is 0.....
            return;
        }

            int updateQty = Sales.changeQuantity(DCOReadIDTextField.getText(),Integer.valueOf(DCOQuantityTextField.getText()));
            if(updateQty!=-1){
                alert = new Alert(Alert.AlertType.ERROR);       //error message to indicate medicine is out of stocked
                alert.setTitle("Error Message");
                alert.setHeaderText("Out of Stock");
                alert.setContentText("There is only "+updateQty+" stocks available in this medicine");
                alert.showAndWait();
                return;

            }
                orderedMedicineList=Sales.addSale(DCOReadIDTextField.getText(),DCOTextFieldMedicineName.getText(),DCOQuantityTextField.getText(),DCOPriceTextField.getText());

                OrderedMedicineTableID.setCellValueFactory((new PropertyValueFactory<>("medicineID")));
                OrderedMedicineTableName.setCellValueFactory((new PropertyValueFactory<>("name")));
                OrderedMedicineTableQuantity.setCellValueFactory((new PropertyValueFactory<>("quantity")));
                OrderedMedicineTablePrice.setCellValueFactory((new PropertyValueFactory<>("price")));
                OrderedMedicineTable.setItems(orderedMedicineList);
                clearData();
                getMedicine();
                calculateTotal();
                DCOReadIDTextField.requestFocus();

    }
    //Method to show added medicine on table in DCO add medicine to order---------------------------------------------->End






    //Method to clear button in DCO to order-------------------------------------------------------------------------->Start
    public void clearData(){
        DCOReadIDTextField.setText(null);
        DCOTextFieldMedicineName.setText(null);
        DCOQuantityTextField.setText(null);
        DCOPriceTextField.setText(null);
    }
    //Method to clear button in DCO to order-------------------------------------------------------------------------->End







    //Method to clear button in DCO to order-------------------------------------------------------------------------->Start
    public void clearUserData(){
        AdminManageID.setText("");
        AdminManageName.setText("");
        AdminManageContactNo.setText("");
        AdminManageEmail.setText("");
        AdminManageSalary.setText("");
        AdminManagePassword.setText("");

        StaffManageID.setText("");
        StaffManageName.setText("");
        StaffManageEmail.setText("");
        StaffManageSalary.setText("");
        StaffManageContactNo.setText("");
        StaffManagePosition.setText("");
        StaffManagePassword.setText("");
    }
    //Method to clear button in DCO to order-------------------------------------------------------------------------->End


    //Method to Calculate total in DCO to order-------------------------------------------------------------------------->Start
    public void calculateTotal(){
        double total=0.0;
        for(int i=0;i<OrderedMedicineTable.getItems().size();i++){
           // System.out.println(OrderedMedicineTableName.getCellData(i));
            total=total+(OrderedMedicineTablePrice.getCellData(i)*OrderedMedicineTableQuantity.getCellData(i));

        }
        DCOTotalLable.setText(String.valueOf(total));


    }
    //Method to Calculate total in DCO to order-------------------------------------------------------------------------->End




    //Method to clear ordered table and database sales table total in DCO-------------------------------------------------------------------------->Start
    public void clearOrderTable(){

        int j=OrderedMedicineTable.getItems().size();
        int i;

        for(i=0;i<j;i++){
            int itemQty=Integer.valueOf(OrderedMedicineTableQuantity.getCellData(i));
            String id=OrderedMedicineTableID.getCellData(i);
            int availableQty=0;
            try {
                prepare=connect.prepareStatement("select quantity from medicine where medicineID=?");
                prepare.setString(1,id);
                result=prepare.executeQuery();
                result.next();
                availableQty= result.getInt(1);

                prepare=connect.prepareStatement("update medicine set quantity=? where medicineID=?");
                prepare.setInt(1,(availableQty+itemQty));
                prepare.setString(2,id);
                prepare.executeUpdate();

            } catch (SQLException e) {
                System.out.println("Error in : "+e.getMessage());
            }


        }



        try {
            statement=connect.createStatement();
            statement.executeUpdate("delete from transaction where transactionID!=' '");
        } catch (SQLException e) {
            System.out.println("Error in : "+e.getMessage());
        }
        OrderedMedicineTable.getItems().clear();
        getMedicine();
        DCOTotalLable.setText("0.0");
        DCOChangeLable.setText("0.0");
        DCOSettledTextField.setText(null);
    }

    //Method to clear ordered table and database sales table total in DCO-------------------------------------------------------------------------->End



    //Method to calculate change in DCO------------------------------------------------------------------------------------------------------------->Start
    public void change(){
        Double total =Double.valueOf( DCOTotalLable.getText());
        Double settled=Double.valueOf( DCOSettledTextField.getText());
        try {
            Double change = settled - total;
            DCOChangeLable.setText(String.valueOf(change));
        }catch (Exception e){
            System.out.println("Error in :"+e.getMessage());
        }

    }

    //Method to calculate change in DCO------------------------------------------------------------------------------------------------------------->End


    //method to do the payment in DCO------------------------------------------------------------------>Start
    public void payment(){
        Double amount=0.0;
        String settledString=DCOSettledTextField.getText();
        Double change=Double.valueOf(DCOChangeLable.getText());
        Double total=Double.valueOf(DCOTotalLable.getText());
        String transactionID=null;
        int quantity=0;


        if(settledString==null||settledString.isEmpty()){
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Settled amount is 0");
            alert.setContentText("Set a settle balance");
            alert.showAndWait();
            return;
        }

        if(total==0){
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Total is 0");
            alert.setContentText("Add items to the order");
            alert.showAndWait();
            return;
        }

        try {
            statement=connect.createStatement();
            result=statement.executeQuery("select transactionID,price from transaction");
            while (result.next()){
                transactionID=result.getString(1);
                amount=amount+result.getDouble(2);

            }

        } catch (SQLException e) {
            System.out.println("Error in : "+e.getMessage());
        }

        if(change<0){
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Settled amount is less than the total amount");
            alert.showAndWait();
            return;
        }







        for(int i=0;i<OrderedMedicineTable.getItems().size();i++){
            // System.out.println(OrderedMedicineTableName.getCellData(i));
            quantity=quantity+Integer.valueOf(OrderedMedicineTableQuantity.getCellData(i));

        }
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        try {
            prepare = connect.prepareStatement("insert into sales (salesID,type,quantity,dateandTime,amount) values (?,'DCO',?,?,?)");
            prepare.setString(1,transactionID);
            prepare.setInt(2,quantity);
            prepare.setString(3,formattedDate);
            prepare.setDouble(4,amount);

            prepare.executeUpdate();
            Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);     //Success alert
            alert.setTitle("Success Message");
            alert.setHeaderText("Successful");
            alert.setContentText("Payment done successfully");
            alert.showAndWait();

            clearOrderTable();
        } catch (SQLException e) {
            System.out.println("Error in : "+e.getMessage());
        }

    }

    //method to do the payment in DCO------------------------------------------------------------------>End






    //Method to select a Admin---------------------------------------------------------------------------------->Start

    public void selectAdmin(){
        int index=AdminManageTable.getSelectionModel().getSelectedIndex();

        currentID=AdminManageTableID.getCellData(index);

        AdminManageID.setText(AdminManageTableID.getCellData(index));
        AdminManageName.setText(AdminManageTableName.getCellData(index));
        AdminManageContactNo.setText(AdminManageTableContactNo.getCellData(index));
        AdminManageSalary.setText(String.valueOf(AdminManageTableSalary.getCellData(index)));
        AdminManageEmail.setText(AdminManageTableEmail.getCellData(index));

        try {
            prepare=connect.prepareStatement("select password from admin where userID=? ");
            prepare.setString(1,AdminManageTableID.getCellData(index));
            result= prepare.executeQuery();
            result.next();
            AdminManagePassword.setText(result.getString(1));
        } catch (SQLException e) {
            System.out.println("Error in :"+e.getMessage());
        }

    }

    //Method to select a Admin---------------------------------------------------------------------------------->End






    //Method to select a Admin---------------------------------------------------------------------------------->Start
    public void selectStaff(){
        int index=StaffManageTable.getSelectionModel().getSelectedIndex();

        currentID=StaffManageTableID.getCellData(index);

        StaffManageID.setText(StaffManageTableID.getCellData(index));
        StaffManageName.setText(StaffManageTableName.getCellData(index));
        StaffManageContactNo.setText(StaffManageTableContactNo.getCellData(index));
        StaffManageSalary.setText(String.valueOf(StaffManageTableSalary.getCellData(index)));
        StaffManageEmail.setText(StaffManageTableEmail.getCellData(index));
        StaffManagePosition.setText(StaffManageTablePosition.getCellData(index));

        try {
            prepare=connect.prepareStatement("select password from staff where userID=? ");
            prepare.setString(1,StaffManageTableID.getCellData(index));
            result= prepare.executeQuery();
            result.next();
            StaffManagePassword.setText(result.getString(1));
        } catch (SQLException e) {
            System.out.println("Error in :"+e.getMessage());
        }

    }

    //Method to select a Admin---------------------------------------------------------------------------------->End


    //Method to get Add button focus--------------------------------------->Start
    public void getAddButtonFocus(){
        DCOAddButton.requestFocus();
    }

    //Method to get Add button focus--------------------------------------->Start




    //Method to get pay button focus--------------------------------------->Start
    public void getPayButtonFocus(){
        DCOPayButton.requestFocus();
    }

    //Method to get pay button focus--------------------------------------->Start







    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ShowData();
        setQuaitynt();
        RCO_M_ADD_BTN.setDisable(true);
        RCOrderID();
        RCO_PLACR_ORDER.setDisable(true);




    }
}


