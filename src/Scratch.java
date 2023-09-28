import java.util.Scanner;

// ATM Class
class ATM {

    // Attributes (provided)s
    private String name;
    private double balance;
    private int account_number;

    // Default Constructor (provided)
    public ATM() {
        // Initialize attributes with default values ( name = "Unknown" , balance = 0,
        // account_number = 0)
        this.name = "Unknown";
        this.balance = 0;
        this.account_number = 0;
    }

    // Parameterized Constructor (provided)
    public ATM(String name, double balance, int account_number) {
        // Initialize attributes with provided value
        this.name = name;
        this.balance = balance;
        this.account_number = account_number;
    }

    // Implement the remaining methods
    // - Implement getters and setters for 'name' and 'account_number'.
    // - Implement the 'deposit' method to add funds to the account.
    // - Implement the 'withdraw' method to withdraw funds from the account and
    // verify that the balance is greater than the amount to be withdrawn before
    // performing the withdrawal, you can use an if statement to check the condition
    // - Implement the 'checkBalance' method to return the account balance.

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccount_number() {
        return this.account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public void deposit(double amt) {
        balance = balance + amt;
    }

    public void withdraw(double amt) {
        if (balance >= amt) {
            balance = balance - amt;
        } else {
            System.out.println("Amount to be withdrawn exceeds current balance.");
        }
    }

    public double checkBalance() {
        return this.balance;
    }

}

// Main Class (provided)
public class Scratch {
    public static void main(String[] args) {
        // Create ATM objects, one with the default constructor and the rest with
        // parameters
        Scanner scanner = new Scanner(System.in);
        ATM accounts[] = new ATM[5];
        for (int i = 0; i < accounts.length; i++) {
            if (i == 0) {
                accounts[i] = new ATM();
                continue;
            }
            accounts[i] = new ATM();
            System.out.println("\nAccount #" + (i + 1) + ":");

            System.out.print("Name: ");
            accounts[i].setName(scanner.next());

            System.out.print("Balance: ");
            accounts[i].deposit(scanner.nextDouble());

            System.out.print("Account Number: ");
            accounts[i].setAccount_number(scanner.nextInt());
        }

        while (true) {
            System.out.print("\nATM Number: ");
            int selection = scanner.nextInt();
            System.out.println(
                    "1 - Deposit | 2 - Withdraw | 3 - Check Balance | 4 - Display Information | 0 - Terminate Program");
            switch (scanner.nextInt()) {
                // Deposit amount to the account balance
                case 1:
                    System.out.print("Amount to deposit: ");
                    accounts[selection].deposit(scanner.nextInt());
                    break;
                // Withdraw amount from the account balance
                case 2:
                    System.out.print("Amount to withdraw: ");
                    accounts[selection].withdraw(scanner.nextInt());
                    break;
                // Check balance for each account
                case 3:
                    System.out.println(accounts[selection].checkBalance());
                    break;
                // Display all information for the accounts
                case 4:
                    System.out.println("Name: " + accounts[selection].getName() + " | Balance: "
                            + accounts[selection].checkBalance() + " | Account Number: "
                            + accounts[selection].getAccount_number());
                    break;
                case 0:
                    System.out.print("Program terminated.");
                    scanner.close();
                    return;
            }
        }
    }
}
