package org.example.entity;

import java.io.*;
import java.util.Set;

public class Config implements Serializable {

    private final Set<Player> playerSet;
    private final Set<Team> teamsSet;
    private final int playerIdCounter;

    public Config(Set<Player> playerSet, Set<Team> teamsSet, int playerIdCounter) {
        this.playerSet = playerSet;
        this.teamsSet = teamsSet;
        this.playerIdCounter = playerIdCounter;
    }

    public Set<Player> getPlayerSet() {
        return playerSet;
    }

    public Set<Team> getTeamsSet() {
        return teamsSet;
    }

    public int getPlayerIdCounter() {
        return playerIdCounter;
    }


}
