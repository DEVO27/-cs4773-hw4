module org.example {
    requires javafx.controls;
    requires javafx.fxml;

    opens application to javafx.fxml;
    opens application.view.facade to javafx.fxml;
    opens application.ViewModel to javafx.fxml;
    opens application.view to javafx.fxml;
    exports application.view to javafx.fxml;
    exports application.view.facade;
    exports application.ViewModel to javafx.fxml;
}