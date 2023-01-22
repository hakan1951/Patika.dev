import java.util.Scanner;
/*
Aries : March 21 - April 20
Taurus : April 21 - May 21
Gemini: May 22 - June 22
Cancer Zodiac Sign: June 23 - July 22
Leo Zodiac Sign: July 23 - August 22
Virgo Zodiac Sign: August 23 - September 22
Libra Zodiac Sign: September 23 - October 22
Scorpio: October 23 - November 21
Sagittarius : November 22 - December 21
Capricorn: December 22 - January 21
Aquarius: January 22 - February 19
Pisces: February 20 - March 20
*/
public class ZodiacSign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your birthday(WW-MM-YYYY): ");
        String birthdate = sc.nextLine();

        int day = Integer.parseInt(birthdate.substring(0,2));
        int month = Integer.parseInt(birthdate.substring(3,5));
        String zodiacSign = "";

        if ((month == 3 && day >= 21) || (month == 4 && day <= 20)){
            zodiacSign = "Aries";
        } else if ((month == 4) || (month == 5 && day <= 21)){
            zodiacSign = "Taurus";
        } else if ((month == 5) || (month == 6 && day <= 21)){
            zodiacSign = "Gemini";
        } else if ((month == 6) || (month == 7 && day <= 22)){
            zodiacSign = "Cancer";
        } else if ((month == 7) || (month == 8 && day <= 22)){
            zodiacSign = "Leo";
        } else if ((month == 8) || (month == 9 && day <= 22)){
            zodiacSign = "Virgo";
        } else if ((month == 9) || (month == 10 && day <= 22)){
            zodiacSign = "Libra";
        } else if ((month == 10) || (month == 11 && day <= 21)){
            zodiacSign = "Scorpio";
        } else if ((month == 11) || (month == 12 && day <= 21)){
            zodiacSign = "Sagittarius";
        } else if ((month == 12) || (month == 1 && day <= 21)){
            zodiacSign = "Capricorn";
        } else if ((month == 1) || (month == 2 && day <= 19)){
            zodiacSign = "Aquarius";
        } else if ((month == 2) || (month == 3)){
            zodiacSign = "Pisces";
        }
        System.out.println("Your zodiac sign: " + zodiacSign);
    }
}
