import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Account> accounts = new ArrayList<Account>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Banking System\n" + "1. Sign up\n" + "2. Log in\n" + "3. Exit\n");
        String choice = sc.nextLine();

        if (choice.equals("1")) {
            signup(sc);
        } else if (choice.equals("2")) {
            login(sc);
        } else if (choice.equals("3")) {
            System.out.println("Thank you for using Banking System");
            return;
        }

    }


    public static void signup(Scanner sc) {
        System.out.println("Welcome to Banking System");
        System.out.println("Please enter your username: ");
        String username = sc.nextLine();
        System.out.println("Please enter your passcode: ");
        Integer passcode = sc.nextInt();
        sc.nextLine();

        Account ac = new Account(username, passcode );
        accounts.add(ac);
        ac.display();
        operations(sc, ac);

    }

    public static void  operations(Scanner sc, Account ac) {
        while (true) {
            String input = sc.nextLine();

            switch (input) {
                case "deposit": Double depositValue = sc.nextDouble();
                                sc.nextLine();
                                ac.deposit(depositValue);
                                System.out.println("Deposited: " + depositValue );
                                ac.display();
                                break;
                case "withdraw": Double withdrawValue = sc.nextDouble();
                                sc.nextLine();
                                ac.withdraw(withdrawValue);
                                System.out.println("Withdrawn: " + withdrawValue );
                                ac.display();
                                break;

            }

        }
    }
    public static void login (Scanner sc) {
        System.out.println("Welcome to Banking System\n Plese enter your username: ");
        String username = sc.nextLine();
        System.out.println("Please enter your passcode: ");
        String passcode = sc.nextLine();
    }
}