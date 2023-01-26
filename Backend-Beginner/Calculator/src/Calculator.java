import java.util.Scanner;
//Simple(only-positive-integer-input, double-output) calculator.
//ToDo: exception, overflow...
public class Calculator {
    public static void main(String[] args) {
        runFirstInput();
    }
    public static void runFirstInput(){
        //First input.
        String menu1 = """
                 Welcome. Example inputs
                -Addition(+) -> '3+5'
                -Subtraction(-) -> '3-5'
                -Multiplication(*) -> '3*5'
                -Power(^) -> '3^5'
                -Modulo(%) -> '3%5'
                -Factorial(f) -> '5f'
                -RectangleArea&Perimeter(r) -> '4x5';
                -Exit(e) -> 'e'
                ---------
                First input:\040""";
        System.out.print(menu1);
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        //Check if input is proper.
        String[] lineParts = input.split(" ");
        if (lineParts.length > 1){
            System.out.println("Invalid input1.");
            System.exit(0);
        }

        String[] parts = input.split("(?<=\\d)(?=[+-/*^%fre])|(?<=[+-/*^%fre])(?=\\d)");
        if (parts.length > 3){
            System.out.println("Invalid input. Enter exactly one operation with positive numbers.");
            System.exit(0);
        }
        int num1 = 0, num2 = 0;
        String operator;
        if (parts.length == 1){
            operator = parts[0];
        }else if (parts.length == 2){
            num1 = Integer.parseInt(parts[0]);
            operator = parts[1];
        }else {
            num1 = Integer.parseInt(parts[0]);
            operator = parts[1];
            num2 = Integer.parseInt(parts[2]);
        }
        double result = 0;
        switch (operator) {
            case "+" -> result = addition(num1,num2);
            case "-" -> result = subtraction(num1, num2);
            case "*" -> result = multiplication(num1,num2);
            case "/" -> result = division(num1,num2);
            case "^" -> result = power(num1, num2);
            case "%" -> result = modulo(num1, num2);
            case "f" -> result = factorial(num1);
            case "r" -> {
                rectangle(num1, num2);
                System.exit(0);
            }
            case "e" -> {
                System.out.println("Why did you bother me? Closing the application.");
                System.exit(0);
            }
            default -> {
                System.out.println("Invalid operator");
                System.exit(-1);
            }
        }

        if (operator.equals("f")) {
            System.out.format("%d! = %.2f\n", num1, result);
        } else {
            System.out.format("%d %s %d = %.2f\n", num1, operator, num2, result);
        }
            nextInputs(result);
    }

    public static void nextInputs(double result){
        //Next inputs(Continuous).
        String menu2 = "You can continue calculating\n(e.g +5, -5, *5, /5, ^4, %5, f, e): ";
        System.out.print(menu2);
        Scanner sc = new Scanner(System.in);
        int count = 20;
        while (count > 0){
            int num2 = 0;
            String operator;
            double temp = result;
            String input = sc.nextLine();
            //Check if input is proper.
            String[] lineParts = input.split(" ");
            if (lineParts.length > 1){
                System.out.println("Multiple operations! Enter exactly one operation with positive numbers.\n(e.g +5, -5, *5, /5, ^4, f, %5, e).");
                System.out.print(result + " ");
                continue;
            }
            String[] parts = input.split("(?<=\\d)(?=[+-/*^%fre])|(?<=[+-/*^%fre])(?=\\d)");
            if (parts.length == 1){
                operator = parts[0];
            }else if (parts.length >= 3){
                System.out.println("Invalid input! Enter exactly one operation with positive numbers.\n(e.g +5, -5, *5, /5, ^4, %5, f, e).");
                System.out.print(result + " ");
                continue;
            }else {
                operator = parts[0];
                num2 = Integer.parseInt(parts[1]);
            }

            switch (operator) {
                case "+" -> result = addition((int) result,num2);
                case "-" -> result = subtraction((int) result, num2);
                case "*" -> result = multiplication((int) result,num2);
                case "/" -> result = division(result,num2);
                case "^" -> result = power((int) result, num2);
                case "%" -> result = modulo((int) result, num2);
                case "f" -> {
                    if (result < 0){
                        System.out.println("Number can not be negative.");
                        break;
                    }
                    result = factorial((int) result);
                }
                case "e" -> {
                    System.out.println("Thanks.");
                    System.out.println("Closing the program. Result: " + result);
                    System.exit(100);
                }
                default -> System.out.println("Invalid operator");
            }
            if (operator.equals("f")){
                System.out.format("%.2f! = %.2f ", temp, result);
            }else {
                System.out.format("%.2f %s %d = %.2f ", temp, operator, num2, result);
            }
            count--;
        }
        sc.close();

    }
    public static int addition(int a, int b){
        return a + b;
    }
    public static int subtraction(int a, int b){
        return a - b;
    }
    public static int multiplication(int a, int b){
        return a * b;
    }
    public static double division(double a, double b){
        return a / b;
    }
    public static double power(double base, double exponent){
        double result = 1;
        if (base == 0){
            return 0;
        } else if (exponent == 0) {
            return 1;
        } else if (exponent < 0) { // --
            for (int i = -1; i >= exponent; i--){
                result /= base;
            }
            return result;
        }else {
            for (int i = 1; i <= exponent; i++){ //++
                result *=base;
            }
            return result;
        }
    }
    public static int modulo(int dividend, int divisor){
        return dividend % divisor;
    }
    public static int factorial(int num) {
        int result = 1;
        if (num == 0) {
            return result;
        }else {
            for (int i = 1; i <= num; i++){
                result *= i;
            }
        }
        return result;
    }
    public static void rectangle(int edge1, int edge2){
        int area = edge1 * edge2;
        int perimeter = 2 * (edge1 + edge2);
        System.out.format("Rectangle(%dx%d) area = %d\n", edge1, edge2, area);
        System.out.format("Rectangle(%dx%d) perimeter = %d", edge1, edge2, perimeter);
    }

}