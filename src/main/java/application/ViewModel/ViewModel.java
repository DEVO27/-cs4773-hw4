package application.ViewModel;

import application.model.Scoreboard;
import application.model.Team;
import application.view.Observers.IObserver;
import application.view.Observers.Observable;
import application.view.ViewEditor;
import application.view.facade.Facade;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX App
 */
public class ViewModel implements Observable {
    private Facade facade = new Facade();
    private static Scene scene;
    private final Scoreboard scoreBoard = new Scoreboard();
    private final List<IObserver> activeWindows = new ArrayList<>();
    //private final ViewScoreboard viewScoreboard = new ViewScoreboard();
    @FXML
    private ListView<String> myListView = new ListView<>();

    @FXML
    public void loadEditor() throws IOException {
        int index = myListView.getSelectionModel().getSelectedIndex();
        facade.setName("Editor.fxml");
        ViewEditor editor = facade.loadEditor();
        addDisplay(editor);
        editor.setViewModel(this);
        editor.setIndex(index);

        editor.displayValues(scoreBoard.getTeam(index), index);
        editor.getViewModel().activeWindows.addAll(getActiveWindows());
        editor.getViewModel().scoreBoard.setTeams(scoreBoard.getTeams());
        facade.setName("");
    }

    public void saveContent(Team team, int index, ViewModel viewModel) {
        scoreBoard.getTeams().set(index, team);
        displayValues();
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
    }

    public List<IObserver> getActiveWindows() {
        return activeWindows;
    }

    public void displayValues() {
        myListView.getItems().setAll(scoreBoard.ToString());
    }
}