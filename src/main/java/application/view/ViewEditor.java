package application.view;

import application.ViewModel.ViewModel;
import application.model.Team;
import application.view.Observers.IObserver;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ViewEditor implements IObserver {
    @FXML
    private TextField myName;
    @FXML
    private TextField myScore;
    @FXML
    private TextField myDate;

    private ViewModel viewModel;
    private int index;

    @Override
    public void displayValues(Team team, int index) {
        if (this.index == index) {
            this.myName.setText(team.getTeamName());
            this.myScore.setText(String.valueOf(team.getTeamScore()));
            this.myDate.setText(team.getCurrentDateTime());
            myDate.setEditable(false);
            //this.index = index;
        }
    }

    @Override
    public void displayValues(String[] scoreboard) {

    }

    public void saveValues() {
        Team team = new Team();
        team.setTeamName(myName.getText());
        team.setTeamScore(Integer.parseInt(myScore.getText()));
        viewModel.saveContent(team, index, getViewModel());
    }

    public ViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public TextField getMyName() {
        return myName;
    }

    public void setMyName(TextField myName) {
        this.myName = myName;
    }

    public TextField getMyScore() {
        return myScore;
    }

    public void setMyScore(TextField myScore) {
        this.myScore = myScore;
    }

    public TextField getMyDate() {
        return myDate;
    }

    public void setMyDate(TextField myDate) {
        this.myDate = myDate;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
