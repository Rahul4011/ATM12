import java.util.Scanner;

public class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= userAccount.getBalance()) {
            userAccount.withdraw(amount);
            System.out.println("Amount withdrawn: " + amount);
        }

        else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            userAccount.deposit(amount);
            System.out.println("Amount deposited: " + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + userAccount.getBalance());
    }


    public static void main(String[] args) {

        BankAccount userAccount = new BankAccount(10000);

        ATM atm = new ATM(userAccount);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("ATM Interface:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;

                case 3:
                    atm.checkBalance();
                    break;

                case 4:
                    System.out.println("Exiting ATM. Have a nice day!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}

