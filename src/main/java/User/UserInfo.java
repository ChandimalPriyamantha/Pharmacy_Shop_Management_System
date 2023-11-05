package User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Connection.DatabaseConnection;
import com.tech.pharmacy_shop_management_system.MainAppController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class UserInfo implements User {
    Connection connection =null;
    ResultSet rs=null;
    PreparedStatement ps=null;

    private String id;
    private String name;
    private String email;
    private String contactNo;
    private Double salary;

    public UserInfo() {}

    public UserInfo(String id, String name, String email, String contactNo, Double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    Alert alert;

    {
        connection=DatabaseConnection.ConnectionDB();

    }

    //Method to load User list from the database--------------------------------------------------------------------------------->Start
    public ObservableList<UserInfo> loadUser() {
        ObservableList<UserInfo> listData = null;
        try {
            ps = connection.prepareStatement("select userID,name,email,phoneNumber,salary from admin");
            rs = ps.executeQuery();

            listData = FXCollections.observableArrayList();
            UserInfo userInfo;

            while (rs.next()) {
                userInfo = new UserInfo(rs.getString("userID"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phoneNumber"),
                        rs.getDouble("salary"));

                listData.add(userInfo);
            }

        } catch (SQLException e) {
            System.out.println("Error in: " + e.getMessage());

        }
        return listData;

    }
    //Method to load User list from the database--------------------------------------------------------------------------------->END





    //Method to search User results list from the database--------------------------------------------------------------------------------->END
    public ObservableList<UserInfo> searchUser(String id) {
        ObservableList<UserInfo> searchList = null;
        try {
            ps = connection.prepareStatement("select userID,name,email,phoneNumber,salary from admin where userId=?");
            ps.setString(1,id);
            rs = ps.executeQuery();

            searchList = FXCollections.observableArrayList();
            UserInfo userInfo;

            while (rs.next()) {
                userInfo = new UserInfo(rs.getString("userID"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phoneNumber"),
                        rs.getDouble("salary"));

                searchList.add(userInfo);
            }

        } catch (SQLException e) {
            System.out.println("Error in: " + e.getMessage());

        }
        return searchList;

    }
    //Method to search User list from the database--------------------------------------------------------------------------------->END









    //Method to add user ------------------------------------------------------------------------------------------------------->Start
    @Override
    public void addUser(String id,String name,String contactNo,String password,String salary,String email) {
        LocalDate date = LocalDate.now();

       if(id.isEmpty()||name.isEmpty()||contactNo.isEmpty()||password.isEmpty()||salary.isEmpty()||email.isEmpty()){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Fill all fields");
            alert.setContentText("Please check and fill all the fields");
            alert.showAndWait();
            return;
        }

        try {
            ps=connection.prepareStatement("select userID,password from admin");
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
            ps = connection.prepareStatement("Insert into Admin (userID,name,phoneNumber,email,joinDate,salary,password) values (?,?,?,?,?,?,?)");
            ps.setString(1,id);
            ps.setString(2,name);
            ps.setString(3,contactNo);
            ps.setString(4,email);
            ps.setString(5, String.valueOf(date));
            ps.setDouble(6, Double.parseDouble(salary));
            ps.setString(7,password);
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
    //Method to add user ------------------------------------------------------------------------------------------------------->End






    //Method to update user---------------------------------------------------------->Start
    @Override
    public void editUser(String name,String contactNo,String password,String salary,String email,String cID) {
        if(name.isEmpty()||contactNo.isEmpty()||password.isEmpty()||salary.isEmpty()||email.isEmpty()){
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
            ps = connection.prepareStatement("Update admin set name=?,phoneNumber=?,email=?,salary=?,password=? where userID=?");
            ps.setString(1,name);
            ps.setString(2,contactNo);
            ps.setString(3,email);
            ps.setDouble(4, Double.parseDouble(salary));
            ps.setString(5,password);
            ps.setString(6,cID);
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
    //Method to update user---------------------------------------------------------->End




    //Method to delete user---------------------------------------------------------->Start
    public void deleteUser(String cID) {
        try {
            ps = connection.prepareStatement("delete from admin where userID=?");
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




    //Method to validate email-------------------------------------------------------->Start
    public static boolean isValidEmail(String email){
        String emailPattern= "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern =Pattern.compile(emailPattern);
        Matcher matcher =pattern.matcher(email);
        return matcher.matches();
}
    //Method to validate email-------------------------------------------------------->Start
}

