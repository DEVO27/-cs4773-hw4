package application;

import application.model.Scoreboard;
import application.view.ViewEditor;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * JavaFX App
 */
public class ViewModel extends Application implements Initializable {

    private static Scene scene;
    private final Scoreboard scoreBoard = new Scoreboard();
    private List<ViewEditor> activeWindows = new ArrayList<>();
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

    public void loadEditor() throws IOException {
<<<<<<< HEAD
        int index = myListView.getSelectionModel().getSelectedIndex();
        FXMLLoader loader = new FXMLLoader(ViewModel.class.getResource("Editor.fxml"));
        Parent root = (Parent) loader.load();
=======
        //int index = myListView.getSelectionModel().getSelectedIndex();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Editor.fxml"));
        Parent root = loader.load();
        //ViewEditor con = loader.getController();
        //con.setTeam(scoreBoard.getTeam(index));
        //activeWindows.add(con);
>>>>>>> d5869bce97553941bf8d7f7e1d61e8812abefa47
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Editor");
        stage.show();
<<<<<<< HEAD


        /*
        ViewEditor con = loader.getController();
        activeWindows.add(con);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Editor");
        stage.show(); */
=======
>>>>>>> d5869bce97553941bf8d7f7e1d61e8812abefa47
    }

    public static void main(String[] args) {
        launch();
    }
}