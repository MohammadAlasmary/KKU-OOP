import java.util.Random;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        System.out.println("Account created with initial balance: $" + balance);
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to deposit a non-positive amount: $" + amount);
        }
    }

    public synchronized boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew $" + amount + ". New balance: $" + balance);
            return true;
        } else if (amount <= 0) {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw a non-positive amount: $" + amount);
            return false;
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw $" + amount + " but only had $" + balance + ". Withdrawal failed.");
            return false;
        }
    }

    public synchronized double getBalance() {
        return balance;
    }
}

class TransactionTask implements Runnable {
    private BankAccount account;
    private Random random = new Random();
    private int numberOfTransactions;

    public TransactionTask(BankAccount account, int numberOfTransactions) {
        this.account = account;
        this.numberOfTransactions = numberOfTransactions;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started.");
        for (int i = 0; i < numberOfTransactions; i++) {
            double amount = random.nextDouble() * 100;
            if (random.nextBoolean()) {
                account.deposit(amount);
            } else {
                account.withdraw(amount);
            }
            try {
                Thread.sleep(random.nextInt(50));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println(Thread.currentThread().getName() + " was interrupted.");
            }
        }
        System.out.println(Thread.currentThread().getName() + " finished.");
    }
}

public class BankSimulation {

    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount(1000.0);

        int numberOfThreads = 5;
        int transactionsPerThread = 20;

        Thread[] threads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(new TransactionTask(sharedAccount, transactionsPerThread), "Thread-" + (i + 1));
            threads[i].start();
        }

        for (int i = 0; i < numberOfThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.err.println("Main thread interrupted while waiting for other threads.");
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\nAll threads finished.");
        System.out.println("Final account balance: $" + sharedAccount.getBalance());
    }
}
