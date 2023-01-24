import java.util.Scanner;
//Program to find fibonacci series with loops.
public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        sc.close();
        int first = 1;
        int second = 1;
        System.out.format("First %d fibonacci numbers: ", number);

        for (int i = 0; i < number; i++){
            System.out.print(first + " ");
            int temp = first + second;
            first = second;
            second = temp;
        }
    }
}