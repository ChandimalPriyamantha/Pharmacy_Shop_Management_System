package com.tech.pharmacy_shop_management_system;

import Email.Email;
import Connection.DatabaseConnection;
import RemortCustomer.RemoteCustomerOrderMedicineDetails;
import SalesTransaction.MedicineData;
import SalesTransaction.Sales;
import User.Admin;
import User.Staff;
import User.UserInfo;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


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
                     UserManageBackground.setVisible(false);
                     Email email = new  Email(webView);
                     email.emailServer();
                 }else if (event.getSource() == RCO_BTN ) { // navigate into remote customer oder page
                     RCOManagePanel.setVisible(true);
                     WEB_VIEW.setVisible(false);
                     RCOPaymentPanel.setVisible(false);
                     DCOBackground.setVisible(false);
                     UserManageBackground.setVisible(false);
              }else if(event.getSource() ==RCOPaymentBtn){ // navigate into remote customer payment page
                     System.out.println("hi");
                     RCOManagePanel.setVisible(false);
                     WEB_VIEW.setVisible(false);
                     RCOPaymentPanel.setVisible(true);
                     DCOBackground.setVisible(false);
                     UserManageBackground.setVisible(false);
                 }else if(event.getSource()==DCOManageButton){ // navigate into Direct customer order page

                     getMedicine();    //Load stock medicine

                     DCOBackground.setVisible(true);
                     RCOPaymentPanel.setVisible(false);
                     RCOManagePanel.setVisible(false);
                     WEB_VIEW.setVisible(false);
                     UserManageBackground.setVisible(false);
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

                 }else if(event.getSource()==AdminManageClearButton||event.getSource()==StaffManageClearButton){ // Functionality to Clear User manage Text fields
                     clearUserData();
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

    //Method to load Admin List to table ------------------------------------------------------------------------->start






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


    //Method to load Staff List to table ------------------------------------------------------------------------->start










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
            if(updateQty==0){
                alert = new Alert(Alert.AlertType.ERROR);       //error message to indicate medicine is out of stocked
                alert.setTitle("Error Message");
                alert.setHeaderText("Out of Stock");
                alert.setContentText("This medicine looks like out of stocked");
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


        if(settledString.isEmpty()){
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







    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ShowData();

    }
}


