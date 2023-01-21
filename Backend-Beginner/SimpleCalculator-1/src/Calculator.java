import java.util.Scanner;

//Simple calculator with four operations.
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                Select the operation(1-2-3-4):\s
                1.Addition
                2.Subtraction
                3.Multiplication
                4.Division
                ---------
                Your selection:""");

        try {
            int input = scanner.nextInt();
            if (!(input >= 1 && input <= 4)) {
                System.out.println("Invalid operation.");
                System.exit(-1);
            }

            System.out.print("Enter first number");
            double firstNumber = scanner.nextDouble();
            System.out.print("Enter second number");
            double secondNumber = scanner.nextDouble();
            double result = 0;
            String operation = "";

            switch (input) {
                case 1 -> {
                    operation = "Addition";
                    result = firstNumber + secondNumber;
                }
                case 2 -> {
                    operation = "Subtraction";
                    result = firstNumber - secondNumber;
                }
                case 3 -> {
                    operation = "Multiplication";
                    result = firstNumber * secondNumber;
                }
                case 4 -> {
                    if (secondNumber == 0) {
                        System.out.println("A number can not be divided by 0. Try again.");
                        System.exit(-1);
                    }
                    operation = "Division";
                    result = firstNumber / secondNumber;
                }

            }
            System.out.println(operation + " of " + firstNumber + " and " + secondNumber + " is " + result + ".");
        } catch (Exception e){
            System.out.println("Invalid input. Enter an integer among 1-2-3-4.");
        }
    }
}
