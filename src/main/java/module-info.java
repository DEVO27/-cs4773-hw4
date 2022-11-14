module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens application to javafx.fxml;
    opens application.view to javafx.fxml;
    //exports application.view to javafx.fxml;
    exports application;
}