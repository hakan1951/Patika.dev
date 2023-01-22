import java.util.Arrays;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number: ");
        int n1 = sc.nextInt();
        System.out.println("Enter second number: ");
        int n2 = sc.nextInt();
        System.out.println("Enter third number: ");
        int n3 = sc.nextInt();
        int[] numbers = {n1,n2,n3};

        Arrays.sort(numbers);
        System.out.format(" %d < %d < %d", numbers[0],numbers[1],numbers[2]);
    }
}
