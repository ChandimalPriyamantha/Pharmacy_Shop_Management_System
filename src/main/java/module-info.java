module com.tech.pharmacy_shop_management_system {
    requires javafx.controls;
    requires javafx.fxml;
            
            requires com.dlsc.formsfx;
            requires net.synedra.validatorfx;
                requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.tech.pharmacy_shop_management_system to javafx.fxml;
    exports com.tech.pharmacy_shop_management_system;
}