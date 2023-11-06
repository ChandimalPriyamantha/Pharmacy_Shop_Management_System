package com.tech.pharmacy_shop_management_system;

import Connection.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.sql.*;


public class LogInController {

    //Database access
    private  Connection connect;

    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;


    //main board access
    @FXML
    private AnchorPane title_button_tab;
    @FXML
    private Button adminbtn;
    @FXML
    private Button userbtn;

    //Admin login
    @FXML
    private AnchorPane Admin_panel;
    @FXML
    private TextField aduname;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button alogin;
    @FXML
    private Button afwd;
    @FXML
    private Button areg;

    //User login
    @FXML
    private AnchorPane User_panel;
    @FXML
    private TextField Uuname;
    @FXML
    private PasswordField Upwd;
    @FXML
    private Button Ulogin;


    //Admin authorization
    @FXML
    private AnchorPane adminPin_panel;
    @FXML
    private PasswordField txtpin;
    @FXML
    private Button btnauth;


    //Admin register
    @FXML
    private AnchorPane adreg_panel;
    @FXML
    private TextField adreguname;
    @FXML
    private PasswordField adregpwd;
    @FXML
    private ComboBox<String> adregcom;
    @FXML
    private TextField adans;
    @FXML
    private Button adregbtn;
    @FXML
    private Button adlogbtn;


    //Admin forgot password verification
    @FXML
    private AnchorPane adminfpwd;
    @FXML
    private TextField adfpwdun;
    @FXML
    private ComboBox<String> adqus;
    @FXML
    private TextField ans;
    @FXML
    private Button adverifybtn;


    //Admin password configuration
    @FXML
    private PasswordField adnewpwd;
    @FXML
    private PasswordField adcpwd;
    @FXML
    private Button adupdate;


    @FXML
    public void controlPanel(ActionEvent event){
        if(event.getSource()==adminbtn){
            Admin_panel.setVisible(true);
            User_panel.setVisible(false);
            adminPin_panel.setVisible(false);
            adreg_panel.setVisible(false);

        }
        else if(event.getSource()==userbtn){
            User_panel.setVisible(true);
            Admin_panel.setVisible(false);
            adminPin_panel.setVisible(false);
            adreg_panel.setVisible(false);

        }
    }
    @FXML
    public void aloginOnAction(ActionEvent event) {
        connect=DatabaseConnection.ConnectionDB();

        String adun=aduname.getText();
        String apwd=passwordField.getText();

        if (adun.isEmpty() || apwd.isEmpty()) {
            showAlert("Please fill out all the fields...!");
        }
        else {
            try {
                String sql = "select userID,password from admin ";//where userID='"+adun+"' and password='"+apwd+"'";
                prepare = connect.prepareStatement(sql);
                result = prepare.executeQuery();

                if (result.next()) {
                    if (result.getString("userID").equals(adun) || result.getString("password").equals(apwd)) {
                        showAlert("Username or Password is incorrect. Please try again...");
                        aduname.clear();
                        passwordField.clear();
                    } else {
                        showAlert("You are logged in successfully....!");
                        try {
                            gotoMainFrame(event);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            catch(SQLException e){
                e.printStackTrace();
                System.out.println("An SQL error occurred. Please check the console for details.");
            }
        }
    }

    public void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void gotoMainFrame(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainFrame.fxml"));
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Scene mainFrame = new Scene(root);
            stage.setScene(mainFrame);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void UloginOnAction(ActionEvent event) {
        connect=DatabaseConnection.ConnectionDB();

        String userun=Uuname.getText();
        String userpwd=Upwd.getText();
        try {
            String sql = "select userID,password from staff where userID='"+userun+"' and password='"+userpwd+"'";
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                if (userun.isEmpty()){
                    if(userpwd.isEmpty()){
                        showAlert("Please fill out all the fields...!");
                    }
                }
                else {
                    showAlert("You are logged in successfully....!");
                    try {
                        gotoMainFrame(event);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            else {
                showAlert("Username or Password is incorrect. Please try again...");
                Uuname.setText(" ");
                Upwd.setText(" ");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("An SQL error occurred. Please check the console for details.");
        }
    }

    @FXML
    public void controlpanelreg(ActionEvent event){
        if(event.getSource()==areg){
            Admin_panel.setVisible(false);
            adminPin_panel.setVisible(true);
        }
        else{
            showAlert("Error...");
        }
    }

    //Admin authorization
    @FXML
    public void btnauthonAction(ActionEvent event){
        String pin="1234";
        String input_pin=txtpin.getText();
        if(input_pin.isEmpty()){
            showAlert("Please fill the fields...!");
        }
        else {
            if (input_pin.equals(pin)) {
                showAlert("Verification Success...Click To Continue...!");
                adreg_panel.setVisible(true);
            }
            else{
                showAlert("Verification UnSuccess...Cannot be register...!");
                txtpin.clear();
            }
        }
    }
    public void initialize() {
        // Initialize the ComboBox with a list of questions
        ObservableList<String> questions = FXCollections.observableArrayList(
                "What is your favorite color?",
                "What is your mother's maiden name?",
                "What is the name of your first pet?",
                "What is your favourite movie?"
        );

        adregcom.setItems(questions);
        adqus.setItems(questions);

    }

    //Admin registration
    @FXML
    public void adregbtnOnaction(ActionEvent event){
        connect=DatabaseConnection.ConnectionDB();

        String userID=adreguname.getText();
        String pwd=adregpwd.getText();
        String ans=adans.getText();
        try{
            if(userID.isEmpty()){
                if(pwd.isEmpty()){
                    if(ans.isEmpty()){
                        showAlert("Please fill out the fields...!");
                    }
                }
            }
            else{
                String sql1="select userID,password from admin"; //where userID='"+userID+"' AND password='"+pwd+"'";
                prepare = connect.prepareStatement(sql1);
                result = prepare.executeQuery();

                if(result.next()){
                    if (result.getString("userID").equals(userID)){
                        showAlert("Username is already exit...!");
                        adreguname.clear();
                        adregpwd.clear();
                        adans.clear();
                        return ;
                    }
                    else{
                        String sql2="Insert into admin(userID,password,answer) values('"+userID+"','"+pwd+"','"+ans+"')";
                        PreparedStatement preparedStatement = connect.prepareStatement(sql2);
                        //preparedStatement.execute();

                        int rowsAffected = preparedStatement.executeUpdate();

                        if (rowsAffected > 0) {
                            // Data was successfully inserted
                            showAlert("Registered successfully...Click to Log In!");
                            Admin_panel.setVisible(true);
                            adreg_panel.setVisible(false);
                            adminPin_panel.setVisible(false);

                        } else {
                            showAlert("Failed to register. Please check the input values and try again.");
                            adreguname.clear();
                            adregpwd.clear();
                            adans.clear();
                        }
                        preparedStatement.close();
                    }
                }
                connect.close();

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An SQL error occurred. Please check the console for details.");
        }
    }
    @FXML
    public void controlpanelfpwd(ActionEvent event){
        if(event.getSource()==afwd){
            Admin_panel.setVisible(false);
            adminfpwd.setVisible(true);
        }
    }

    //Verification
    @FXML
    public void adverifybtnOnAction(ActionEvent event){
        connect=DatabaseConnection.ConnectionDB();
        String un=adfpwdun.getText();
        String answer=ans.getText();

        try{
            String sql="select userID,answer from admin where userID='"+un+"' AND answer='"+answer+"'";
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if(un.isEmpty()){
                if(answer.isEmpty()){
                    showAlert("Please fill out the fields...!");
                }
            }
            else{
                if(result.next()){
                    showAlert("You are able to update your password...Click to continue...!");
                    adfpwdun.setDisable(true);
                    adqus.setDisable(true);
                    ans.setDisable(true);
                    adverifybtn.setDisable(true);
                    adnewpwd.setDisable(false);
                    adcpwd.setDisable(false);
                    adupdate.setDisable(false);
                }
                else{
                    showAlert("You are unable to update password. Please verify your userID and QA..!");
                    adfpwdun.clear();
                    ans.clear();
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An SQL error occurred. Please check the console for details.");
        }

    }

    //Password updation
    @FXML
    public void adupdatebtnOnAction(ActionEvent event){
        String npwd=adnewpwd.getText();
        String cpwd=adcpwd.getText();

        if(npwd.isEmpty()){
            if(cpwd.isEmpty()){
                showAlert("Please fill out the fields...!");
            }
        }
        else{
            if(npwd.equals(cpwd)){
                try {
                    String sql = "Update admin set password='" + cpwd + "' where userID='" + adfpwdun.getText() + "' AND answer='" + ans.getText() + "'";
                    PreparedStatement preparedStatement = connect.prepareStatement(sql);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        // Data was successfully inserted
                        showAlert("Password Updated Successfully...Click to Log In!");
                        Admin_panel.setVisible(true);
                        adminfpwd.setVisible(false);

                    }
                    else{
                        showAlert("Cannot be update the password...Try again!");
                        adnewpwd.clear();
                        adcpwd.clear();
                    }
                    preparedStatement.close();
                    connect.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                    System.out.println("An SQL error occurred. Please check the console for details.");
                }
            }
            else{
                showAlert("Passwords do not match...! ");
                adnewpwd.clear();
                adcpwd.clear();
            }
        }
    }


}








