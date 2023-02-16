package java101.locations.normalLocations;

import java101.items.armors.Armor;
import java101.gameStream.player.Player;
import java101.items.weapons.Weapon;

public class Shop extends NormalLocation {
    public Shop(Player player) {
        super(player, "Shop");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to the shop.");
        boolean control = true;
        while(control){
            System.out.println("1-Show Weapons" +
                    "\n2-Show Armors" +
                    "\n0-Exit");
            System.out.print("Select an operation: ");
            int selection = sc.nextInt(); //Shop extends NormalLocation -> Location(Scanner)
            while (selection < 0 || selection > 3){
                System.out.print("Invalid selection. Try again: ");
                selection = sc.nextInt();
            }
            switch (selection) {
                case 1:
                    printWeapons();
                    buyWeapon();
                    break;
                case 2:
                    printArmors();
                    buyArmors();
                    break;
                case 0:
                    System.out.println("Thanks.");
                    control = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapons(){
        System.out.println("-----Weapons-----");
        for (Weapon w : Weapon.weapons()){
            System.out.println("Id:" + w.getId() +
                    "\tName:" + w.getName() +
                    "\t Damage: " + w.getDamage() +
                    "\t Price: " + w.getPrice());
        }
        System.out.println("Id: 0 --> Exit.");

    }
    public void buyWeapon(){
        System.out.print("Select a weapon to buy: ");
        int weaponSelection = sc.nextInt();
        while (weaponSelection < 0 || weaponSelection > Weapon.weapons().length){
            System.out.print("Invalid selection. Try again.");
            weaponSelection = sc.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponByID(weaponSelection);
        sc.nextLine();

        if (selectedWeapon != null){
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                System.out.println("Insufficient balance.");
            }else {
                this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedWeapon.getPrice());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("You bought a " + selectedWeapon.getName() + ".");
                this.getPlayer().printPlayerInfo();
                System.out.println("--------------------");
                //System.out.println("New balance: " + this.getPlayer().getMoney());
            }
        }
    }
    public void printArmors(){
        System.out.println("-----Armors-----");
        for (Armor a : Armor.armors()){
            System.out.println("Id: " + a.getId() +
                    "\tName: " + a.getName() +
                    "\t Defence: " + a.getDefence() +
                    "\t Price: " + a.getPrice());
        }
        System.out.println("0-Exit.");
    }
    public void buyArmors(){
        System.out.print("Select an armor to buy: ");
        int armorSelection = sc.nextInt();
        while (armorSelection < 0 || armorSelection > Armor.armors().length){
            System.out.print("Invalid selection. Try again.");
            armorSelection = sc.nextInt();
        }
        Armor selectedArmor = Armor.getArmorByID(armorSelection);

        if (selectedArmor != null){
            if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                System.out.println("Insufficient balance.");
            }else {
                this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                //System.out.println("New balance: " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setArmor(selectedArmor);
            }
        }
    }
}
