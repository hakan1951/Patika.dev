package java101.obstacle;

import java101.obstacle.monsters.Bear;
import java101.obstacle.monsters.Vampire;
import java101.obstacle.monsters.Zombie;

public class Obstacle {
    private final int id;
    private final String name;
    private int hp;
    private final int defaultHp;
    private final int damage;
    private final int award;
    public static Obstacle[] obstacles(){
        return new Obstacle[]{new Bear(), new Vampire(), new Zombie()}; // Only three obstacles for now.
    }

    public Obstacle(int id, String name, int hp, int damage, int award) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.defaultHp = hp;
        this.damage = damage;
        this.award = award;
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
    public int getAward() {
        return award;
    }
    public int getDefaultHp() {
        return defaultHp;
    }

}
