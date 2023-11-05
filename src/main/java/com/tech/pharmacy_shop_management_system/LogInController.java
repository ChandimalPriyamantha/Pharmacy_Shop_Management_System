package com.tech.pharmacy_shop_management_system;

import Connection.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;


public class LogInController {

    private  Connection connect;

    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    @FXML
    private AnchorPane title_button_tab;

    @FXML
    private Button adminbtn;

    @FXML
    private Button userbtn;

    @FXML
    private AnchorPane Admin_panel;
    @FXML
    private TextField aduname;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button alogin;
    @FXML
    private Button afpwd;
    @FXML
    private Button areg;
    @FXML
    private AnchorPane User_panel;
    @FXML
    private TextField Uuname;
    @FXML
    private PasswordField Upwd;
    @FXML
    private Button Ulogin;
    @FXML
    private Button Ufpwd;
    @FXML
    private Button Ureg;

    @FXML
    private AnchorPane adreg_panel;
    @FXML
    private TextField adreguname;
    @FXML
    private PasswordField adregpwd;
    @FXML
    private ComboBox adregcom;
    @FXML
    private TextField adans;
    @FXML
    private Button adregbtn;
    @FXML
    private Button adlogbtn;
    @FXML
    private AnchorPane ureg_panel;
    @FXML
    private TextField streguname;
    @FXML
    private PasswordField stregpwd;
    @FXML
    private ComboBox stregcom;
    @FXML
    private TextField stans;
    @FXML
    private Button stregbtn;
    @FXML
    private Button stlogbtn;

    @FXML
    public void controlPanel(ActionEvent event){
        if(event.getSource()==adminbtn){
            Admin_panel.setVisible(true);
            User_panel.setVisible(false);
        }
        else if(event.getSource()==userbtn){
            User_panel.setVisible(true);
            Admin_panel.setVisible(false);
        }
    }
    @FXML
    public void aloginOnAction(ActionEvent event) {
        connect=DatabaseConnection.ConnectionDB();

        String adun=aduname.getText();
        //PasswordField passwordField=new PasswordField();
        String apwd=passwordField.getText();
        try {
            String sql = "select userID,password from admin where userID='"+adun+"' and password='"+apwd+"'";
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                if (adun.isEmpty() || apwd.isEmpty()) {
                   showAlert("Please fill out all the fields...!");
                }
                else {
                    showAlert("You are logged in successfully....!");
                    try {
                        gotoMainFrame(event);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                showAlert("Username or Password is incorrect. Please try again...");
                aduname.setText(" ");
                passwordField.setText(" ");
            }
         }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("An SQL error occurred. Please check the console for details.");
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
                if (userun.isEmpty() || userpwd.isEmpty()) {
                    showAlert("Please fill out all the fields...!");
                }
                else {
                    showAlert("You are logged in successfully....!");
                    try {
                        gotoMainFrame(event);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
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
    public void controlpanel(ActionEvent event){
        if(event.getSource()==areg){
            Admin_panel.setVisible(false);

        }
    }


}








