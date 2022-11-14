package application.view.Observers;

import application.model.Team;

public interface IObserver {
    void displayValues(Team team, int index);

    void displayValues(String[] scoreboard);
}
