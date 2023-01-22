import java.util.Scanner;

public class TicketPrice {

/*
Make a program that calculates air ticket prices according to distance and conditions.
Get Distance (KM), age and trip type (One Way, Round-trip) information from the user.
Take the fare per distance as 0.10 TL / km.
First, calculate the total price of the flight and then apply the following discounts.

Values received from the user must be valid (distance and age are positive numbers,
trip type is 1 or 2). Otherwise, "You Have Entered Wrong Data!" A warning should be given.
If the person is younger than 12 years old, 50% discount is applied on the ticket price.
If the person is between the ages of 12-24, a 10% discount is applied on the ticket price.
If the person is over 65 years old, a 30% discount is applied on the ticket price.
If the person has chosen the journey type "round-trip", 20% discount is applied on the ticket price.

*/
    public static void main(String[] args) {
        final double farePerDistance = 0.10; //Per km.

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the distance(km): ");
        double distance = sc.nextDouble();
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        sc.nextLine(); // dummy escape.
        System.out.print("Enter your ticket type (1/2) (1-One Way, 2-Round-trip): ");
        String journeyType = sc.nextLine();

        if ((distance <= 0) || (age <= 0) || !((journeyType.equals("1") || journeyType.equals("2")))){
            System.out.println("Wrong data.");
            return;
        }
        double totalPrice = distance * farePerDistance;
        double discount = 0;
        if (age < 12){
            discount = 0.50;
        } else if (age <24) {
            discount = 0.10;
        } else if (age >= 65) {
            discount = 0.30;
        }
        totalPrice -= totalPrice * discount;
        if (journeyType.equals("2")){
            double journeyTypeDiscount = 0.20;
            totalPrice -= totalPrice * journeyTypeDiscount;
            totalPrice *= 2; //Round-trip.
        }
        System.out.println("Total price : " + totalPrice);

    }
}
