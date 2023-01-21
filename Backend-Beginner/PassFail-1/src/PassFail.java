import java.util.Scanner;
/*
Courses: Mathematics, Physics, Turkish, Chemistry, Music
        Passing Grade : 55

        If the course grade entered is not between 0 or 100,
        will not be included in the average.
*/
public class PassFail {
    public static void main(String[] args) {
        int passGrade = 55;
        Scanner sc = new Scanner(System.in);
        //User input.
        System.out.println("\n" + "Enter your grades correspondingly, please.");
        System.out.print("Mathematics : ");
        int math = sc.nextInt();
        System.out.print("Physics : ");
        int phys = sc.nextInt();
        System.out.print("Turkish : ");
        int turk = sc.nextInt();
        System.out.print("Chemisty : ");
        int chem = sc.nextInt();
        System.out.print("Music : ");
        int music = sc.nextInt();
        sc.close();

        checkGrade(math);
        checkGrade(phys);
        checkGrade(turk);
        checkGrade(chem);
        checkGrade(music);
        double avg = (math + phys + chem + turk +  music) /5;
        System.out.println(avg >= passGrade ? ("Passed.") : ("Failed."));
    }
    public static int checkGrade(int grade){
        if (!(grade >= 0 && grade <=100)){
            grade = 0; //Unknown grade -> 0.
        }
        return grade;
    }
}