import java.util.ArrayList;
import java.util.Scanner;

// Account Class
class Account {
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    // Constructor
    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: ₹" + initialBalance);
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: ₹" + amount);
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid amount!");
        }
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else if (amount > 0) {
            balance -= amount;
            transactionHistory.add("Withdrawn: ₹" + amount);
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Invalid amount!");
        }
    }

    // Check Balance
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    // Transaction History
    public void showTransactionHistory() {
        System.out.println("\nTransaction History:");
        for (String t : transactionHistory) {
            System.out.println(t);
        }
    }
}

// Main Class
public class BankSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial balance: ");
        double initialBalance = sc.nextDouble();

        Account acc = new Account(name, initialBalance);

        int choice;

        do {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    double dep = sc.nextDouble();
                    acc.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    double wit = sc.nextDouble();
                    acc.withdraw(wit);
                    break;

                case 3:
                    acc.checkBalance();
                    break;

                case 4:
                    acc.showTransactionHistory();
                    break;

                case 5:
                    System.out.println("Thank you for using the bank system!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}