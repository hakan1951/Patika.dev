import java.util.Scanner;
//Reverse triangle with n steps.
public class ReverseTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number :");
        int n = sc.nextInt();
        sc.close();

        for(int i=n; i>=1; i--) {
            for(int j=1; j<=(n-i); j++) {
                System.out.print(" ");
            }
            for(int j=1; j<=(2*i-1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}