package application.view;

import application.model.Team;
import application.view.Observers.IObserver;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
public class ViewScoreboard implements IObserver {
    @FXML
    private final ListView<String> myListView = new ListView<>();

    @Override
    public void displayValues(Team team, int index) {}

    /**
     * Print the list of teams in scoreboard
     * @param scoreboard
     */
    @Override
    public void displayValues(String[] scoreboard) {
        myListView.getItems().addAll(scoreboard);
    }
}
