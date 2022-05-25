module com.example.scratt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.scratt to javafx.fxml;
    exports com.example.scratt;
}