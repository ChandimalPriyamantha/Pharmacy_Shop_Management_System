package Authourization;

import Connection.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private Label aduname;
    @FXML
    private Label adpwd;
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
        String apwd=adpwd.getText();
        try {
            if (adun == " " || apwd == " ") {
                System.out.println("Please fill out all the fields...!");
            }
            else {
                String sql = "select userID password form admin";
                prepare = connect.prepareStatement(sql);
                result = prepare.executeQuery();

                while (result.next()) {
                    String userID = result.getString(2);
                    String pwd = result.getString(8);
                    if (adun == userID && apwd == pwd) {
                        System.out.println("You are logged in successfully....!");
                    } else {
                        System.out.println("Username or Password is incorrect. Please try again...");
                        aduname.setText(" ");
                        adpwd.setText(" ");
                    }
                }

            }
        }
        catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
}








