package java101.items.weapons;

public class Weapon implements IWeapon {
    private int id;
    private String name;
    private int damage;
    private int price;
    public static Weapon[] weapons(){
        Weapon[] weaponList = {new Pistol(), new Sword(), new Rifle()}; // Only three weapons for now.
        return weaponList;
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

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
