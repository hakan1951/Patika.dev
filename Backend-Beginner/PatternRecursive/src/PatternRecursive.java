import java.util.Scanner;
/*
Printing patterns recursively.
    Example:
        N : 16
        Output : 16 11 6 1 -4 1 6 11 16
*/
public class PatternRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number N: ");
        int number = sc.nextInt();
        sc.close();
        pattern(number);
    }
    public static void pattern(int number){
        patternPositive(number, number);
    }
    public static void patternPositive(int number, int original) {
        System.out.print(number + " ");
        if (number <= 0){
                patternNegative(number + 5, original);
        } else {
            patternPositive(number - 5, original);
        }
    }
    public static void patternNegative(int number, int original) {
        System.out.print(number + " ");
        if (number <= original){
                if (number == original){
                    return;
                }
                patternNegative(number + 5, original);
        }
    }
}