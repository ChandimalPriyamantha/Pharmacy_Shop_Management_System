package Purchase;

import Connection.DatabaseConnection;
import RemortCustomer.RemoteCustomerOrderMedicineDetails;
import com.tech.pharmacy_shop_management_system.MainAppController;

import java.sql.*;


public class PlacePurchase {

    private Connection connect;

    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    MainAppController mp = new MainAppController();

    public PlacePurchase() {
        getSupID();
    }

    public void getSupID()
    {
        if(!(mp.ppsupplierID == ""))
        {
            getData();
        }
    }



    public void getData() {


       String supID = mp.ppsupplierID.getText();

        String sql = "SELECT supplierName,address,contactNumber,companyRegNo FROM pharmacydb.supplier where supplierID=supID";



        Connection connect = DatabaseConnection.ConnectionDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            RemoteCustomerOrderMedicineDetails remoteCustomerOrderMedicineDetails;

            while (result.next()) {

                mp.ppName.setText(result.getString("supplierName"));
                mp.ppName.setText(result.getString("supplierName"));
                mp.ppName.setText(result.getString("address"));
                mp.ppName.setText(result.getString("contactNumber"));
                mp.ppName.setText(result.getString("companyRegNo"));


            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }






//    private ObservableList<RemoteCustomerOrderMedicineDetails> ROCListData;
//    public  void ShowData(){
//
//        ROCListData = getData();
//
//        ROC_ID.setCellValueFactory(new PropertyValueFactory<>("orderID"));
//        ROC_NAME.setCellValueFactory(new PropertyValueFactory<>("name"));
//        RCO_ADDRESS.setCellValueFactory(new PropertyValueFactory<>("address"));
//        RCO_CONTACT_NO.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
//
//        TABLE_VIEW.setItems(ROCListData);
//    }


}
