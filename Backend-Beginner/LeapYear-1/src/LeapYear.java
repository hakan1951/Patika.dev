import java.util.Scanner;
/*
A leap year is a year with 366 days instead of 365 in the Gregorian calendar.
This extra day (leap day) is obtained by adding February 29 to February, which is normally 28 days.

How to Calculate a Leap Year?

As a general rule, leap years are years that are a multiple of 4:

Like 1988, 1992, 1996, 2000, 2004, 2008, 2012, 2016, 2020, 2024.
Years that are a multiple of 100 are leap years that are only divisible by 400 without a remainder:
For example, the years 1200, 1600, 2000 are leap years, but 1700, 1800, and 1900 are not leap years.

The reason why only those exactly divisible by 400 are considered leap years is
to correct the error that an astronomical year is approximately 365.242 days, not 365.25 days.
*/
public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = sc.nextInt();
        sc.close();

        if (year % 4 == 0) {
            if (year % 400 != 0) {
                System.out.println(year + " is a leap year.");
            } else {
                System.out.println(year + " is not a leap year.");
            }
        } else {
            System.out.println(year + " is not a leap year.");
        }
    }
}