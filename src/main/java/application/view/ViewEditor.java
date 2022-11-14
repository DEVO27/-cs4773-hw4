package application.view;

import application.ViewModel;
import application.model.Scoreboard;
import application.model.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class ViewEditor{
    @FXML
    private TextField myName;
    @FXML
    private TextField myScore;
    @FXML
    private TextField myDate;

    //private int index;
    private ViewModel viewModel;
    private Team team;
    private Scoreboard scoreboard;
    private int index;
    //private URL url;
    //private ResourceBundle rb;

    /*public ViewEditor() {
        this.team = null;
    }

    public ViewEditor (Team team) {
        this.team = team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }*/

    /*public void updateTeam(ActionEvent actionEvent) {
        try {
            team.setTeamName(myName.getText());
            team.setTeamScore(Integer.parseInt(myScore.getText()));
            team.setCurrentDateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            scoreBoard.updateTeam(this.team, index);
            viewModel.notify();
        } catch (NumberFormatException e) {
            System.out.println("Enter numbers only, please.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }*/


    public void displayValue(Team team, int index) {
        this.team = team;
        this.index = index;
        this.viewModel = viewModel;
        myName.setText(team.getTeamName());
        myScore.setText(String.valueOf(team.getTeamScore()));
        myDate.setText(team.getCurrentDateTime());
    }

    public void update() {
        try {
            team.setTeamName(myName.getText());
            team.setTeamScore(Integer.parseInt(myScore.getText()));
            team.setCurrentDateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            viewModel.save(team, index);  //this will work if it is passed by reference
            viewModel.notify();
            System.out.println("Got past the notify function");
        } catch (NumberFormatException e) {
            System.out.println("Enter numbers only, please.");
        } catch (Exception e) {
            System.out.println("Nawh, entered generic catch");
            System.out.println(e);
        }
    }

    /*@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*
        System.out.println("Init is fine");
        System.out.println(team.getTeamName()); //remove me
        myName.setText(team.getTeamName());
        myScore.setText(String.valueOf(getTeam().getTeamScore()));
        myDate.setText(getTeam().getCurrentDateTime());
        this.url = url;
        rb = resourceBundle;
        myName.setText(team.getTeamName());
        myScore.setText(String.valueOf(team.getTeamScore()));
        myDate.setText(team.getCurrentDateTime());
    }*/

    /*public Team getTeam() {
        return team;
    }*/
}
