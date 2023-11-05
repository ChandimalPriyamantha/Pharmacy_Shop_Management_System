package User;

import Connection.DatabaseConnection;
import com.tech.pharmacy_shop_management_system.MainAppController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.SQLException;
import java.time.LocalDate;

public class Staff extends UserInfo {
    private String id;
    private String name;
    private String email;
    private String contactNo;
    private Double salary;
    private String position;


    public Staff() {

    }
    public Staff(String id, String name, String email, String contactNo, Double salary,String position) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.salary = salary;
        this.position=position;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getContactNo() {
        return contactNo;
    }

    @Override
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public Double getSalary() {
        return salary;
    }

    @Override
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    Alert alert;

    {
        connection= DatabaseConnection.ConnectionDB();

    }
    //Method to load Staff list from the database--------------------------------------------------------------------------------->Start

    @Override
    public ObservableList<UserInfo> loadUser() {
        ObservableList<UserInfo> listData = null;
        try {
            ps = connection.prepareStatement("select userID,name,email,phoneNumber,salary,position from staff");
            rs = ps.executeQuery();

            listData = FXCollections.observableArrayList();
            Staff staffInfo;

            while (rs.next()) {
                staffInfo = new Staff(rs.getString("userID"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phoneNumber"),
                        rs.getDouble("salary"),
                        rs.getString("position"));

                listData.add(staffInfo);
            }

        } catch (SQLException e) {
            System.out.println("Error in: " + e.getMessage());

        }
        return listData;
    }
    //Method to load Staff list from the database--------------------------------------------------------------------------------->END








    //Method to add staff ------------------------------------------------------------------------------------------------------->Start

    public void addUser(String id,String name,String contactNo,String password,String salary,String email,String position) {
        LocalDate date = LocalDate.now();

        if(id.isEmpty()||name.isEmpty()||contactNo.isEmpty()||password.isEmpty()||salary.isEmpty()||email.isEmpty()||position.isEmpty()){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Fill all fields");
            alert.setContentText("Please check and fill all the fields");
            alert.showAndWait();
            return;
        }

        try {
            ps=connection.prepareStatement("select userID,password from staff");
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getString(1).equals(id)){
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("ID is exists");
                    alert.setContentText("Please use another User ID");
                    alert.showAndWait();
                    return;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error in: "+e.getMessage());
        }

        if(!isValidEmail(email)){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Email is not valid");
            alert.setContentText("Please use valid email");
            alert.showAndWait();
            return;
        }

        try {
            ps = connection.prepareStatement("Insert into staff (userID,name,phoneNumber,email,joinDate,salary,password,position) values (?,?,?,?,?,?,?,?)");
            ps.setString(1,id);
            ps.setString(2,name);
            ps.setString(3,contactNo);
            ps.setString(4,email);
            ps.setString(5, String.valueOf(date));
            ps.setDouble(6, Double.parseDouble(salary));
            ps.setString(7,password);
            ps.setString(8,position);
            ps.executeUpdate();


            alert = new Alert(Alert.AlertType.INFORMATION);     //Success alert
            alert.setTitle("Success Message");
            alert.setHeaderText("ADDED");
            alert.setContentText("User added successfully");
            alert.showAndWait();

        } catch (SQLException e) {
            System.out.println("Error in: "+e.getMessage());
        }

    }
    //Method to add staff ------------------------------------------------------------------------------------------------------->End







    //Method to update staff---------------------------------------------------------->Start
    public void editUser(String name,String contactNo,String password,String salary,String email,String position,String cID) {
        if(name.isEmpty()||contactNo.isEmpty()||password.isEmpty()||salary.isEmpty()||email.isEmpty()||position.isEmpty()){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Fill all fields");
            alert.setContentText("Please select a user or  fill all the fields");
            alert.showAndWait();
            return;
        }


        if(!isValidEmail(email)){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Email is not valid");
            alert.setContentText("Please use valid email");
            alert.showAndWait();
            return;
        }

        try {
            ps = connection.prepareStatement("Update staff set name=?,phoneNumber=?,email=?,salary=?,password=?,position=? where userID=?");
            ps.setString(1,name);
            ps.setString(2,contactNo);
            ps.setString(3,email);
            ps.setDouble(4, Double.parseDouble(salary));
            ps.setString(5,password);
            ps.setString(6,position);
            ps.setString(7,cID);
            ps.executeUpdate();


            alert = new Alert(Alert.AlertType.INFORMATION);     //Success alert
            alert.setTitle("Success Message");
            alert.setHeaderText("UPDATED");
            alert.setContentText("User Updated successfully");
            alert.showAndWait();

        } catch (SQLException e) {
            System.out.println("Error in: "+e.getMessage());
        }



    }
    //Method to Update Staff---------------------------------------------------------->End

    //Method to delete user---------------------------------------------------------->Start
    public void deleteUser(String cID) {
        try {
            ps = connection.prepareStatement("delete from staff where userID=?");
            ps.setString(1,cID);
            ps.executeUpdate();


            alert = new Alert(Alert.AlertType.INFORMATION);     //Success alert
            alert.setTitle("Success Message");
            alert.setHeaderText("DELETED");
            alert.setContentText("User has deleted successfully");
            alert.showAndWait();

        } catch (SQLException e) {
            System.out.println("Error in: "+e.getMessage());
        }
    }
    //Method to delete user---------------------------------------------------------->End



    //Method to search Staff results list from the database--------------------------------------------------------------------------------->END
    @Override
    public ObservableList<UserInfo> searchUser(String id) {
        ObservableList<UserInfo> searchList = null;
        try {
            ps = connection.prepareStatement("select userID,name,email,phoneNumber,salary,position from staff where userId=?");
            ps.setString(1,id);
            rs = ps.executeQuery();

            searchList = FXCollections.observableArrayList();
            Staff staffInfo;

            while (rs.next()) {
                staffInfo = new Staff(rs.getString("userID"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phoneNumber"),
                        rs.getDouble("salary"),
                        rs.getString("position"));

                searchList.add(staffInfo);
            }

        } catch (SQLException e) {
            System.out.println("Error in: " + e.getMessage());

        }
        return searchList;

    }
    //Method to search User list from the database--------------------------------------------------------------------------------->END





}




