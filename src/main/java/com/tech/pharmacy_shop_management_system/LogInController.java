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
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

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
    private PasswordField adpwd;
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
    protected void aloginOnAction(ActionEvent event) {
      //  Stage stage=
        connect=DatabaseConnection.ConnectionDB();

        String adun=aduname.getText();
        PasswordField password=new PasswordField();
        String apwd=password.getText();
        try {
            if (adun.isEmpty() || apwd.isEmpty()) {
                System.out.println("Please fill out all the fields...!");
            }
            else {
                String sql = "select userID,password from admin where userID=? and password=?";
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, adun);
                prepare.setString(2, apwd);
                result = prepare.executeQuery();


                if (result.next()) {
                    System.out.println("You are logged in successfully....!");
                } else {
                        System.out.println("Username or Password is incorrect. Please try again...");
                        aduname.setText(" ");
                        adpwd.setText(" ");
                    }
                }

            }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("An SQL error occurred. Please check the console for details.");
        }
        }
}








