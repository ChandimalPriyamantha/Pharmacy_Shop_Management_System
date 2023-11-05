package Purchase;

import Connection.DatabaseConnection;
import RemortCustomer.RemoteCustomerOrderMedicineDetails;
import com.tech.pharmacy_shop_management_system.MainAppController;

import java.sql.*;
import javafx.fxml.FXML;

public class PlacePurchase {

    private String supID;
    private String supName;
    private String supCmpnyNo;
    private String supCNo;
    private String supAddress;

    public PlacePurchase(String supID, String supName, String supCmpnyNo, String supCNo, String supAddress) {
        this.supID = supID;
        this.supName = supName;
        this.supCmpnyNo = supCmpnyNo;
        this.supCNo = supCNo;
        this.supAddress = supAddress;
    }

    public String getSupID() {
        return supID;
    }

    public void setSupID(String supID) {
        this.supID = supID;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getSupCmpnyNo() {
        return supCmpnyNo;
    }

    public void setSupCmpnyNo(String supCmpnyNo) {
        this.supCmpnyNo = supCmpnyNo;
    }

    public String getSupCNo() {
        return supCNo;
    }

    public void setSupCNo(String supCNo) {
        this.supCNo = supCNo;
    }

    public String getSupAddress() {
        return supAddress;
    }

    public void setSupAddress(String supAddress) {
        this.supAddress = supAddress;
    }
}






