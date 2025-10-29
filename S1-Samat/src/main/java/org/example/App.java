package org.example;

import org.example.service.ConfigService;
import org.example.service.PlayerService;
import org.example.service.TeamService;

import java.util.Scanner;


/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String s;
        do {
            System.out.println(
                    "1) Manage Players\n" +
                            "2) Manage Teams\n" +
                            "3) Configs\n" +
                            "3) exit");
            s = input.nextLine();
            switch (s) {
                case "1":
                    printPlayersManager();
                    break;
                case "2":
                    printTeamsManager();
                    break;
                case "3":
                    printConfigManager();
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Invalid input");
            }
        } while (!s.equals("exit"));

    }

    public static void printTeamsManager() {
        Scanner input = new Scanner(System.in);
        String s;
        System.out.println(
                "1) Add Teams\n" +
                        "2) Add Player to a Team\n" +
                        "3) Print all teams\n" +
                        "4) remove Player form a Team\n" +
                        "5) exit");
        s = input.nextLine();
        switch (s) {
            case "1":
                TeamService.addTeam();
                break;
            case "2":
                TeamService.addPlayerToTeam();
                break;
            case "3":
                TeamService.printAllTeams();
                break;
            case "4":
                TeamService.removePlayerFromTeam();
                break;
            case "5":
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    public static void printPlayersManager() {
        Scanner input = new Scanner(System.in);
        String s;
        System.out.println(
                "1) Add Player\n" +
                        "2) Print All Player\n" +
                        "3) Remove a Player\n" +
                        "4) exit");
        s = input.nextLine();
        switch (s) {
            case "1":
                PlayerService.addPlayer();
                break;
            case "2":
                PlayerService.printAllPlayers();
                break;
            case "3":
                PlayerService.removePlayer();
                break;
            case "4":
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    public static void printConfigManager() {
        Scanner input = new Scanner(System.in);
        String s;
        System.out.println(
                "1) Save\n" +
                        "2) Load Save\n" +
                        "3) exit");
        s = input.nextLine();
        switch (s) {
            case "1":
                ConfigService.save();
                break;
            case "2":
                ConfigService.load();
                break;
            case "3":
                break;
            default:
                System.out.println("Invalid input");
        }
    }


}
