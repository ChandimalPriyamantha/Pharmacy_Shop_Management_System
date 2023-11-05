package Purchase;


import Connection.DatabaseConnection;
import com.tech.pharmacy_shop_management_system.MainAppController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXML;
public class Purchase {
    private String ppsupplierIDtxt;
    private String ppName = null;
    private String ppCmpnyRegNo = null;
    private String ppContactNo = null;
    private String ppAddress = null;
    private  Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;


    public String getPpsupplierIDtxt() {
        return ppsupplierIDtxt;
    }

    public void setPpsupplierIDtxt(String ppsupplierIDtxt) {
        this.ppsupplierIDtxt = ppsupplierIDtxt;
    }

    public String getPpName() {
        return ppName;
    }

    public void setPpName(String ppName) {
        this.ppName = ppName;
    }

    public String getPpCmpnyRegNo() {
        return ppCmpnyRegNo;
    }

    public void setPpCmpnyRegNo(String ppCmpnyRegNo) {
        this.ppCmpnyRegNo = ppCmpnyRegNo;
    }

    public String getPpContactNo() {
        return ppContactNo;
    }

    public void setPpContactNo(String ppContactNo) {
        this.ppContactNo = ppContactNo;
    }

    public String getPpAddress() {
        return ppAddress;
    }

    public void setPpAddress(String ppAddress) {
        this.ppAddress = ppAddress;
    }

    public void addSupdata(String id){
        System.out.println("HI");

        connection = DatabaseConnection.ConnectionDB();
        String qry = "select supplierName,companyRegistrationNumber,phoneNumber,address from purchasesupplier where supplierID=?";
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(qry);
            ps.setString(1,id);
            rs=ps.executeQuery();

            while(rs.next())
            {
                ppName=rs.getString("supplierName");
                ppCmpnyRegNo=rs.getString("companyRegistrationNumber");
                ppContactNo=rs.getString("phoneNumber");
                ppAddress=rs.getString("address");
                System.out.println(rs.getString("address"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //System.out.println(ppName);



    }






}
