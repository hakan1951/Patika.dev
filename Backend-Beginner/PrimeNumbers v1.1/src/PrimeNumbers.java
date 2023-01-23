import java.util.Scanner;
//Prime numbers 2-100
public class PrimeNumbers {
    public static boolean isPrimeNumber(int number) {
        if (number < 0) {
            return false;
        } else if (number == 0 || number == 1) {
            return true;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void primeNumbersFrom2toNumber(int number){
        for (int i = 2; i <= number; i++) {
            if (isPrimeNumber(i)){
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
/*        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number :");
        int number = scanner.nextInt();
        System.out.println(isPrimeNumber(number) ? number + " is a prime number" : number + " is not a prime number." );*/
        int number = 100;
        System.out.println("Prime numbers in the inclusive range of 2 and " + number + ";");
        primeNumbersFrom2toNumber(number);

    }
}
