module com.tech.pharmacy_shop_management_system {
    requires javafx.controls;
    requires javafx.fxml;
            
            requires com.dlsc.formsfx;
            requires net.synedra.validatorfx;
                requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires javafx.web;

    opens com.tech.pharmacy_shop_management_system to javafx.fxml;
    exports com.tech.pharmacy_shop_management_system;
    exports RemortCustomer;
    opens RemortCustomer to javafx.fxml;
    exports SalesTransaction;
    opens SalesTransaction to javafx.fxml;
    exports User;
    opens User to javafx.fxml;
}