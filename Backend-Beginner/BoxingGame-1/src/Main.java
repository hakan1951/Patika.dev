import java.util.Random;

public class Main {
    public static class Fighter {
        String name;
        int health;
        int damage;
        int weight;
        double dodge;

        public Fighter(String name, int health, int damage, int weight, double dodge) {
            this.name = name;
            this.health = health;
            this.damage = damage;
            this.weight = weight;
            this.dodge = dodge;
        }

        public void attack(Fighter rival) {
            System.out.format("%s(%d) damaged %s(%d) %d.", this.name, this.health, rival.name, rival.health, this.damage);
            System.out.println();
            if (rival.dodge()) {
                System.out.println(rival.name + " dodged the attack.");
            }else if (rival.health - this.damage < 0) {
                rival.health = 0;
                System.out.println(rival.name + " is fainted.");
            }else {
                rival.health -= this.damage;
            }
        }
        public boolean dodge() {
            double randomValue = Math.random() * 100;  //0.0 to 99.9
            return randomValue <= this.dodge;
        }
    }

    public static class Ring {
        Fighter f1;
        Fighter f2;
        int minWeight;
        int maxWeight;

        public Ring(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
            this.f1 = f1;
            this.f2 = f2;
            this.minWeight = minWeight;
            this.maxWeight = maxWeight;
        }

        public void fight() {
            int i = 1;
            if (checkWeight()) {
                while (f1.health > 0 && f2.health > 0) {
                    Random random = new Random();
                    if (!random.nextBoolean()){
                        Fighter temp = f1;
                        f1 = f2;
                        f2 = temp;
                    }
                    System.out.format("======== ROUND %d ===========", i);
                    System.out.println();
                    i++;

                    f1.attack(f2);
                    if (isWin()){
                        break;
                    }
                    f2.attack(f1);
                    if (isWin()){
                        break;
                    }
                    printScore();
                }

            } else {
                System.out.println("Invalid weight.");
            }
        }
        public boolean checkWeight() {
            return (f1.weight >= minWeight && f1.weight <= maxWeight) && (f2.weight >= minWeight && f2.weight <= maxWeight);
        }

        public boolean isWin() {
            if (f1.health == 0) {
                System.out.println("Winner : " + f2.name);
                return true;
            } else if (f2.health == 0){
                System.out.println("Winner : " + f1.name);
                return true;
            }
            return false;
        }
        public void printScore() {
            System.out.println("------------");
            System.out.println(f1.name + "-Remaining health: " + f1.health);
            System.out.println(f2.name + "-Remaining health: " + f2.health);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Fighter marc = new Fighter("Marc", 100, 15, 90, 35);
        Fighter alex = new Fighter("Alex", 90,10, 100, 45);
        Ring r = new Ring(marc,alex, 90, 100);
        r.fight();
    }
}
