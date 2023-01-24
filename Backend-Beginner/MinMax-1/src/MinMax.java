import java.util.Scanner;

public class MinMax {
    public static void main(String[] args) {
        runMinMax();
    }
    public static void runMinMax(){
        Scanner sc = new Scanner(System.in);
        System.out.print("How many numbers inputs: ");
        int count = sc.nextInt();
        int[] inputs = new int[count];
        int i = 0;

        while (count > 0){
            System.out.format("Enter input %d: ", (i+1));
            inputs[i] = sc.nextInt();
            i++;
            count--;
        }
        sc.close();
        printMin(inputs);
        printMax(inputs);
    }
    public static void printMax(int[] numbers){
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++){
            if (numbers[i] > max){
                max = numbers[i];
            }
        }
        System.out.println("Maximum value: " + max);
    }
    public static void printMin(int[] numbers){
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            min = Math.min(min,numbers[i]);
        }
        System.out.println("Minimum value: " + min);

    }
}
