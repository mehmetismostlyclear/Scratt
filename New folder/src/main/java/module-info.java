module com.example.scratt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.scratt to javafx.fxml;
    opens com.example.scratt.Controller to javafx.fxml;
    exports com.example.scratt;
    exports com.example.scratt.Controller;
}