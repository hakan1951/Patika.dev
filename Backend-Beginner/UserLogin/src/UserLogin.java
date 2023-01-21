import java.util.Scanner;
/*
If the password is wrong, ask the user whether he can reset his password,
if the user wants to reset it,
check that the new password must not be the same as the password he entered incorrectly,
if the passwords are the same;
the screen "Could not create password, please enter another password."
If there is no problem, write the program that says "Password created".
*/
public class UserLogin {

    public static void main(String[] args) {
        String username = "hkn123";
        String password = "11111";

        System.out.println("Welcome to Login Page.");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String un = sc.nextLine();
        System.out.print("Enter your password: ");
        String pw = sc.nextLine();

        if ((un.equals(username)) && (pw.equals(password))){
            System.out.println("Access granted.");
        } else if ((un.equals(username)) && !(pw.equals(password))){
            System.out.print("Access denied. Wrong password. ");
            System.out.print("Reset password?(1/0): ");
            String decision = sc.nextLine();
            if (decision.equals("1")){
                int trial = 3;
                while (trial > 0) {
                    System.out.print("Enter new password: ");
                    String pwNew = sc.nextLine();
                    if (pwNew.equals(password)) {
                        System.out.println("New pasword can not be the same as your current password. " +
                                "Enter another password.");
                        trial--;
                    } else {
                        System.out.println("New password created successfully.");
                        break;
                    }
                }

            }else{
                System.out.println("Closing the page.");
                System.exit(-1);
            }
        } else {
            System.out.println("Access denied. User not found.");
        }
        sc.close();
    }
}
