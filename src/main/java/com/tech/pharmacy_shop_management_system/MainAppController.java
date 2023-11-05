package com.tech.pharmacy_shop_management_system;

import Connection.DatabaseConnection;
import Email.Email;
import Purchase.Purchase;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private TableView<Purchase> cptbldetails;

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
    public TextField ppAddress;

    @FXML
    public TextField ppCmpnyRegNo;

    @FXML
    public TextField ppContactNo;

    @FXML
    private TextField ppMedicineID;

    @FXML
    private TextField ppMedicineName;

    @FXML
    public TextField ppName;

    @FXML
    private Spinner<Integer> ppQty;


    @FXML
    private Spinner<Integer> testSpinner;
    @FXML
    private Button ppRemove;

    @FXML
    private TableColumn<Purchase, String> ppTableId;

    @FXML
    private TableView<?> ppTbl;

    @FXML
    private TableColumn<Purchase, Integer> ppTbleQuantity;

    @FXML
    private Button ppbtn;

    @FXML
    private TextField ppsupplierIDtxt;

    @FXML
    private TableColumn<Purchase, String> pptblName;

    @FXML
    private Button pptblPlacePurchase;

    @FXML
    private AnchorPane purchaseAp;

    @FXML
    private TableView<Purchase> purchaseTbl;

    @FXML
    private Button purchasebtn;

    @FXML
    private TableColumn<?, ?> qtypp;

    @FXML
    private WebView webView;

    @FXML
    private AnchorPane completePurchaseAP;

    private SpinnerValueFactory<Integer> spin;

    int index = -1;


    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;


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

//      public void textMethod(){
//          System.out.println("Hi");
//      }

    //   add supplier for purchase

    String supid;
    public void addSupdata() {
//        System.out.println("HI");
        supid= ppsupplierIDtxt.getText();
        connection = DatabaseConnection.ConnectionDB();
        String qry = "select supplierName,companyRegistrationNumber,phoneNumber,address from purchasesupplier where supplierID=?";
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(qry);
            ps.setString(1, supid);
            rs = ps.executeQuery();

            while (rs.next()) {
                ppName.setText(rs.getString("supplierName"));
                ppCmpnyRegNo.setText(rs.getString("companyRegistrationNumber"));
                ppContactNo.setText(rs.getString("phoneNumber"));
                ppAddress.setText(rs.getString("address"));


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    String medicineID;
    //add medicine for purchase
    public void addMedicine()
    {

        medicineID=ppMedicineID.getText();
        String sql="SELECT name FROM pharmacydb.medicine where medicineID=?";
        connection = DatabaseConnection.ConnectionDB();
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, medicineID);
            rs = ps.executeQuery();

            while (rs.next()) {
                ppMedicineName.setText(rs.getString("name"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    int quantity;
    public void setQnty(){
              spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0);
              ppQty.setValueFactory(spin);



    }

    // add data into purchasemedcine table----------------------------------------------------

    public void addMedicinePurchases()
    {
        quantity = spin.getValue();
        connection = DatabaseConnection.ConnectionDB();
        String sql="INSERT INTO purchasemedicine (supplierID,medicineID,quantity) VALUES (?,?,?)";
        try {
            PreparedStatement ps =connection.prepareStatement(sql);
            ps.setString(1,supid);
            ps.setString(2,medicineID);
            ps.setInt(3,quantity);
            ps.executeUpdate();

            ShowpurchaseData();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    // view purchase medicine table for place purchases----------------------------------------------------

    public static  ObservableList<Purchase>  getpurchaseMedicine()
    {

        String sql2="SELECT purchasemedicine.medicineID,medicine.name,purchasemedicine.quantity FROM pharmacydb.purchasemedicine inner join medicine on purchasemedicine.medicineID=medicine.medicineID";
        Connection connection = DatabaseConnection.ConnectionDB();
        ObservableList<Purchase> list= FXCollections.observableArrayList();
        PreparedStatement prs= null;
        
        try {
            prs = connection.prepareStatement(sql2);
            ResultSet rs=prs.executeQuery();

            Purchase purchase;
            
            while(rs.next())
            {
                purchase=new Purchase(rs.getString("purchasemedicine.medicineID"),rs.getString("medicine.name"),rs.getInt("purchasemedicine.quantity"));

                list.add(purchase);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    private ObservableList<Purchase> viewpurchasemedicinceData;
    public  void ShowpurchaseData(){

        viewpurchasemedicinceData = getpurchaseMedicine();

        ppTableId.setCellValueFactory(new PropertyValueFactory<Purchase,String>("medicineID"));
        pptblName.setCellValueFactory(new PropertyValueFactory<Purchase,String>("Name"));
        ppTbleQuantity.setCellValueFactory(new PropertyValueFactory<Purchase,Integer>("quantity"));

        cptbldetails.setItems(viewpurchasemedicinceData);
    }


    //-------------------------------------------------------------------------------------------------------------

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setQnty();

    }





}


