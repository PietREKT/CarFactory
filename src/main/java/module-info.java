module com.example.carfactory {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.carfactory to javafx.fxml;
    exports com.example.carfactory;
}