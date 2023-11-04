package SalesTransaction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.DatabaseConnection;

import static java.lang.System.exit;


public class Sales {

    private String DCOReadIDTextField=null;
    private double DCOPriceTextField=0.0;
    private int DCOQuantityTextField=0;
    private String DCOTextFieldMedicineName=null;

    private static Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    //Method to load medicine stock from database for DCO---------------------------------------------------->Start
    public ObservableList<MedicineData> loadMedicine(){
        connection = DatabaseConnection.ConnectionDB();
        String query = "SELECT medicineID,name,quantity,price FROM medicine";
        ObservableList<MedicineData> listData = FXCollections.observableArrayList();

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            MedicineData medicineData;

            while (rs.next()){
                medicineData=new MedicineData(rs.getString("medicineID"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"));

                listData.add(medicineData);
            }
        } catch (SQLException e) {
            System.out.println("Error in : "+e.getMessage());
        }
        return listData;

    }
    //Method to load medicine stock from database for DCO---------------------------------------------------->End

    //Method to add medicine to order in DCO-------------------------------------------------------------------------->Start

    static ObservableList<MedicineData> addedList = FXCollections.observableArrayList();
    public static ObservableList<MedicineData> addSale(String ID, String name, String quantity, String price){

        MedicineData medicineData;
        medicineData=new MedicineData(ID,name,Integer.valueOf(quantity),Double.valueOf(price));
        addedList.add(medicineData);
        return addedList;

    }
    //Method to add medicine to order in DCO-------------------------------------------------------------------------->End


    //Method to change quantity of medicine in database when DCO------------------------------------------------------->Start
    public static int changeQuantity(String ID,int requiredQuantity){
        connection = DatabaseConnection.ConnectionDB();
        String query = "SELECT quantity FROM medicine where medicineID=?";
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(query);
            ps.setString(1,ID);
            ResultSet rs = ps.executeQuery();
            rs.next();

            int availableStock = rs.getInt(1);
            //int requestedQuantity=Integer.valueOf(DCOQuantityTextField.getText());
            if(availableStock<requiredQuantity){
                System.out.println("There is no enough stock...");          //--------------------------------->Error message.. Need to create a error prompt message
                return 0;
            }
                availableStock=availableStock-requiredQuantity;
                String mid=ID;
                query = "update medicine set quantity=? where medicineID="+"'"+mid+"'";
                ps = connection.prepareStatement(query);
                ps.setInt(1,availableStock);
                ps.executeUpdate();



        } catch (SQLException e) {
            System.out.println("Error in : "+e.getMessage());
        }
        return 1;
    }

    //Method to change quantity of medicine in database when DCO------------------------------------------------------->End

}
