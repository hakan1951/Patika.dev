package java101.locations;

import java101.gameStream.player.Player;

import java.util.Scanner;

public abstract class Location {
    private Player player;
    private String name;
    public static Scanner sc = new Scanner(System.in);
    //TODO - Monster List.
    //TODO - Loot List.

    public Location(Player player, String name) {
        this.player = player;
    }
    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
