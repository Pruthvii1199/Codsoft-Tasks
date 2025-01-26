import java.util.Scanner;

// Class to represent the user's bank account on the ATN interface
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be greater than 0.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully Withdrew: $" + amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient Balance.");
            return false;
        } else {
            System.out.println("Withdrawal amount must be greater than 0.");
            return false;
        }
    }
}

// Class to represent the ATM machine
class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n-----Welcome to ATM-----");
            System.out.println("===== ATM Menu =====");
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next();
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney(scanner);
                    break;
                case 3:
                    withdrawMoney(scanner);
                    break;
                case 4:
                    System.out.println("\nThank you for using the ATM. Goodbye!");
                    System.out.println("------ Visit Again ------");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private void checkBalance() {
        System.out.println("Your Current Balance is: $" + userAccount.getBalance());
    }

    private void depositMoney(Scanner scanner) {
        System.out.print("Enter Amount to Deposit: $");

        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid amount: $");
            scanner.next();
        }

        double amount = scanner.nextDouble();
        userAccount.deposit(amount);
    }

    private void withdrawMoney(Scanner scanner) {
        System.out.print("Enter Amount to Withdraw: $");

        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid amount: $");
            scanner.next();
        }

        double amount = scanner.nextDouble();
        userAccount.withdraw(amount);
    }
}

// Main class to run the program of the ATM interface
public class ATMInterface {
    public static void main(String[] args) {
        // Initialize a bank account with an initial balance in the users account
        BankAccount userAccount = new BankAccount(10000.00); // Example initial balance in the account

        // Create an ATM interface and connect it to the user's bank account
        ATM atm = new ATM(userAccount);

        // Display the ATM menu for the user
        atm.showMenu();
    }
}
