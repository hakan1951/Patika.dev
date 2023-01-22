import java.util.Scanner;
/*
Chinese astrology is a type of astrology that has been used for 4000 thousand years and describes people with 12 different signs and symbols.
The Chinese Zodiac is an animal ring in which these 12 signs are evenly spaced (10 degrees wide) and has little to do with the stars.
How is the Chinese Zodiac calculated?
When calculating the Chinese zodiac, it is based on the remainder of the 12th division of the person's birth year.

Date of Birth 12% = 0 ➜ Monkey
Date of Birth 12% = 1 ➜ Rooster
Date of Birth 12% = 2 ➜ Dog
Date of Birth 12% = 3 ➜ Pig
Date of Birth 12% = 4 ➜ Mice
Date of Birth 12% = 5 ➜ Ox
Date of Birth 12% = 6 ➜ Tiger
Date of Birth 12% = 7 ➜ Rabbit
Date of Birth 12% = 8 ➜ Dragon
Date of Birth 12% = 9 ➜ Snake
Date of Birth 12% = 10 ➜ Horse
Date of Birth 12% = 11 ➜ Sheep
*/
public class ChineseZodiac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your birth year (YYYY): ");
        int year = sc.nextInt();
        sc.close();
        int remaining = year % 12;
        String zodiacSign = "";

        switch (remaining){
            case 0 -> zodiacSign = "Monkey";
            case 1 -> zodiacSign = "Rooster";
            case 2 -> zodiacSign = "Dog";
            case 3 -> zodiacSign = "Pig";
            case 4 -> zodiacSign = "Mice";
            case 5 -> zodiacSign = "Ox";
            case 6 -> zodiacSign = "Tiger";
            case 7 -> zodiacSign = "Rabbit";
            case 8 -> zodiacSign = "Dragon";
            case 9 -> zodiacSign = "Snake";
            case 10 -> zodiacSign = "Horse";
            case 11 -> zodiacSign = "Sheep";
        }
        System.out.println("Your zodiac sign: " + zodiacSign);
    }
}
