import java.util.Scanner;
public class GpaCalculator {
    public static void main(String[] args) {

        //Scanner opened.
        Scanner sc = new Scanner(System.in);

        //User input.
        System.out.println("\n" + "Enter your grades correspondingly, please.");
        System.out.print("Mathematics : ");
        int math = sc.nextInt();
        System.out.print("Physics : ");
        int phys = sc.nextInt();
        System.out.print("Chemisty : ");
        int chem = sc.nextInt();
        System.out.print("Turkish : ");
        int turk = sc.nextInt();
        System.out.print("History : ");
        int hist = sc.nextInt();
        System.out.print("Music : ");
        int music = sc.nextInt();
        
        //Scanner closed.
        sc.close();

        //Calculation.
        double avg = (math + phys + chem + turk + hist + music) /6;

        //Result.
        System.out.println(avg >= 60 ? ("Passed.") : ("Failed."));
        System.out.println(); 

    }
}
