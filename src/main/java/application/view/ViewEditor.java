package application.view;

import application.model.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class ViewEditor { /***
    @FXML
    private TextField myName;
    @FXML
    private TextField myScore;
    @FXML
    private TextField myDate;

    private Team team;
    private URL url;
    private ResourceBundle rb;

    public ViewEditor() {
        this.team = null;
    }

    public ViewEditor (Team team) {
        this.team = team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void updateTeam(ActionEvent actionEvent) {
        try {
            team.setTeamName(myName.getText());
            team.setTeamScore(Integer.parseInt(myScore.getText()));
            team.setCurrentDateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        } catch (NumberFormatException e) {
            System.out.println("Enter numbers only, please.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateWindow() {
        initialize(url, rb);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /***myName.setText(getTeam().getTeamName());
        myScore.setText(String.valueOf(getTeam().getTeamScore()));
        myDate.setText(getTeam().getCurrentDateTime());
        this.url = url;
        rb = resourceBundle;
        myName.setText(team.getTeamName());
        myScore.setText(String.valueOf(team.getTeamScore()));
        myDate.setText(team.getCurrentDateTime());
    }

    public Team getTeam() {
        return team;
    }  ***/
}
