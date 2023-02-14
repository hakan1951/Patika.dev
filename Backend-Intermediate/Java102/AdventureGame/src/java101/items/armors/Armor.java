package java101.items.armors;

import java101.items.weapons.Weapon;

public class Armor implements IArmor{
    private int id;
    private String name;
    private int defence;
    private int price;

    public Armor(int id, String name, int defence, int price) {
        this.id = id;
        this.name = name;
        this.defence = defence;
        this.price = price;
    }

    public static Armor[] armors(){
        Armor[] armorList = {new LightArmor(), new NormalArmor(), new HeavyArmor()}; // Only three armors for now.
        return armorList;
    }

    public static Armor getArmorByID(int id){
        for (Armor a : Armor.armors()){
            if (a.getId() == id){
                return a;
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

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}