package application.ViewModel;

import application.model.Scoreboard;
import application.model.Team;
import application.view.Observers.IObserver;
import application.view.Observers.Observable;
import application.view.ViewEditor;
import application.view.facade.Facade;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * JavaFX App
 */
public class ViewModel implements Observable {
    private final Facade facade = new Facade();
    private static Scene scene;
    private final Scoreboard scoreBoard = new Scoreboard();
    private final List<IObserver> activeWindows = new ArrayList<>();
    @FXML
    private ListView<String> myListView = new ListView<>();

    /**
     * Creates new Editor window and saves object to activeWindow list
     * @throws IOException
     */
    @FXML
    public void displayEditor() throws IOException {
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

    /**
     * Saves and sanitizes object attributes
     * @param team
     * @param index
     * @param viewModel
     */
    public void saveContent(Team team, int index, ViewModel viewModel) {
        String pattern = "^[a-zA-z0-9 ]{5,50}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(team.getTeamName());
        if (m.find() && team.getTeamScore() >= 0 && team.getTeamScore() <= 2000) {
            scoreBoard.getTeams().set(index, team);
            displayValues();
            Notify(team, index);
        }
    }

    @Override
    public void addDisplay(IObserver iObserver) {
        activeWindows.add(iObserver);
    }

    /**
     * Updates active Editor windows values
     * @param team
     * @param index
     */
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