import java.util.Scanner;
/*

    Write a program that prints the total amount of the products
purchased from the grocery store, according to the kilogram values, to the screen.

        Fruits and KG Prices
        Pear: 2.14 TL
        Apple : 3.67 TL
        Tomatoes: 1.11 TL
        Banana: 0.95 TL
        Eggplant : 5.00 TL
*/

public class Greengrocer {
    public static void main(String[] args) {
        final double pearCost = 2.14;
        final double appleCost = 3.67;
        final double tomatoesCost = 1.11;
        final double bananaCost = 0.95;
        final double eggplantCost = 5.00;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many kg were purchased from the fruits accordingly, please.");
        System.out.print("Pear: ");;
        double pear = sc.nextDouble();
        System.out.print("Apple: ");;
        double apple = sc.nextDouble();
        System.out.print("Tomatoes: ");;
        double tomatoes = sc.nextDouble();
        System.out.print("Banana: ");;
        double banana = sc.nextDouble();
        System.out.print("Eggplant: ");;
        double eggplant = sc.nextDouble();

        double totalCost = pear * pearCost
                + apple * appleCost
                + tomatoes * tomatoesCost
                + banana * bananaCost
                +eggplant * eggplantCost;
        System.out.format("Total cost: %.2f", totalCost, " TL");

    }
}
