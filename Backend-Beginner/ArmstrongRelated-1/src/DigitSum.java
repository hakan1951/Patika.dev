import java.util.Scanner;
//Sum of digits.
public class DigitSum {
    public static void main(String[] args) {
        System.out.print("Enter number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();
        int result = 0;
        int temp = number;

        do{
            result += temp%10;
            temp /=10;
        } while (temp > 0);
        System.out.format("Sum of digits of %d : %d", number, result);
    }
}
