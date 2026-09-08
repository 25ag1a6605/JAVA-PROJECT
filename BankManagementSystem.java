import java.util.Scanner;

class BankAccount {
    private String name;
    private long accountNumber;
    private double balance;
    BankAccount(String name, long accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Amount deposited successfully!");
        } else {
            System.out.println("Invalid amount!");
        }
    }
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Amount withdrawn successfully!");
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }
    void displayDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Holder : " + name);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Balance        : ₹" + balance);
    }
}

public class BankManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== BANK MANAGEMENT SYSTEM =====");

        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter account number: ");
        long accountNumber = sc.nextLong();

        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        BankAccount account =
            new BankAccount(name, accountNumber, balance);

        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Display Account Details");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter deposit amount: ");
                    double deposit = sc.nextDouble();
                    account.deposit(deposit);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdraw = sc.nextDouble();
                    account.withdraw(withdraw);
                    break;

                case 3:
                    account.displayDetails();
                    break;

                case 4:
                    System.out.println("Thank you for using our bank!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
