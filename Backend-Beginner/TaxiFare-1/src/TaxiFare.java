import java.util.Scanner;

public class TaxiFare {

/*  Write a program that prints the taximeter amount to the screen according to the distance traveled (KM).
    Taximeter costs 2.20 TL per km.
    The minimum amount to be paid is 20 TL.
    For wages under 20 TL, 20 TL will be charged.
    The taximeter opening fee is 10 TL. */

    public static void main(String[] args) {
        final double costPerKm = 2.20;
        double openingCost = 10;
        double minimumCost = 20;

        //User input.
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the travelled distance(km):  ");
        double distance = sc.nextDouble();
        sc.close();

        //Calculation
        double travelledCost = openingCost + (distance * costPerKm);
        travelledCost = travelledCost >= minimumCost ? travelledCost : minimumCost;
        System.out.format("Total cost: %.2f", travelledCost);

    }
}
