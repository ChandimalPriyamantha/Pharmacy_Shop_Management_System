package Purchase;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Purchase {
    private String ppsupplierIDtxt = null;
    private String ppName = null;
    private String ppCmpnyRegNo = null;
    private String ppContactNo = null;
    private String ppAddress = null;
    private static Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;



    public ObservableList<PlacePurchase> getSupplierData(){
        connection = DatabaseConnection.ConnectionDB();
        String query = "select supplierID,supplierName,companyRegistrationNumber,phoneNumber,address from purchasesupplier";
        PreparedStatement ps = null;
        try {
            ps = connection
        }
        return null;
    }






}
