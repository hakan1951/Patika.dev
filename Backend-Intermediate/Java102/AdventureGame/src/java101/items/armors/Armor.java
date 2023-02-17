package java101.items.armors;

public class Armor {
    private final int id;
    private final String name;
    private final int defence;
    private final int price;

    public Armor(int id, String name, int defence, int price) {
        this.id = id;
        this.name = name;
        this.defence = defence;
        this.price = price;
    }

    public static Armor[] armors(){
        return new Armor[]{new LightArmor(), new NormalArmor(), new HeavyArmor()}; // Only three armors for now.
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
    public String getName() {
        return name;
    }
    public int getDefence() {
        return defence;
    }
    public int getPrice() {
        return price;
    }
}
