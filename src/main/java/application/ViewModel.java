package application;

import application.model.Scoreboard;
import application.model.Team;
import application.view.Observers.IObserver;
import application.view.Observers.Observable;
import application.view.ViewEditor;
import application.view.ViewScoreboard;
import application.view.facade.Facade;
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
import java.security.cert.CertificateFactorySpi;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * JavaFX App
 */
//public class ViewModel extends Application implements Initializable, Observable {
public class ViewModel implements Observable {
    private Facade facade = new Facade();
    private static Scene scene;
    private final Scoreboard scoreBoard = new Scoreboard();
    private final List<IObserver> activeWindows = new ArrayList<>();
    //private final ViewScoreboard viewScoreboard = new ViewScoreboard();
    @FXML
    private ListView<String> myListView = new ListView<>();

    /*@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myListView.getItems().setAll(scoreBoard.ToString());
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(new FXMLLoader(ViewModel.class.getResource("Scoreboard.fxml")).load());
        stage.setTitle("ScoreBoard");
        stage.setScene(scene);
        stage.show();
    }*/

    @FXML
    public void loadEditor() throws IOException {
        int index = myListView.getSelectionModel().getSelectedIndex();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Editor.fxml"));
        Parent root = loader.load();
        ViewEditor editor = loader.getController();
        addDisplay(editor);

        editor.displayValues(scoreBoard.getTeam(index), index);
        editor.getViewModel().activeWindows.addAll(getActiveWindows());
        editor.getViewModel().scoreBoard.setTeams(scoreBoard.getTeams());

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Editor");
        stage.setScene(scene);
        stage.show();
    }

    public void saveContent(Team team, int index, ViewModel viewModel) {
        scoreBoard.getTeams().set(index, team);
        Notify(team, index);
    }

    @Override
    public void addDisplay(IObserver iObserver) {
        activeWindows.add(iObserver);
    }

    @Override
    public void Notify(Team team, int index) {
        for (IObserver iObserver : activeWindows) {
            iObserver.displayValues(team, index);
        }
        System.out.println("The new scoreboard: ");
        for (Team team1 : scoreBoard.getTeams()) {
            System.out.println(team1);
        }

        //initialize(null, null);
    }

    public List<IObserver> getActiveWindows() {
        return activeWindows;
    }
}