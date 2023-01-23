import java.util.Scanner;
/** Integer exponents only. **/
public class Exponential {
    public static double exponential(int base, int exponent){
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base: ");
        int base = sc.nextInt();
        System.out.print("Enter exponent: ");
        int exponent = sc.nextInt();
        sc.close();

        System.out.format("%d exponent %d : %.3f", base, exponent, exponential(base, exponent));

    }
}