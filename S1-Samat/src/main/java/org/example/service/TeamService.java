package org.example.service;

import org.example.entity.Player;
import org.example.entity.Team;

import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class TeamService {

    private static Set<Team> teamsSet = new HashSet<>();

    public static Set<Team> getTeamsSet() {
        return teamsSet;
    }

    public static void setTeamsSet(Set<Team> teamsSet) {
        TeamService.teamsSet = teamsSet;
    }

    public static void addTeam() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter team name:");
        String teamName = sc.nextLine().trim();

        System.out.println("Enter City:");
        String city = sc.nextLine().trim();

        if (teamName.isEmpty() || city.isEmpty()) {
            System.out.println("Invalid Input");
            return;
        }

        if (checkIfTeamExists(teamName)) {
            System.out.println("Team already exists");
            return;
        }

        Team team = new Team.Builder()
                .setTeamName(teamName)
                .setCity(city)
                .build();

        teamsSet.add(team);
    }

    public static void addPlayerToTeam() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter team name: ");
        String teamName = sc.nextLine().trim();
        System.out.println("Enter Player id: ");
        int playerId = sc.nextInt();


        Optional<Player> p = PlayerService.findPlayerById(playerId);
        if (!p.isPresent()) {
            System.out.println("Player not found");
            return;
        }
        if (checkIfPlayerInTeam(p.get())) {
            System.out.println("Player already exists in a Team");
            return;
        }

        if (!checkIfTeamExists(teamName)) {
            System.out.println("Team doesnt exists");
            return;
        }

        for (Team team : teamsSet) {
            if (team.getTeamName().equals(teamName)) {
                team.getPlayers().add(p.get());
                System.out.println(p.get().getFullName() + " has been added to the Team");
                break;
            }
        }

    }

    public static void removePlayerFromTeam() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter team name: ");
        String teamName = sc.nextLine().trim();
        System.out.println("Enter Player id: ");
        int playerId = sc.nextInt();
        Optional<Player> p = PlayerService.findPlayerById(playerId);

        if (!p.isPresent()) {
            System.out.println("Player not found");
            return;
        }

        if (checkIfPlayerInTeam(p.get())) {
            for (Team team : teamsSet) {
                if (team.getTeamName().equalsIgnoreCase(teamName)) {
                    team.getPlayers().remove(p.get());
                    System.out.println(p.get().getFullName() + " has been removed from the Team");
                    break;
                }
            }
        }

    }


    public static boolean checkIfTeamExists(String teamName) {
        for (Team team : teamsSet) {
            if (team.getTeamName().equalsIgnoreCase(teamName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkIfPlayerInTeam(Player player) {
        for (Team team : teamsSet) {
            if (team.getPlayers().contains(player)) {
                return true;
            }
        }
        return false;
    }

    public static void printAllTeams() {
        System.out.println("Player details:");
        System.out.println("====================================");
        for (Team team : teamsSet) {
            System.out.println(
                    "Team name: " + team.getTeamName() +
                            "\nCity: " + team.getCity() +
                            "\nPlayers: "
            );
            for (Player player : team.getPlayers()) {
                System.out.println("Player name: " + player.getFullName());
            }
            System.out.println("----------------------------------");
        }
        System.out.println("====================================");
    }


}
