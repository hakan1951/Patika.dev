import java.util.Scanner;

/*      Write a program that calculates the area of the triangle
        whose three side lengths you get from the user.

        Formula
        Perimeter = 2𝑢
        𝑢 = (a+b+c) / 2
        Area * Area = 𝑢 * (𝑢 − 𝑎)* (𝑢 − 𝑏) * (𝑢 − 𝑐)*/

public class Triangle {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //User input.
        System.out.print("Enter first side length:  ");
        double s1 = sc.nextDouble();
        System.out.print("Enter second side length:  ");
        double s2 = sc.nextDouble();
        System.out.print("Enter third side length:  ");
        double s3 = sc.nextDouble();
        sc.close();

        //Calculation.
        double u = (s1 + s2 + s3)/2 ;
        double perimeter = 2*u;
        double area = Math.sqrt(u * (u-s1) * (u-s2) * (u-s3));

        //Result
        System.out.println("The area of the triangle: " + area);

    }
}