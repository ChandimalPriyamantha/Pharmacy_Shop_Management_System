package com.tech.pharmacy_shop_management_system;

import Connection.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    private Label Uuname;
    @FXML
    private Label Upwd;
    @FXML
    private Button Ulogin;
    @FXML
    private Button Ufpwd;
    @FXML
    private Button Ureg;

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


}








