package application.model;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard {
    private List<Team> teams = new ArrayList<>();

    public String[] ToString() {
        String[] strings = new String[teams.size()];
        int index = 0;
        for (Team team : teams) {
            strings[index++] = String.valueOf(team);
        }
        return strings;
    }

    private void generateTeams() {
        for (int i = 0; i < 5; i++) {
            teams.add(new Team());
        }
    }

    public Team getTeam(int index) throws IndexOutOfBoundsException {
        return getTeams().get(index);
    }

    public List<Team> getTeams() {
        return teams;
    }


    public Scoreboard() {
        generateTeams();
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
