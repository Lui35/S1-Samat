package org.example.Service;

import org.example.Entity.Player;

import java.time.LocalDate;
import java.util.Scanner;

import static org.example.App.playerSet;


public class PlayerService {

    private static int playerId = 1;

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
}
