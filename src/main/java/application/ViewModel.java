package application;

import application.model.Scoreboard;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * JavaFX App
 */
public class ViewModel extends Application implements Initializable {

    private static Scene scene;
    private final Scoreboard scoreBoard = new Scoreboard();
    @FXML
    private ListView<String> myListView;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(new FXMLLoader(ViewModel.class.getResource("Scoreboard.fxml")).load());
        stage.setTitle("ScoreBoard");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myListView.getItems().addAll(scoreBoard.ToString());
    }

    public static void main(String[] args) {
        launch();
    }

}