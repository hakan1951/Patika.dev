import java.util.Scanner;
/*  Simple ATM machine
    1 = Show Balance
    2 = Withdrawal
    3 = Deposit
    q = Exit      */
public class AtmMachine {
    public static void main(String[] args) {
        System.out.print("""
                Enter the operations below.\s
                1 = Show Balance
                2 = Withdrawal
                3 = Deposit
                q = Exit
                """);
        Scanner sc = new Scanner(System.in);
        int balance = 1000;
        int amount;
        boolean loop = true;

        while (loop) {
            System.out.print("Your operation:");
            String operation = sc.nextLine();
            switch (operation) {
                case "1" -> System.out.println("Your balance : " + balance);
                case "2" -> {
                    System.out.print("Enter the amount that you want to withdraw: ");
                    amount = sc.nextInt();
                    sc.nextLine();
                    if (amount <= balance) {
                        balance -= amount;
                    } else {
                        System.out.println("You cannot withdraw more than " + balance + ".");
                    }
                    System.out.println("Your balance : " + balance);
                }
                case "3" -> {
                    System.out.println("Enter the amount that you want to deposit: ");
                    amount = sc.nextInt();
                    sc.nextLine();
                    balance += amount;
                    System.out.println("Your new balance : " + balance);
                }
                case "q" -> {
                    System.out.println("Thanks.");
                    loop = false;
                }
                default ->
                        System.out.println("Invalid operation. Valid operations are '1'(show), '2'(withdraw), '3'(deposit) and 'q'(exit). Your balance : " + balance);
            }
        }
        sc.close();
    }
}
