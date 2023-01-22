import java.util.Scanner;
/*
Suggest to "Ski" if the temperature is less than 5.
Suggest the "Cinema" event if the temperature is between 5 and 15.
Suggest the "Picnic" event if the temperature is between 15 and 25.
Suggest the "Swimming" event if the temperature is greater than 25.
* */
public class Suggestion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the temperature: ");
        double t = sc.nextDouble();

        System.out.println(t<5? "Skiing" : ((t<15) ? "Cinema" : ((t<25) ? "Picnic" : "Swimming")));
    }
}
