import java.util.Scanner;

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
