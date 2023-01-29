import java.util.Arrays;
import java.util.Scanner;

public class SortingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array length(integer): ");
        int aLength = sc.nextInt();
        int[] list = new int[aLength];
        int i = 0;
        while (aLength > 0){
            System.out.format("Element %d: ", i+1);
            list[i] = sc.nextInt();
            i++;
            aLength--;
        }
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));
    }
}