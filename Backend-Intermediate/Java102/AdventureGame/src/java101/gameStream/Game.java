package java101.gameStream;

import java101.gameStream.player.Player;
import java101.locations.Location;
import java101.locations.battleLocations.Cave;
import java101.locations.battleLocations.Forest;
import java101.locations.battleLocations.Mine;
import java101.locations.battleLocations.River;
import java101.locations.normalLocations.SafeHouse;
import java101.locations.normalLocations.Shop;

import java.util.Scanner;

public class Game {
    private final Scanner sc = new Scanner(System.in);
    public void start(){
        System.out.print("Welcome!\nEnter your name: ");
        Player player = new Player(sc.nextLine());
        System.out.println("Welcome, " + player.getPlayerName() + ".\nWelcome to the real world.");
        player.selectCharacter();

        Location location;
        while (true) {
                player.printPlayerInfo();
                System.out.println();
                System.out.println("""
                        Locations\s
                        1- Safe house --> Nothing to fear.\s
                        2- Shop --> All for sale.
                        3- Cave --> <Food>
                        4- Forest --> <Firewood>
                        5- River --> <Water>
                        6- Mine --> <Surprise>
                        0- Exit game.""");
                System.out.print("Enter the location that you want to go: ");
                int locationSelection = sc.nextInt();
                sc.nextLine();
                location = switch (locationSelection) {
                    case 0 -> null;
                    case 1 -> new SafeHouse(player);
                    case 2 -> new Shop(player);
                    case 3 -> new Cave(player);
                    case 4 -> new Forest(player);
                    case 5 -> new River(player);
                    case 6 -> new Mine(player);
                    default -> new SafeHouse(player);
                };
                if (location == null) {
                    System.out.println("Coward!");
                    sc.close();
                    break;
                }
                if (!location.onLocation()) {
                    if (!location.getClass().getSimpleName().equals("SafeHouse")) {
                        System.out.println("Game Over.");
                    }
                    sc.close();
                    break;
                }

            }
    }

}
