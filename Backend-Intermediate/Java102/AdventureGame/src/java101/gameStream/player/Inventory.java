package java101.gameStream.player;

import java101.items.armors.Armor;
import java101.items.weapons.Weapon;

public class Inventory {
    private Weapon weapon;
    private Armor armor;

    public Inventory() {
        this.weapon = new Weapon(-1, "Punch", 0,0);
        this.armor = new Armor(-1,"Cloth", 0,0);
    }

    public Weapon getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public Armor getArmor() {
        return armor;
    }
    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
