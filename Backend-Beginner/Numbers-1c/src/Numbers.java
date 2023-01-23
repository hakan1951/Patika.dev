import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        sc.close();

        for (int i = 1; i <= number; i++){
            if ((i % 4 == 0) && (i % 5 == 0)){
                System.out.println(i);
            }
        }

    }
}