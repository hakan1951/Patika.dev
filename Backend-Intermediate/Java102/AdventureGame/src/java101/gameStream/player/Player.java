package java101.gameStream.player;

import java101.characters.Archer;
import java101.characters.Character;
import java101.characters.Knight;
import java101.characters.Samurai;
import java101.items.armors.Armor;
import java101.items.weapons.Weapon;

import java.util.Scanner;

public class Player {
    /** damage, hp, money -> Character **/
    private int damage;
    private int defence;
    private int hp;
    private int defaultHp;
    private int money;
    private String characterName;
    private String playerName;
    private Inventory inventory;
    private final Scanner sc = new Scanner(System.in);

    public Player(String playerName) {
        this.playerName = playerName;
        this.inventory = new Inventory();
        this.defaultHp = hp;
    }

    public void selectCharacter(){
        //Characters.
        Character[] characterList = { new Samurai(), new Archer(),  new Knight()};
        System.out.println("---------------------------------------------------");
        System.out.println("Characters: ");
        for(Character c : characterList){
            System.out.println("Id:" + c.getId() +
                    "\tCharacter:" + c.getName() +
                    "\t Damage: " + c.getDamage() +
                    "\t Hp: " + c.getHp() +
                    "\t Money: " + c.getMoney());
        }
        System.out.println("---------------------------------------------------");

        System.out.print("Select your character id(1-2-3): ");
        int charSelection = sc.nextInt();
        System.out.println("---------------------------------------------------");
        switch (charSelection) {
            case 1 -> initializePlayer(new Samurai());
            case 2 -> initializePlayer(new Archer());
            case 3 -> initializePlayer(new Knight());
            default -> initializePlayer(new Samurai());
        }
    }
    public void initializePlayer(Character character){
        this.setDamage(character.getDamage());
        this.setHp(character.getHp());
        this.setDefaultHp(character.getHp());
        this.setMoney(character.getMoney());
        this.setCharacterName(character.getName());
    }
    public void printPlayerInfo(){
        System.out.println("Weapon: " + this.getInventory().getWeapon().getName() +
                ",\tArmor: " + this.getInventory().getArmor().getName() +
                ",\tDamage: " + this.getTotalDamage() +
                ",\tDefence: " + this.getDefence() +
                ",\tHp: " + this.getHp() +
                ",\tMoney: " + this.getMoney());
    }
    public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }
    public Armor getArmor(){
        return this.getInventory().getArmor();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getTotalDefence() {
        return damage + this.getInventory().getArmor().getDefence();
    }
    public int getDefence() {
        return defence + this.getInventory().getArmor().getDefence();
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp < 0){
            hp = 0;
        }
        this.hp = hp;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getDefaultHp() {
        return defaultHp;
    }

    public void setDefaultHp(int defaultHp) {
        this.defaultHp = defaultHp;
    }
}
