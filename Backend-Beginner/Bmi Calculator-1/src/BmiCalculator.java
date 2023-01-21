import java.util.Scanner;

/*  Take the height and weight values from the user and assign them to a variable.
    Calculate the user's "Body Mass Index" according to the formula below and print it on the screen. */
public class BmiCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println( "Please enter your name, your height(m) and your weight(kg).");
        System.out.print("Your name: ");
        String name = scanner.nextLine();
        System.out.print("Your height: ");
        double height = scanner.nextDouble();
        System.out.print("Your weight: ");
        int weight = scanner.nextInt();

        double bmi = weight / (Math.pow(height, 2));

        System.out.println("-----\n" + "Your name: " + name
                +"\nYour height : " + height
                + "\nYour weight : " + weight
                + "\nYour bmi : " + bmi);

    }
}
