import java.util.Scanner;

/*
Write a program that finds the area of slice of circle with radius r and measure 𝛼 of the central angle.
        Take 𝜋 = 3.14.
        Formula : (𝜋 * (r*r) * 𝛼) / 360
*/

public class Circle {
    public static void main(String[] args) {
        final double pi = 3.14;

        //User input.
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius:  ");
        double radius = sc.nextDouble();
        System.out.print("Enter the central angle:  ");
        double angle = sc.nextDouble();
        sc.close();

        //Calculation.
        double area = (pi * (radius*radius) * angle) / 360;
        //Result
        System.out.format("The area of the triangle: %.2f", area);

    }

}