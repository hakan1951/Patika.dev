import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int total = 0;
        int count = 0;

        for (int i = 1; i <=number; i++){
            if ((i % 3 == 0) && (i % 4 == 0)){
                total += i;
                count++;
            }
        }
        double average = (double) total / count;
        System.out.format("Average: %.2f", average);

    }
}