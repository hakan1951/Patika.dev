import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;
        int total = 0;

        do {
            System.out.print("Enter a number: ");
            number = sc.nextInt();
            if (number % 4 == 0){
                total += number;
            }
        }while (number % 2 ==0);
        System.out.println("Total sum : " + total);

    }
}