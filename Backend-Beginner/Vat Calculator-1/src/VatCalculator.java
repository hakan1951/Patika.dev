import java.util.Scanner;

/* (Vat = Value Added Tax)
        Write a program that calculates the VAT value and the VAT amount of the money value received from the user and prints it on the screen.
        (Note: Take the VAT amount as 18%)
        Price without VAT = 10;
        Price with VAT = 11.8;
        VAT amount = 1.8;

        If the amount entered is between 0 and 1000 TL, the VAT rate is 18%,
        if the amount is greater than 1000 TL, write the program that calculates the VAT amount as 8%.
*/

public class VatCalculator {
    public static void main(String[] args) {

        //Scanner opened.
        Scanner sc = new Scanner(System.in);

        //User input.
        System.out.print("Enter the price(TL): ");
        double price = sc.nextDouble();
        sc.close();

        double vatPercent = (price >=1000 ? 0.18 : 0.08);
        double vat = price * vatPercent;
        //Result
        System.out.println("The VAT amount: " + vat + " TL");
        
    }
}
