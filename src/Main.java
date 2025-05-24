import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Account> accounts = new ArrayList<Account>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to Banking System\n" + "1. Sign up\n" + "2. Log in\n" + "3. Exit\n");
            String choice = sc.nextLine();

            if (choice.equals("1")) {
                signup(sc);
            } else if (choice.equals("2")) {
                login(sc);
            } else if (choice.equals("3")) {
                System.out.println("Thank you for using Banking System");
                return;
            } else {
                System.out.println("Invalid option");
            }
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

                case  "logout": System.out.println("Logged out");
                                return;
                case   "transfer":
                    System.out.println("Please enter the account number: ");
                    String transferAccountName = sc.nextLine();
                    System.out.println("Please enter the amount to transfer: ");
                    Integer transferAmount = sc.nextInt();

                    boolean accountExists = false;
                    for(Account acc : accounts) {
                        if(acc.getUsername().equals(transferAccountName)) {
                            acc.deposit(transferAmount);
                            ac.withdraw(transferAmount);
                            System.out.println("Transfered acmount: " + transferAmount  + " from " + ac.getUsername() + " to " + acc.getUsername());
                            ac.display();
                            accountExists = true;
                            break;
                        }
                    }
                    if(!accountExists) {
                        System.out.println("Account does not exist");
                    }
                    break;


            }

        }
    }
    public static void login (Scanner sc) {
        System.out.println("Welcome to Banking System\n Plese enter your username: ");
        String username = sc.nextLine();
        System.out.println("Please enter your passcode: ");
        int passcode = sc.nextInt();
        sc.nextLine();
        for (Account ac : accounts) {
            if(ac.getUsername().equals(username) && ac.getPasscode()==passcode) {
                System.out.println("Login Successful");
                operations(sc, ac);
                return;
            }
        }
    }


}