module com.example.flatmate {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.flatmate to javafx.fxml;
    exports com.example.flatmate;
}