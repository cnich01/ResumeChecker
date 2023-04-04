module com.example.resumechecker {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.resumechecker to javafx.fxml;
    exports com.example.resumechecker;
}