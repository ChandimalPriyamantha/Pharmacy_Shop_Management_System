package Purchase;


import Connection.DatabaseConnection;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Purchase {

    static Connection con = DatabaseConnection.ConnectionDB();
    int  id ;
    String name, pno, addressNo;

//    @FXML
//    private TableColumn<Purchase, String> pno1;
//
//    @FXML
//    private TableColumn<Purchase, String> name1;
//
//    @FXML
//    private TableColumn<Purchase, Integer> id1;
//
//    @FXML
//    private TableColumn<Purchase, String> addressNo1;



    public Purchase(int id, String name, String pno, String addressNo) {
        this.id = id;
        this.name = name;
        this.pno = pno;
        this.addressNo = addressNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public String getAddressNo() {
        return addressNo;
    }

    public void setAddressNo(String addressNo) {
        this.addressNo = addressNo;
    }

    public static ObservableList <Purchase> getData(){
        ObservableList<Purchase> list = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT serialID,supplierName,phoneNumber,address FROM purchasesupplier");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                list.add(new Purchase(rs.getInt("serialID"),
                        rs.getString("supplierName"),rs.getString("phoneNumber"),
                        rs.getString("address") ));

                System.out.println(rs.getInt("serialID"));
                System.out.println(rs.getString("supplierName"));
                System.out.println(rs.getString("phoneNumber"));
                System.out.println(rs.getString("address"));


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
