package java101.locations;

import java101.gameStream.player.Player;

import java.util.Scanner;

public abstract class Location {
    private Player player;
    private String name;
    public static Scanner sc = new Scanner(System.in);

    public Location(Player player, String name) {
        this.player = player;
        this.name = name;
    }

    public abstract boolean onLocation();
    public void playerStatus(){
        System.out.println("-----" + this.getPlayer().getPlayerName() + "-----" +
                "\nHp: " + this.getPlayer().getHp() +
                "\nWeapon: " + this.getPlayer().getWeapon().getName() +
                "\nDamage: " + this.getPlayer().getTotalDamage() +
                "\nArmor: " + this.getPlayer().getArmor().getName() +
                "\nDefence: " + this.getPlayer().getDefence() +
                "\nMoney: " + this.getPlayer().getMoney() +
                "\nAwards: " + this.getPlayer().getInventory().getAwards());
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
