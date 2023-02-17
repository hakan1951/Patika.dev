package java101.items.weapons;

public class Weapon {
    private final int id;
    private final String name;
    private final int damage;
    private final int price;
    public static Weapon[] weapons(){
        return new Weapon[] {new Pistol(), new Sword(), new Rifle()}; // Only three weapons for now.

    }

    public Weapon(int id, String name, int damage, int price) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    public static Weapon getWeaponByID(int id){
        for (Weapon w : Weapon.weapons()){
            if (w.getId() == id){
                return w;
            }
        }
        return null;
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
    public int getPrice() {
        return price;
    }
}
