package java101.gameStream.player;

import java101.items.awards.Award;
import java101.items.armors.Armor;
import java101.items.weapons.Weapon;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private final Award[] awards;

    public Inventory() {
        this.weapon = new Weapon(-1, "Punch", 0,0);
        this.armor = new Armor(-1,"Cloth", 0,0);
        this.awards = new Award[Award.numberOfAwards];
    }

    public Weapon getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapon weapon) {
        if(this.weapon.getDamage() < weapon.getDamage()){
            this.weapon = weapon;
        }else{
            System.out.println("You already have " + this.weapon.getName() + ".");
        }
    }
    public Armor getArmor() {
        return armor;
    }
    public void setArmor(Armor armor) {
        if(this.armor.getDefence() < armor.getDefence()){
            this.armor = armor;
        } else{
            System.out.println("You already have " + this.armor.getName() + ". ");
        }
    }
    public String getAwards() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < awards.length; i++){
            if (awards[i] != null){
                sb.append(awards[i].getName());
                if(i < awards.length-1){
                    if (awards[i+1] != null){
                        sb.append(", ");
                    }
                }
            }
        }
        sb.append("]");
        return String.valueOf(sb);
    }
    public boolean isEmpty(){
        for (Award a: awards){
            if (a != null){
                return false;
            }
        }
        return true;
    }
    public boolean isContainsAward(Award award){
        if (!isEmpty()) {
            for (Award a : awards) {
                if (a == null) {
                    continue;
                }
                if (a.getName().equals(award.getName())) {
                    return false;
                }
            }
        }
        return true;
    }
    public void addAward(Award award){
        boolean permit = false;
        if (isContainsAward(award)){
            for (int i = 0; i < awards.length; i++){
                if (awards[i] == null){
                    awards[i] = award;
                    permit = true;
                    break;
                }
            }
        }
        if (!permit){
            System.out.println(award.getName() + " is not added into Inventory. You already have one.");
        }
    }

}
