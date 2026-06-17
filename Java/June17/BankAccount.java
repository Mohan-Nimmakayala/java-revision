import java.util.*;

public class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount() {
        this("AC000", "Unknown User");
    }

    public BankAccount(String accountNumber, String holderName) {
        this(accountNumber, holderName, 0.0);
    }

    public BankAccount(String accountNumber, String holderName, double balance) {
        if (accountNumber == null || accountNumber.isBlank())
            throw new IllegalArgumentException("Account number cannot be empty");
        if (holderName == null || holderName.isBlank())
            throw new IllegalArgumentException("Holder name cannot be empty");
        if (balance < 0)
            throw new IllegalArgumentException("Balance cannot be negative");

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public BankAccount(BankAccount other) {
        if (other == null)
            throw new IllegalArgumentException("Cannot copy a null Bank Account");

        this.accountNumber = other.accountNumber;
        this.holderName = other.holderName;
        this.balance = other.balance;
        this.transactionHistory = new ArrayList<>(other.transactionHistory);
    }

    public BankAccount deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Invalid deposit amount value entered");

        this.balance += amount;
        transactionHistory.add("Deposited: " + amount + " | Balance: " + this.balance);
        return this;
    }

    public BankAccount withdraw(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Invalid withdrawal amount value entered");
        if (amount > this.balance)
            throw new IllegalArgumentException("Insufficient funds");

        this.balance -= amount;
        transactionHistory.add("Withdrew: " + amount + " | Balance: " + this.balance);
        return this;
    }

    public void display() {
        System.out.println("Account Details: ");
        System.out.println("Account Number : " + this.accountNumber);
        System.out.println("Holder Name    : " + this.holderName);
        System.out.println("Balance        : " + this.balance);
        System.out.println("Transactions   :");
        if (transactionHistory.isEmpty())
            System.out.println("No transactions yet");
        else {
            for (String entry : transactionHistory)
                System.out.println(" >> " + entry);
        }
    }

    public void register(AuditService service) {
        service.track(this);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }
}