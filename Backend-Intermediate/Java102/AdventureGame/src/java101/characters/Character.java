package java101.characters;

public abstract class Character {
    private final int id;
    private final String name;
    private final int damage;
    private final int hp;
    private final int money;

    public Character(int id, String name, int damage, int hp, int money) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.hp = hp;
        this.money = money;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getDamage() {
        return damage;
    }
    public int getHp() {
        return hp;
    }
    public int getMoney() {
        return money;
    }

}
