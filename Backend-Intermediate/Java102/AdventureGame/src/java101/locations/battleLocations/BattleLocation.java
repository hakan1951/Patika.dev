package java101.locations.battleLocations;

import java101.gameStream.player.Player;
import java101.items.armors.HeavyArmor;
import java101.items.armors.LightArmor;
import java101.items.armors.NormalArmor;
import java101.items.awards.Award;
import java101.items.weapons.Pistol;
import java101.items.weapons.Rifle;
import java101.items.weapons.Sword;
import java101.locations.Location;
import java101.obstacle.Obstacle;

import java.util.Random;

public abstract class BattleLocation extends Location {
    private final Obstacle obstacle;
    private final Award award;
    private final int minObstacle;
    private final int maxObstacle;
    public BattleLocation(Player player, String name, Obstacle obstacle, Award award, int minObstacle, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.minObstacle = minObstacle;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obstacleNumber = this.randomObstacleNumber(minObstacle, maxObstacle);
        printLocationInfo(obstacleNumber);
        String selection = (sc.nextLine()).toUpperCase();
        if (selection.equals("F") && fight(obstacleNumber)){
            printLocationResult();
                return true;
        }
        if (this.getPlayer().getHp() <= 0){
            System.out.println("You are dead!");
            return false;
        }
        return true;
    }

    public boolean fight(int obstacleNumber) {
        for (int i = 1; i <= obstacleNumber; i++){
            boolean first = isFirst();
            bringNextObstacle();
            playerStatusInBattle();
            obstacleStatus(i);
            while (this.getPlayer().getHp() > 0 && this.getObstacle().getHp() > 0){
                System.out.print("Run or Fight. (R/F): ");
                String selection = sc.nextLine().toUpperCase();
                if (selection.equals("F")){
                    if (first){
                        playerHit();
                        obstacleHit();
                    }else{
                        obstacleHit();
                        playerHit();
                    }
                }else { //Run
                    return false;
                }
                if (this.getPlayer().getHp() <= 0){
                    return false;
                }
            }
            printRoundResult();
        }
        return true;
    }
    public void printLocationResult(){
        System.out.println(this.getName() + " is completed.");
        System.out.format("You got %s.\n", this.getAward().getName());
        this.getPlayer().getInventory().addAward(award);
    }
    public void printRoundResult(){
        if (this.getObstacle().getHp() < this.getPlayer().getHp()){
            System.out.println(this.getObstacle().getName() + " is fainted.");
            this.getPlayer().addMoney(getObstacle().getMoneyAward());
            if (this.getObstacle().getMoneyAward() > 0){
                System.out.println("You got: " + this.getObstacle().getMoneyAward());
            }
            if (this.getObstacle().getRandomAward() != null){
                System.out.println("You got extra: " + this.getObstacle().getRandomAward());
                randomAwardToInventory(this.getObstacle().getRandomAward());
            }
        }
    }
    public void randomAwardToInventory(String awardName){
        switch (awardName){
            case "Pistol" -> this.getPlayer().getInventory().setWeapon(new Pistol());
            case "Sword" ->this.getPlayer().getInventory().setWeapon(new Sword());
            case "Rifle" ->this.getPlayer().getInventory().setWeapon(new Rifle());
            case "Light Armor" ->this.getPlayer().getInventory().setArmor(new LightArmor());
            case "Normal Armor" ->this.getPlayer().getInventory().setArmor(new NormalArmor());
            case "Heavy Armor" ->this.getPlayer().getInventory().setArmor(new HeavyArmor());
            case "1 Money" ->this.getPlayer().addMoney(1);
            case "5 Money" ->this.getPlayer().addMoney(5);
            case "10 Money" ->this.getPlayer().addMoney(10);
            default ->System.out.println("Problem in random award.");
        }
    }
    public int randomObstacleNumber(int start, int maxObstacle){
        Random r = new Random();
        return r.nextInt(maxObstacle - start + 1) + start; // (0,1,2) -> (1,2,3)
    }
    public void bringNextObstacle(){
        this.getObstacle().setHp(this.getObstacle().getDefaultHp());
    }
    public void printLocationInfo(int obstacleNumber){
        System.out.format("You are at the %s.", this.getName());
        if (obstacleNumber == 1){
            System.out.format("\nThere is a %s in the %s.\n", this.getObstacle().getName(), this.getName());
        }else {
            System.out.format("\nThere are %d %ss in the %s.\n", obstacleNumber, this.getObstacle().getName(), this.getName());
        }
        System.out.print("Run or Fight? (R/F) : ");
    }
    public void playerHit(){
        System.out.println("--Hit!");
        this.getObstacle().setHp(this.obstacle.getHp()-this.getPlayer().getTotalDamage());
        afterHit();
    }
    public void obstacleHit(){
        if (this.getObstacle().getHp() > 0){
            System.out.println("----------");
            System.out.format("--%s is attacking!\n", this.getObstacle().getName());
            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getDefence();
            if (obstacleDamage < 0){
                obstacleDamage = 0;
            }
            this.getPlayer().setHp(this.getPlayer().getHp()-obstacleDamage);
            if (!(this.getPlayer().getHp() <= 0)){
                afterHit();
            }
        }
    }
    public boolean isFirst(){
        Random rnd = new Random();
        int result = rnd.nextInt(2); // 0 or 1.
        return result == 1; //default true.
    }
    public void afterHit(){
        System.out.println("Your hp: " + this.getPlayer().getHp());
        System.out.format("%s hp: %d\n", this.getObstacle().getName(), this.getObstacle().getHp());

    }
    public void playerStatusInBattle(){
        System.out.format("-----" + this.getPlayer().getPlayerName() + "-----" +
                "\nHp: " + this.getPlayer().getHp() +
                "\nWeapon: " + this.getPlayer().getWeapon().getName() + "(%d)" +
                "\nArmor: " + this.getPlayer().getArmor().getName() + "(%d)\n",
                this.getPlayer().getTotalDamage(),
                this.getPlayer().getArmor().getDefence());
    }
    public void obstacleStatus(int i){
        System.out.println("-----" + this.getObstacle().getName() + " " + i + "-----" +
                "\nHp: " + this.getObstacle().getHp() +
                "\nDamage: " + this.getObstacle().getDamage() +
                "\nAward: " + this.getObstacle().getMoneyAward());
    }
    public Obstacle getObstacle() {
        return obstacle;
    }
    public int getMinObstacle() {
        return minObstacle;
    }
    public int getMaxObstacle() {
        return maxObstacle;
    }
    public Award getAward() {
        return award;
    }
}
