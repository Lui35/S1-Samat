package org.example.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Team implements Serializable {
    private String teamName;
    private ArrayList<Player> players;
    private String city;

    public Team(String teamName, String city) {
        this.teamName = teamName;
        this.players = new ArrayList<>();
        this.city = city;
    }

    public String getTeamName() {
        return teamName;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public String getCity() {
        return city;
    }

    public static class Builder {
        private String teamName;
        private String city;


        public Builder setTeamName(String teamName) {
            this.teamName = teamName;
            return this;
        }


        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Team build() {
            return new Team(teamName, city);
        }
    }
}
