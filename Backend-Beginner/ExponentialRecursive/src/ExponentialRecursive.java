import java.util.Scanner;
//Finding exponential recursively.
public class ExponentialRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base: ");
        int base = sc.nextInt();
        System.out.print("Enter exponent: ");
        int exponent = sc.nextInt();
        sc.close();

        System.out.format("%d exponent %d : %.2f", base, exponent, exponential(base, exponent));
    }
    public static double exponential(int base, int exponent) {
        if (exponent == 0){
            return 1;
        }
        return base * exponential(base, exponent-1);
    }
}
