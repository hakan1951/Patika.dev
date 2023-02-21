package java101.items.awards;

public class RandomAward extends Award{
    private String randomAwardName;
    public RandomAward() {
        super(0, "Random Trophy");
    }

    public String getRandomAwardName() {
        return randomAwardName;
    }

    public void setRandomAwardName(String randomAwardName) {
        this.randomAwardName = randomAwardName;
    }
}
