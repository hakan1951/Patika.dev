import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            int input1 = sc.nextInt();
            int input2 = sc.nextInt();
            System.out.println(input1 / input2);
        }catch(ArithmeticException e){
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e.getClass().getName());
        }
    }
}
