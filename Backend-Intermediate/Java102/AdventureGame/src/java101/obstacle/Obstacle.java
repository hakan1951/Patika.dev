package java101.obstacle;

import java101.obstacle.monsters.Bear;
import java101.obstacle.monsters.Snake;
import java101.obstacle.monsters.Vampire;
import java101.obstacle.monsters.Zombie;

public class Obstacle {
    private final int id;
    private final String name;
    private int hp;
    private final int defaultHp;
    private final int damage;
    private final int moneyAward;
    protected String randomAward;
    public static Obstacle[] obstacles(){
        return new Obstacle[]{new Bear(), new Vampire(), new Zombie(), new Snake()}; // Only three obstacles for now.
    }

    public Obstacle(int id, String name, int hp, int damage, int moneyAward) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.defaultHp = hp;
        this.damage = damage;
        this.moneyAward = moneyAward;
    }

    public String getName() {
        return name;
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
    public int getDamage() {
        return damage;
    }
    public int getMoneyAward() {
        return moneyAward;
    }
    public int getDefaultHp() {
        return defaultHp;
    }
    public String getRandomAward() {
        return randomAward;
    }
    public void setRandomAward(String randomAward) {
        this.randomAward = randomAward;
    }
}
