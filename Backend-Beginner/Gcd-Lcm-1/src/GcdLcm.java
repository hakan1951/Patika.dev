import java.util.Scanner;
//GCD-LCM
public class GcdLcm {
    public static int greatestCommonDivider(int a, int b){
        int gcd = 1;
        int i = 2;
        while (i <= Math.min(a, b)){
            if ((a % i == 0) && (b % i == 0)){
                gcd = i;
            }
            i++;
        }
        return gcd;
    }

    public static int leastCommonMultiple(int a, int b){
        int lcd = 1;
        lcd *= greatestCommonDivider(a,b) * (a/greatestCommonDivider(a,b) * (b/greatestCommonDivider(a,b)));
        return lcd;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int firstNumber = scanner.nextInt();
        System.out.print("Enter second number: ");
        int secondNumber = scanner.nextInt();

        System.out.println("GCD: " + greatestCommonDivider(firstNumber, secondNumber));
        System.out.println("LCM: " + leastCommonMultiple(firstNumber, secondNumber));
    }
}
