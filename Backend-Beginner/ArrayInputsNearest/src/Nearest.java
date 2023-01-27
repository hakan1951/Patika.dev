import java.util.Scanner;

public class Nearest {
    private static final int[] LIST = {15, 12, 788, 1, -1, -778, 2, 0};
    public static void main(String[] args) {
        int number = takeInput();
        printNearest(number);
    }
    public static int takeInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        System.out.println();
        sc.close(); //Can be closed since only one input will be taken per run.
        return number;
    }
    public static void printNearest(int number){
        int smallerNearest = Integer.MIN_VALUE;
        int biggerNearest = Integer.MAX_VALUE;
        if (isElement(number)){
            smallerNearest = number;
            biggerNearest = number;
        }else{
            for (int l : LIST){
                if (Math.abs(number-l) < Math.abs(number-smallerNearest) && number > l){
                    smallerNearest = l;
                }
                if( Math.abs(number-l) < Math.abs(number-biggerNearest) && number < l){
                    biggerNearest = l;
                }
            }
        }
        System.out.println("SmallerNearest: " + smallerNearest);
        System.out.println("BiggerNearest: " + biggerNearest);
    }
    public static boolean isElement(int number){
        boolean found = false;
        for (int l : LIST){
            if (l == number){
                found = true;
                break;
            }
        }
        System.out.format("Number %d is in the list.\n" ,number);
        return found;
    }
}