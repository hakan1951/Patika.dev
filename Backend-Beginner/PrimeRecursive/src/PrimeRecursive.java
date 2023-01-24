import java.util.Scanner;
//Check if a given number is prime or not, recursively.
public class PrimeRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        if (isPrime(number, number/2)){
            System.out.println(number + " is a prime number");
        }else {
            System.out.println(number + " is not a prime number");
        }
    }
    public static boolean isPrime(int number, int divisor){
        if (number <= 1){
            return false;
        } else if (number == 2) {
            return true;
        } else if (number % divisor == 0) {
            return false;
        }
        return isPrime(number, divisor-1);
    }
}