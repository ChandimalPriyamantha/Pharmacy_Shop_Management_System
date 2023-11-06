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
import medicine.Medicine;

import java.net.URL;
import java.sql.*;
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
    private TableView<?> AdminManageTable;

    @FXML
    private TableColumn<?, ?> AdminManageTableContactNo;

    @FXML
    private TableColumn<?, ?> AdminManageTableEmail;

    @FXML
    private TableColumn<?, ?> AdminManageTableID;

    @FXML
    private TableColumn<?, ?> AdminManageTableName;

    @FXML
    private TableColumn<?, ?> AdminManageTableSalary;

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
    private TableView<?> StaffManageTable;

    @FXML
    private TableColumn<?, ?> StaffManageTableContactNo;

    @FXML
    private TableColumn<?, ?> StaffManageTableEmail;

    @FXML
    private TableColumn<?, ?> StaffManageTableID;

    @FXML
    private TableColumn<?, ?> StaffManageTableName;

    @FXML
    private TableColumn<?, ?> StaffManageTablePosition;

    @FXML
    private TableColumn<?, ?> StaffManageTableSalary;

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

    //Inventory and Report

    @FXML
    private Button dcorbtn;

    @FXML
    private Button iaddbtn;

    @FXML
    private Button iclearbtn;

    @FXML
    private Button ideletebtn;

    @FXML
    private TextField iedate;

    @FXML
    private TextField imanufacture;

    @FXML
    private TextField imname;

    @FXML
    private Button incentorybtn;

    @FXML
    private TableView<Medicine> inventorytbl;

    @FXML
    private AnchorPane inventorytblAP;

    @FXML
    private TextField iprice;

    @FXML
    private Button irNavbtn;

    @FXML
    private AnchorPane irViewAP;

    @FXML
    private TextField irid;

    @FXML
    private TextField istoke;

    @FXML
    private TextField isearch;

    @FXML
    private TableColumn<Medicine, Integer> itblquantity;

    @FXML
    private TableColumn<Medicine, String> itblManufacturer;

    @FXML
    private TableColumn<Medicine, String> itblid;

    @FXML
    private TableColumn<Medicine, String> itblexpireDate;

    @FXML
    private TableColumn<Medicine, String> itblname;

    @FXML
    private TableColumn<Medicine, Double> itblprice;

    @FXML
    private Button iupdatebtn;

    @FXML
    private Button prbtn;

    @FXML
    private TableColumn<?, ?> prdate;

    @FXML
    private TableColumn<?, ?> prid;

    @FXML
    private Button printbtnreport;

    @FXML
    private TableColumn<?, ?> prpurchase;

    @FXML
    private TableColumn<?, ?> prqnty;

    @FXML
    private TableColumn<?, ?> prsupplierid;

    @FXML
    private TableView<?> prtbl;

    @FXML
    private AnchorPane prtblAP;

    @FXML
    private AnchorPane purchareview;

    @FXML
    private Button purchasenavbtn;

    @FXML
    private TableColumn<?, ?> rcodcodate;

    @FXML
    private TableColumn<?, ?> rcodcoid;

    @FXML
    private TableColumn<?, ?> rcodcoqnty;

    @FXML
    private AnchorPane rcodcoreporttbl;

    @FXML
    private TableColumn<?, ?> rcodcosales;

    @FXML
    private TableView<?> rcodcotbl;

    @FXML
    private Button rcorbtn;

    @FXML
    private AnchorPane reportAP;

    @FXML
    private Button reportbtn;



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
                     DCOBackground.setVisible(true);
                     RCOPaymentPanel.setVisible(false);
                     RCOManagePanel.setVisible(false);
                     WEB_VIEW.setVisible(false);
                     UserManageBackground.setVisible(false);
                 }else if(event.getSource()==UserManageButton){ // navigate into User Manage page
                     DCOBackground.setVisible(false);
                     RCOPaymentPanel.setVisible(false);
                     RCOManagePanel.setVisible(false);
                     WEB_VIEW.setVisible(false);
                     UserManageBackground.setVisible(true);
                     StaffManageBackground.setVisible(true);
                     AdminManageBackground.setVisible(false);
                 }else if(event.getSource()==UserManageStaffButton){ // navigate into User Manage page
                     DCOBackground.setVisible(false);
                     RCOPaymentPanel.setVisible(false);
                     RCOManagePanel.setVisible(false);
                     WEB_VIEW.setVisible(false);
                     UserManageBackground.setVisible(true);
                     StaffManageBackground.setVisible(true);
                     AdminManageBackground.setVisible(false);
                 }else if(event.getSource()==UserManageAdminButton){ // navigate into User Manage page
                     DCOBackground.setVisible(false);
                     RCOPaymentPanel.setVisible(false);
                     RCOManagePanel.setVisible(false);
                     WEB_VIEW.setVisible(false);
                     UserManageBackground.setVisible(true);
                     StaffManageBackground.setVisible(false);
                     AdminManageBackground.setVisible(true);
                 }
                 else if(event.getSource()==irNavbtn){ // navigate into User Manage page
                     DCOBackground.setVisible(false);
                     RCOPaymentPanel.setVisible(false);
                     RCOManagePanel.setVisible(false);
                     WEB_VIEW.setVisible(false);
                     UserManageBackground.setVisible(false);
                     StaffManageBackground.setVisible(false);
                     AdminManageBackground.setVisible(false);
                     irViewAP.setVisible(true);
                     purchareview.setVisible(true);
                     reportAP.setVisible(false);
                 }else if(event.getSource()==reportbtn){ // navigate into User Manage page
                     DCOBackground.setVisible(false);
                     RCOPaymentPanel.setVisible(false);
                     RCOManagePanel.setVisible(false);
                     WEB_VIEW.setVisible(false);
                     UserManageBackground.setVisible(false);
                     StaffManageBackground.setVisible(false);
                     AdminManageBackground.setVisible(false);
                     purchareview.setVisible(false);
                     reportAP.setVisible(true);
                 }else if(event.getSource()==incentorybtn){ // navigate into User Manage page
                     DCOBackground.setVisible(false);
                     RCOPaymentPanel.setVisible(false);
                     RCOManagePanel.setVisible(false);
                     WEB_VIEW.setVisible(false);
                     UserManageBackground.setVisible(false);
                     StaffManageBackground.setVisible(false);
                     AdminManageBackground.setVisible(false);
                     purchareview.setVisible(true);
                     reportAP.setVisible(false);
                 }else if(event.getSource()==rcorbtn){ // navigate into User Manage page
                     DCOBackground.setVisible(false);
                     RCOPaymentPanel.setVisible(false);
                     RCOManagePanel.setVisible(false);
                     WEB_VIEW.setVisible(false);
                     UserManageBackground.setVisible(false);
                     StaffManageBackground.setVisible(false);
                     AdminManageBackground.setVisible(false);
                     purchareview.setVisible(false);
                     rcodcoreporttbl.setVisible(true);
                     prtblAP.setVisible(false);

                 }
                 else if(event.getSource()==dcorbtn){ // navigate into User Manage page
                     DCOBackground.setVisible(false);
                     RCOPaymentPanel.setVisible(false);
                     RCOManagePanel.setVisible(false);
                     WEB_VIEW.setVisible(false);
                     UserManageBackground.setVisible(false);
                     StaffManageBackground.setVisible(false);
                     AdminManageBackground.setVisible(false);
                     purchareview.setVisible(false);
                     rcodcoreporttbl.setVisible(true);
                     prtblAP.setVisible(false);

                 }else if(event.getSource()==prbtn){ // navigate into User Manage page
                     DCOBackground.setVisible(false);
                     RCOPaymentPanel.setVisible(false);
                     RCOManagePanel.setVisible(false);
                     WEB_VIEW.setVisible(false);
                     UserManageBackground.setVisible(false);
                     StaffManageBackground.setVisible(false);
                     AdminManageBackground.setVisible(false);
                     purchareview.setVisible(false);
                     rcodcoreporttbl.setVisible(false);
                     prtblAP.setVisible(true);

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

    //tg706-medicine
    public ObservableList<Medicine> getMedicineData(){

        String sql = "SELECT * FROM medicine";


        ObservableList<Medicine> listMedicineData = FXCollections.observableArrayList();
        connect = DatabaseConnection.ConnectionDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            Medicine medicinetable;

            while (result.next()){

                medicinetable = new Medicine(
                        result.getString("medicineID"),
                        result.getString("name"),
                        result.getInt("quantity"),
                        result.getString("manufacturer"),
                        result.getString("expireDate"),
                        result.getDouble("price"));

                listMedicineData.add(medicinetable);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return  listMedicineData;
    }
//tg706-end


    private ObservableList<RemoteCustomerOrderMedicineDetails> ROCListData;
    public  void ShowData(){

        ROCListData = getData();

        ROC_ID.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        ROC_NAME.setCellValueFactory(new PropertyValueFactory<>("name"));
        RCO_ADDRESS.setCellValueFactory(new PropertyValueFactory<>("address"));
        RCO_CONTACT_NO.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));




        TABLE_VIEW.setItems(ROCListData);
    }


    //tg706-medicine-view-start
    private ObservableList<Medicine> MedicinesDatas;
    public  void ShowMedicineData(){

        MedicinesDatas = getMedicineData();

        itblid.setCellValueFactory(new PropertyValueFactory<>("medicineID"));
        itblname.setCellValueFactory(new PropertyValueFactory<>("medicineName"));
        itblquantity.setCellValueFactory(new PropertyValueFactory<>("medicineQuantity"));
        itblManufacturer.setCellValueFactory(new PropertyValueFactory<>("medicineManufacturer"));
        itblexpireDate.setCellValueFactory(new PropertyValueFactory<>("medicineExpireDate"));
        itblprice.setCellValueFactory(new PropertyValueFactory<>("medicinePrice"));




        inventorytbl.setItems(MedicinesDatas);
    }

//tg706-addData-Medicine-start
public void insertMedicineData()
{
    PreparedStatement ps;
    ResultSet rs;
    String sql="insert into medicine (medicineID,name,quantity,manufacturer,expireDate,price) values (?,?,?,?,?,?)";
    try {
        ps= connect.prepareStatement(sql);
        ps.setString(1,irid.getText());
        ps.setString(2,imname.getText());
        ps.setInt(3, Integer.parseInt(istoke.getText()));
        ps.setString(4,imanufacture.getText());
        ps.setString(5,iedate.getText());
        ps.setDouble(6, Double.parseDouble(iprice.getText()));

        ps.executeUpdate();
        ShowMedicineData();

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

}



public ObservableList<Medicine> searchMedicine()
{
    String sql="select * from medicine where medicineID=?";
    ObservableList<Medicine> MedicineDataListSearch = FXCollections.observableArrayList();
    try {
        prepare = connect.prepareStatement(sql);
        Medicine medicineSearchTable;

        prepare.setString(1,isearch.getText());
        result = prepare.executeQuery();

        while(result.next())
        {
            medicineSearchTable = new Medicine(
            result.getString("medicineID"),
            result.getString("name"),
            result.getInt("quantity"),
            result.getString("manufacturer"),
            result.getString("expireDate"),
            result.getDouble("price"));

            MedicineDataListSearch.add(medicineSearchTable);
        }


    } catch (SQLException e) {
        throw new RuntimeException(e);
    }


    return MedicineDataListSearch;
}

    private ObservableList<Medicine> MedicinesDataSearch;
    public  void ShowMedicineDataSearch(){

        if (isearch.getText().isEmpty()){
            ShowMedicineData();
        }else {
            MedicinesDataSearch = searchMedicine();

            itblid.setCellValueFactory(new PropertyValueFactory<>("medicineID"));
            itblname.setCellValueFactory(new PropertyValueFactory<>("medicineName"));
            itblquantity.setCellValueFactory(new PropertyValueFactory<>("medicineQuantity"));
            itblManufacturer.setCellValueFactory(new PropertyValueFactory<>("medicineManufacturer"));
            itblexpireDate.setCellValueFactory(new PropertyValueFactory<>("medicineExpireDate"));
            itblprice.setCellValueFactory(new PropertyValueFactory<>("medicinePrice"));


            inventorytbl.setItems(MedicinesDataSearch);
        }

    }


public ObservableList<Medicine> updateMedicineData()
{
    String sql="Update medicine set medicineID=?, name=?,quantity=?,manufacturer=?,expireDate=?,price=? where medicineID=? ;";
    ObservableList<Medicine> MedicineDataListUpdate = FXCollections.observableArrayList();
    try {
        prepare = connect.prepareStatement(sql);
        Medicine medicineUpdate;

        prepare.setString(1,);
        prepare.setString(2,);
        prepare.setInt(3,);
        prepare.setString(4,);
        prepare.setString(5,);
        prepare.setString(6,);
        prepare.setString(7,);

        result = prepare.executeQuery();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return null;
}



public void deleteMedicineData()
{
    String sql="DELETE FROM table_name WHERE medicineID=?";
    try {
        prepare = connect.prepareStatement(sql);
        prepare.setString(1,isearch.getText());
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }


}




    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ShowData();
        ShowMedicineData();

    }
}


