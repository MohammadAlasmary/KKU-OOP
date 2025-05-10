import java.util.ArrayList;
import java.util.List;

class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    protected double balance;
    private static int nextAccountNumber = 1000;

    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountNumber = nextAccountNumber++;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("$" + amount + " deposited into account " + accountNumber);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void deposit(double amount, String message) {
        deposit(amount);
        System.out.println("Deposit message: " + message);
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("$" + amount + " withdrawn from account " + accountNumber);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount for account " + accountNumber);
        }
    }

    public void calculateBalance() {
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountHolderName, double initialBalance, double interestRate) {
        super(accountHolderName, initialBalance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void calculateBalance() {
        balance += balance * interestRate;
        System.out.println("Interest added. New balance for account " + getAccountNumber() + ": $" + String.format("%.2f", balance));
    }

    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Interest Rate: " + String.format("%.2f%%", interestRate * 100));
    }
}

class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountHolderName, double initialBalance, double overdraftLimit) {
        super(accountHolderName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance + overdraftLimit) >= amount) {
            balance -= amount;
            System.out.println("$" + amount + " withdrawn from account " + getAccountNumber());
        } else {
            System.out.println("Withdrawal exceeds available balance and overdraft limit for account " + getAccountNumber());
        }
    }

    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Overdraft Limit: $" + String.format("%.2f", overdraftLimit));
    }
}

public class BankingSystem {
    public static void main(String[] args) {

        SavingsAccount savingsAcc1 = new SavingsAccount("John Doe", 1000.00, 0.05);
        SavingsAccount savingsAcc2 = new SavingsAccount("Jane Smith", 500.00, 0.03);


        CurrentAccount currentAcc1 = new CurrentAccount("Peter Jones", 1500.00, 200.00);
        CurrentAccount currentAcc2 = new CurrentAccount("Linda Brown", 2000.00, 300.00);

        System.out.println("--- Account Details ---");
        savingsAcc1.displayAccountDetails();
        System.out.println();
        currentAcc1.displayAccountDetails();
        System.out.println();

        System.out.println("--- Deposits ---");
        savingsAcc1.deposit(200.00);
        currentAcc1.deposit(300.00, "Salary deposit");
        System.out.println();

        System.out.println("--- Withdrawals ---");
        savingsAcc1.withdraw(150.00);
        currentAcc1.withdraw(1800.00);
        currentAcc2.withdraw(2500.00);
        System.out.println();

        System.out.println("--- Calculate Balance (Savings) ---");
        savingsAcc1.calculateBalance();
        savingsAcc2.calculateBalance();
        System.out.println();

        System.out.println("--- Updated Account Details ---");
        savingsAcc1.displayAccountDetails();
        System.out.println();
        currentAcc1.displayAccountDetails();
        System.out.println();
        currentAcc2.displayAccountDetails();
    }
}
