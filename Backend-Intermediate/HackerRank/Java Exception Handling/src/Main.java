import java.util.Scanner;
class MyCalculator {
    public long power(int number1, int number2) throws Exception{
        if (number1 < 0 || number2 < 0){
            throw new Exception("n or p should not be negative.");
        }
        if (number1 == 0 && number2 == 0){
            throw new Exception("n and p should not be zero.");
        }
        return (int)Math.pow(number1, number2);
    }
}

public class Main {
    public static final MyCalculator mc = new MyCalculator();
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (in .hasNextInt()) {
            int number1 = in .nextInt();
            int number2 = in .nextInt();

            try {
                System.out.println(mc.power(number1, number2));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}