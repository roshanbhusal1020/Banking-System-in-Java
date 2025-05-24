import java.util.ArrayList;

public class Account {

    private String username;
    private String id;
    private int passcode;
    private double balance;


    public Account (String username, int passcode) {
        this.username = username;
//        this.id = id;
        this.passcode = passcode;
//        this.balance = balance;
    }

    public String getUsername() {
        return this.username;
    }
    public int getPasscode() {
        return this.passcode;
    }

    public void deposit(double amount) {
        this.balance += amount;

    }
    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void display() {
        if (Double.isNaN(balance)){
            System.out.println("No balance");
            System.out.println("Username = " +username + "\n Password = " + passcode );
        }
        else {
            System.out.println("Total balance: " + this.balance);
            System.out.println("Username = " +username + "\n Password = " + passcode );

        }
    }
}
