
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccount {
    private double balance;
    private final List<String> transactionHistory;

    public BankAccount(double initialBalance) {
        if (!Double.isFinite(initialBalance) || initialBalance < 0) {
            throw new IllegalArgumentException("Invalid initial balance.");
        }

        balance = initialBalance;
        transactionHistory = new ArrayList<>();
        transactionHistory.add(
            String.format("Account opened: $%.2f", initialBalance)
        );
    }

    public boolean deposit(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Invalid amount. Enter a positive amount.");
            return false;
        }

        balance += amount;
        transactionHistory.add(
            String.format("Deposit: +$%.2f", amount)
        );

        System.out.printf("Deposit successful: $%.2f%n", amount);
        return true;
    }

    public boolean withdraw(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Invalid amount. Enter a positive amount.");
            return false;
        }

        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal declined.");
            return false;
        }

        balance -= amount;
        transactionHistory.add(
            String.format("Withdrawal: -$%.2f", amount)
        );

        System.out.printf("Withdrawal successful: $%.2f%n", amount);
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public void checkBalance() {
        System.out.printf("Current balance: $%.2f%n", balance);
    }

    public List<String> getTransactionHistory() {
        return Collections.unmodifiableList(transactionHistory);
    }
}
