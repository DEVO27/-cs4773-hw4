package application.view.Observers;

import application.model.Team;

public interface Observable {
    void addDisplay(IObserver iObserver);

    void Notify(Team team, int index);
}
