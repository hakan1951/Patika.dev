import java.util.Scanner;
/*
    Combination formula
    C(n,r) = n! / (r! * (n-r)!)
*/
public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a combination C(n,r): ");
        System.out.print("n: ");
        int n = sc.nextInt();
        System.out.print("r: ");
        int r = sc.nextInt();
        sc.close();
        int combination = factorial(n) / (factorial(r) * (factorial(n-r)));
        System.out.format("C(%d,%d) : %d" , n, r, combination);
    }
        public static int factorial(int number) {
        int total = 1;
        if (number == 0) {
            return total;
        }
        for (int i = 1; i <= number; i++) {
            total *= i;
        }
        return total;
    }
}
