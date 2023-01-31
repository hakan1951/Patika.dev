import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rowNumber: ");
        int rowNumber = sc.nextInt();
        System.out.print("Enter columnNumber: ");
        int columnNumber = sc.nextInt();

        System.out.format("MineSweeper(%dx%d) is starting.\n", rowNumber, columnNumber);
        MineSweeper ms = new MineSweeper(rowNumber,columnNumber);
        ms.run();
    }
}
