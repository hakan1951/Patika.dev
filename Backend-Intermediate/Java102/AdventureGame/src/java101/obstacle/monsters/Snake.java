package java101.obstacle.monsters;

import java101.obstacle.Obstacle;

public class Snake extends Obstacle {
    public Snake() {
        super(4, "Snake", 12, 4, 0);
        randomAward = snakeRandomAward();
    }
    //TODO: will be rewritten.
    public String snakeRandomAward(){
        String droppedAward = null;
        final double probabilityWeapon = 0.15;
        final double probabilityArmor = 0.15;
        final double probabilityMoney = 0.20;
        final double probabilityNothing = 0.50;
        double random1 = Math.random();
        double random2 = Math.random();
        if (random1 < probabilityWeapon){
            final double probabilityPistol = 0.50;
            final double probabilitySword = 0.30;
            final double probabilityRifle = 0.20;
            if (random2 < probabilityPistol){
                droppedAward = "Pistol";
            } else if (random2 < probabilityPistol + probabilitySword) {
                droppedAward = "Sword";
            }else {
                droppedAward = "Rifle";
            }
        } else if (random1 < probabilityWeapon + probabilityArmor) {
            final double probabilityLight = 0.50;
            final double probabilityNormal = 0.30;
            final double probabilityHeavy = 0.20;
            if (random2 < probabilityLight){
                droppedAward = "Light Armor";
            } else if (random2 < probabilityLight + probabilityNormal) {
                droppedAward = "Normal Armor";
            }else {
                droppedAward = "Heavy Armor";
            }
        }else if (random1 < probabilityWeapon + probabilityArmor + probabilityMoney) {
            final double probability1 = 0.50;
            final double probability5 = 0.30;
            final double probability10 = 0.20;
            if (random2 < probability1){
                droppedAward = "1 Money";
            } else if (random2 < probability1 + probability5) {
                droppedAward = "5 Money";
            }else {
                droppedAward = "10 Money";
            }
        }
        return droppedAward;
    }
}
