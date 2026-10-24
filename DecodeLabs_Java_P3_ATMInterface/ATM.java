
import java.util.List;
import java.util.Scanner;

public class ATM {
    private final BankAccount account;
    private final Scanner scanner;

    public ATM(BankAccount account, Scanner scanner) {
        this.account = account;
        this.scanner = scanner;
    }

    public void start() {
        boolean running = true;

        System.out.println("================================");
        System.out.println("          JAVA ATM");
        System.out.println("================================");

        while (running) {
            displayMenu();
            int choice = readMenuChoice();

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;

                case 2:
                    account.deposit(readAmount("Enter deposit amount: $"));
                    break;

                case 3:
                    account.withdraw(readAmount("Enter withdrawal amount: $"));
                    break;

                case 4:
                    displayTransactionHistory();
                    break;

                case 5:
                    running = false;
                    System.out.println("Thank you for using Java ATM!");
                    break;

                default:
                    System.out.println("Invalid choice. Select 1-5.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transaction History");
        System.out.println("5. Exit");
    }

    private int readMenuChoice() {
        while (true) {
            System.out.print("Choose an option (1-5): ");
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a whole number.");
            }
        }
    }

    private double readAmount(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                double amount = Double.parseDouble(input);

                if (Double.isFinite(amount) && amount > 0) {
                    return amount;
                }

                System.out.println("Enter a positive, valid amount.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a numeric amount.");
            }
        }
    }

    private void displayTransactionHistory() {
        List<String> history = account.getTransactionHistory();

        System.out.println("\n--- Transaction History ---");

        for (String transaction : history) {
            System.out.println(transaction);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(1000.00);
        ATM atm = new ATM(account, scanner);

        atm.start();
        scanner.close();
    }
}
