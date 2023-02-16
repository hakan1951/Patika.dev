package java101.obstacle;

import java101.obstacle.monsters.Bear;
import java101.obstacle.monsters.Vampire;
import java101.obstacle.monsters.Zombie;

public class Obstacle {
    private int id;
    private String name;
    private int hp;
    private int defaultHp;
    private int damage;
    private int award;
    public static Obstacle[] obstacles(){
        Obstacle[] obstacles = {new Bear(), new Vampire(), new Zombie()}; // Only three obstacles for now.
        return obstacles;
    }

    public Obstacle(int id, String name, int hp, int damage, int award) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.defaultHp = hp;
        this.damage = damage;
        this.award = award;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getDefaultHp() {
        return defaultHp;
    }

    public void setDefaultHp(int defaultHp) {
        this.defaultHp = defaultHp;
    }
}
