import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        System.out.printf("First %d numbered fibonacci series  : ", number);
        for (int i = 0; i < number; i++){
            System.out.print(fibonacci(i) + " ");
        }
    }
    public static int fibonacci(int number){
        if (number == 0) {
            return 0;
        }else if (number == 1 || number == 2){
            return 1;
        }
        return fibonacci(number-1) + fibonacci(number-2);
    }
}