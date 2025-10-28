package org.example;

import org.example.Entity.Player;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static org.example.Service.PlayerService.addPlayer;
import static org.example.Service.PlayerService.printAllPlayers;

/**
 * Hello world!
 *
 */
public class App 
{
    public static Set<Player> playerSet =  new HashSet<>();

    public static void main( String[] args )
    {

        Scanner input = new Scanner(System.in);
        String s;
        do {
            System.out.println(
                    "1) Add Player \n" +
                            "2) print All players\n" +
                            "3) exit" );
            s = input.nextLine();
            switch (s){
                case "1":
                    addPlayer();
                    break;
                case "2":
                    printAllPlayers();
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }while (!s.equals("exit"));


    }
}
