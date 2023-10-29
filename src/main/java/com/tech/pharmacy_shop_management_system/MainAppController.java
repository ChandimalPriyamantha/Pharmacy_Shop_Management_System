package com.tech.pharmacy_shop_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MainAppController {
    @FXML
    private Button inrbtn;

    @FXML
    private AnchorPane inventoryAP;

    @FXML
    private AnchorPane reportAP;
        public void inventoryAndReport(ActionEvent event) throws SQLException {
            if (event.getSource() == inrbtn){
                inventoryAP.setVisible(true);
            }
        }


    }


