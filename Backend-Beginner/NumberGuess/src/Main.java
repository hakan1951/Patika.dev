import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(101);

        Scanner sc = new Scanner(System.in);
        int wrongGuessCount = 0;
        int guess;
        int[] wrong = new int[7];
        boolean isWon = false;
        boolean isWrong = false;
        System.out.println("Enter your guess between 0-100");

        while (wrongGuessCount < 7) {
            System.out.print("Your guess: ");
            guess = sc.nextInt();

            if (guess < 0 || guess > 100) {
                if (isWrong) {
                    wrongGuessCount++;
                    System.out.println("Wrong guess. Remaining guess: " + (7-wrongGuessCount));
                } else {
                    isWrong = true;
                    System.out.println("You can enter a maximum of five wrong guesses. Enter a number between 0-100. There will be decrease next time. ");
                    System.out.println("Remaining wrong guess: " + (7-wrongGuessCount));
                }
                continue;
            }

            if (guess == number) {
                System.out.println("Right guess! Guessed number: " + number);
                isWon = true;
                break;
            } else {
                System.out.println("Wrong number!");
                if (guess > number) {
                    System.out.println(guess + " is greater than the number.");
                } else {
                    System.out.println(guess + " is smaller than the number.");
                }
                wrong[wrongGuessCount++] = guess;
                System.out.println("Remaining guess: " + (7 - wrongGuessCount));

            }
        }

        if (!isWon) {
            System.out.println("You lost! ");
            if (!isWrong) {
                System.out.println("Your guesses : " + Arrays.toString(wrong));
            }
        }

    }
}
