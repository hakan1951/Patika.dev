import java.util.Scanner;

public class HarmonicSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number N: ");
        int numberN = sc.nextInt();
        sc.close();
        double total = 0;

        for (double i = 1; i <= numberN; i++){
            total += 1/i;
        }
        System.out.println(total);
    }
}