package org.example.service;

import org.example.entity.Player;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import static org.example.service.TeamService.checkIfPlayerInTeam;


public class PlayerService {

    private static Set<Player> playerSet = new HashSet<>();

    private static int playerId = 1;

    public static Set<Player> getPlayerSet() {
        return playerSet;
    }

    public static void setPlayerSet(Set<Player> playerSet) {
        PlayerService.playerSet = playerSet;
    }

    public static int getPlayerId() {
        return playerId;
    }

    public static void setPlayerId(int playerId) {
        PlayerService.playerId = playerId;
    }

    public static void addPlayer() {
        Scanner input = new Scanner(System.in);
        String firstName;
        String lastName;
        String dateOfBirth;

        System.out.println("Enter Player details");
        System.out.println("Enter first name");
        firstName = input.nextLine();
        System.out.println("Enter last name");
        lastName = input.nextLine();
        System.out.println("Enter date of birth");
        dateOfBirth = input.nextLine();


        if (firstName.isEmpty() || lastName.isEmpty() || dateOfBirth.isEmpty()) {
            System.out.println("Invalid input");
            return;
        }
        firstName = firstName.toLowerCase();
        lastName = lastName.toLowerCase();
        firstName = (firstName.substring(0, 1).toUpperCase() + firstName.substring(1)).trim();
        lastName = (lastName.substring(0, 1).toUpperCase() + lastName.substring(1)).trim();

        if (checkIfPlayerExists(firstName + " " + lastName)) {
            System.out.println("Player already exists");
            return;
        }

        try {
            Player player = new Player.Builder()
                    .setId(playerId)
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setDateOfBirth(LocalDate.parse(dateOfBirth))
                    .build();
            playerId++;
            playerSet.add(player);
        } catch (Exception e) {
            System.out.println("Invalid input");
        }

    }

    public static void printAllPlayers() {
        System.out.println("Player details:");
        System.out.println("====================================");
        for (Player player : playerSet) {
            System.out.println(
                    "Player id: " + player.getId() + "\n" +
                            "Player full name: " + player.getFullName() + "\n" +
                            "Player date of birth: " + player.getDateOfBirth() + "\n" +
                            "------------------------------------"
            );
        }
        System.out.println("====================================");
    }

    public static void removePlayer() {
        System.out.println("Enter player id:");
        Scanner input = new Scanner(System.in);
        int id = Integer.parseInt(input.nextLine());
        try {
            Optional<Player> p = findPlayerById(id);
            if (p.isPresent()) {
                if(checkIfPlayerInTeam(p.get())){
                    System.out.println("Player cannot be removed as it is already in team");
                    return;
                }
                playerSet.remove(p.get());
                System.out.println("Player removed");
            } else {
                System.out.println("Player not found");
            }
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    public static Optional<Player> findPlayerById(int id) {
        for (Player player : playerSet) {
            if (player.getId() == id) {
                return Optional.of(player);
            }
        }
        return Optional.empty();
    }

    public static Boolean checkIfPlayerExists(String name) {
        for (Player player : playerSet) {
            if (player.getFullName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

}
