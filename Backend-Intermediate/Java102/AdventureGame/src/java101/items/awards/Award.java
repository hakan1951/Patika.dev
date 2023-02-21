package java101.items.awards;

public class Award {
    private int id;
    private String name;
    public static final int numberOfAwards = 4; // Total awards in the game.

    /** Main Awards*/
    public Award(int id, String name){
        this.id = id;
        this.name = name;
    }
    public static Award[] awards(){
        return new Award[] {new Food(), new Firewood(), new Water(), new RandomAward()};
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
    @Override
    public String toString() {
        return "Award{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
