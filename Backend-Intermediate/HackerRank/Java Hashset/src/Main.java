import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashSet<String> hSet = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < number; i++){
            hSet.add(sc.nextLine());
            System.out.println(hSet.size());
        }

    }
}
