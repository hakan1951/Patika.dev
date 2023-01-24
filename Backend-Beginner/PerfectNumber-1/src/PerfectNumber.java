import java.util.ArrayList;
import java.util.Scanner;
/*
What is a Perfect Number?
A number whose positive integer factors (divisors without a remainder) are equal to itself, excluding the number itself, is called a perfect number.
*/
public class PerfectNumber {
    public static void main(String[] args) {
        runPerfectNumber();
    }
    public static void runPerfectNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive number to check if it is perfect: ");
        int number = sc.nextInt();
        if (number < 0){
            System.out.println("Number is not positive.");
            return;
        }
        sc.close();
        System.out.println(number + (isPerfect(number) ? " is a perfect number." : " is not a perfect number."));

    }

    public static boolean isPerfect(int number){
        int total = 0;
        ArrayList<Integer> divisors = new ArrayList<>(4);
        if (number == 0 || number == 1){
            return false;
        }
        for (int i = 1; i < number; i++){
            if (number % i == 0){
                divisors.ensureCapacity(divisors.size());
                divisors.add(i);
                total += i;
            }
        }
        return total == number;
    }
}
