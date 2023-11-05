package com.tech.pharmacy_shop_management_system;

import Email.Email;
import Connection.DatabaseConnection;
import RemortCustomer.RemoteCustomerOrderMedicineDetails;
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
import java.util.Calendar;
import java.util.HashMap;
import java.util.ResourceBundle;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;

import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


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
                     Email email = new  Email(webView);
                     email.emailServer();
                 }else if (event.getSource() == RCO_BTN ) { // navigate into remote customer oder page
                     RCOManagePanel.setVisible(true);
                     WEB_VIEW.setVisible(false);
                     RCOPaymentPanel.setVisible(false);
                     ShowData();
                     RCOrderID();



              }else if(event.getSource() ==RCOPaymentBtn){ // navigate into remote customer payment page
                    // System.out.println("hi");
                     RCOManagePanel.setVisible(false);
                     WEB_VIEW.setVisible(false);
                     RCOPaymentPanel.setVisible(true);
                     PM_PYAMENT_BTN.setDisable(true);
                     ShowPData();
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ShowData();
        setQuaitynt();
        RCO_M_ADD_BTN.setDisable(true);
        RCOrderID();
        RCO_PLACR_ORDER.setDisable(true);




    }
}


