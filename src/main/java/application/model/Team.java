package application.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Teams {
    private String currentDateTime;
    private String teamName;
    private int teamScore;

    public Teams() {
        this.currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.teamName = "No name provided";
        this.teamScore = 0;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(int teamScore) {
        this.teamScore = teamScore;
    }

    public String getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(String currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    @Override
    public String toString() {
        return "%s \t\t %s".formatted(getTeamName(), getTeamScore());
    }
}
