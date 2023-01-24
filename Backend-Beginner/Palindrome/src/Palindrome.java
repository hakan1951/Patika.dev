import java.util.Scanner;
//Check if given integer is palindrome or not.
public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        Integer number = sc.nextInt();
        sc.close();
        System.out.println(isPalindrome(number) ? (number + " is palindrome.") : (number + " is not palindrome."));
    }
    public static boolean isPalindrome(int number){
        String sNumber = Integer.toString(number);
        String reverse = new StringBuilder(sNumber).reverse().toString();
        return reverse.equals(sNumber);
    }
}