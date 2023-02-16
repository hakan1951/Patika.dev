package java101.locations.battleLocations;

import java101.gameStream.player.Player;
import java101.locations.Location;
import java101.obstacle.Obstacle;

import java.util.Random;

public abstract class BattleLocation extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    public BattleLocation(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obstacleNumber = this.randomObstacleNumber();
        System.out.format("You are at the %s.", this.getName());
        System.out.format("\nThere are %d %ss.\n", obstacleNumber, this.getObstacle().getName());
        System.out.print("Run or Fight? (R/F) : ");
        String selection = (sc.nextLine()).toUpperCase();
        if (selection.equals("F") && fight(obstacleNumber)){
                System.out.println(this.getName() + " is completed.");
                return true;
        }
        if (this.getPlayer().getHp() <= 0){
            System.out.println("You are dead.");
            return false;
        }
        return true;
    }

    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1; // (0,1,2) -> (1,2,3)
    }

    public boolean fight(int obstacleNumber) {
        for (int i = 1; i <= obstacleNumber; i++){
            this.getObstacle().setHp(this.getObstacle().getDefaultHp());
            playerStatus();
            obstacleStatus(i);
            while (this.getPlayer().getHp() > 0 && this.getObstacle().getHp() > 0){
                System.out.println("Run or Fight. (R/F): ");
                String selection = sc.nextLine().toUpperCase();
                if (selection.equals("F")){
                    System.out.println("--Hit!");
                    this.getObstacle().setHp(this.obstacle.getHp()-this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHp() > 0){
                        System.out.println("----------");
                        System.out.println("--Monster is attacking!");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getDefence();
                        if (obstacleDamage < 0){
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHp(this.getPlayer().getHp()-obstacleDamage);
                        if (!(this.getPlayer().getHp() <= 0)){
                            afterHit();
                        }
                    }
                }else { //Run
                    return false;
                }
            }
            if (this.getObstacle().getHp() < this.getPlayer().getHp()){
                System.out.println("Monster is fainted.");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("You got: " + this.getObstacle().getAward() + "\nYour money: " + this.getPlayer().getMoney());
            }
        }
        return false;
    }

    public void afterHit(){
        System.out.println("Your hp: " + this.getPlayer().getHp());
        System.out.format("%s hp: %d\n", this.getObstacle().getName(), this.getObstacle().getHp());

    }

    public void playerStatus(){
        System.out.println("-----" + this.getPlayer().getPlayerName() + "-----" +
                "\nHp: " + this.getPlayer().getHp() +
                "\nWeapon: " + this.getPlayer().getWeapon().getName() +
                "\nDamage: " + this.getPlayer().getTotalDamage() +
                "\nArmor: " + this.getPlayer().getArmor().getName() +
                "\nDefence: " + this.getPlayer().getArmor().getDefence() +
                "\nMoney: " + this.getPlayer().getMoney());
    }

    public void obstacleStatus(int i){
        System.out.println("-----" + i + ". " + this.getObstacle().getName() + "-----" +
                "\nHp: " + this.getObstacle().getHp() +
                "\nDamage: " + this.getObstacle().getDamage() +
                "\nAward: " + this.getObstacle().getAward());
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
