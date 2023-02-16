package java101.gameStream;

import java101.gameStream.player.Player;
import java101.locations.Location;
import java101.locations.battleLocations.Cave;
import java101.locations.battleLocations.Forest;
import java101.locations.battleLocations.River;
import java101.locations.normalLocations.SafeHouse;
import java101.locations.normalLocations.Shop;

import java.util.Scanner;

public class Game {
    private Scanner sc = new Scanner(System.in);
    public void start(){
        System.out.println("Welcome!");
        System.out.print("Enter your name: ");
        //String playerName = scanner.nextLine();
        Player player = new Player(sc.nextLine()); //System.in
        System.out.println("Welcome, " + player.getPlayerName() + ".");
        System.out.println("Welcome to the real world.");
        player.selectCharacter();

        Location location = null;
        while (true){
            player.printPlayerInfo();
            System.out.println();
            System.out.println("Locations " +
                    "\n1- Safehouse --> Nothing to fear. " +
                    "\n2- Shop --> All for sale." +
                    "\n3- Cave --> <Food>" +
                    "\n4- Forest --> <Firewood>" +
                    "\n5- River --> <Water>" +
                    "\n0- Exit game.");
            System.out.print("Enter the location that you want to go: ");
            int locationSelection = sc.nextInt();
            sc.nextLine();
            location = switch (locationSelection) {  // USEFUL
                case 0 -> null;
                case 1 ->  new SafeHouse(player);
                case 2 ->  new Shop(player);
                case 3 ->  new Cave(player);
                case 4 ->  new Forest(player);
                case 5 ->  new River(player);
                default -> new SafeHouse(player);
            };
            if (location == null){
                System.out.println("Coward!");
                break;
            }
            if (!location.onLocation()){
                System.out.println("Game Over!");
                break;
            }
        }

    }

}
