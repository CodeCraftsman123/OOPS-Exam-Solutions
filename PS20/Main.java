import java.util.ArrayList;
import java.util.List;

// Define the BankingAccount interface
interface BankingAccount {
    void deposit(double amount);
    void withdraw(double amount);
    void transfer(BankingAccount toAccount, double amount);
    void viewTransactions();
}

// Abstract class that implements the BankingAccount interface
abstract class AbstractBankingAccount implements BankingAccount {
    protected String accountNumber;
    protected double balance;
    protected List<String> transactions;

    public AbstractBankingAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: $" + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add("Withdrew: $" + amount);
        } else {
            transactions.add("Failed Withdrawal: $" + amount + " (Insufficient Funds)");
        }
    }

    @Override
    public void transfer(BankingAccount toAccount, double amount) {
        if (balance >= amount) {
            withdraw(amount);
            toAccount.deposit(amount);
            transactions.add("Transferred: $" + amount + " to Account: " + toAccount.getAccountNumber());
        } else {
            transactions.add("Failed Transfer: $" + amount + " to Account: " + toAccount.getAccountNumber() + " (Insufficient Funds)");
        }
    }

    @Override
    public void viewTransactions() {
        System.out.println("Transactions for Account: " + accountNumber);
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }
}

// SavingsAccount class
class SavingsAccount extends AbstractBankingAccount {
    private static final double INTEREST_RATE = 0.01; // Example interest rate

    public SavingsAccount(String accountNumber) {
        super(accountNumber);
    }

    public void applyInterest() {
        double interest = balance * INTEREST_RATE;
        deposit(interest);
        transactions.add("Interest Applied: $" + interest);
    }
}

// CheckingAccount class
class CheckingAccount extends AbstractBankingAccount {
    private static final double OVERDRAFT_LIMIT = 100.0;

    public CheckingAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public void withdraw(double amount) {
        if (balance + OVERDRAFT_LIMIT >= amount) {
            balance -= amount;
            transactions.add("Withdrew: $" + amount);
        } else {
            transactions.add("Failed Withdrawal: $" + amount + " (Exceeded Overdraft Limit)");
        }
    }
}

// Bank class to manage accounts
class Bank {
    private List<BankingAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void createSavingsAccount(String accountNumber) {
        accounts.add(new SavingsAccount(accountNumber));
    }

    public void createCheckingAccount(String accountNumber) {
        accounts.add(new CheckingAccount(accountNumber));
    }

    public BankingAccount findAccount(String accountNumber) {
        for (BankingAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void deposit(String accountNumber, double amount) {
        BankingAccount account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    public void withdraw(String accountNumber, double amount) {
        BankingAccount account = findAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        BankingAccount fromAccount = findAccount(fromAccountNumber);
        BankingAccount toAccount = findAccount(toAccountNumber);
        if (fromAccount != null && toAccount != null) {
            fromAccount.transfer(toAccount, amount);
        } else {
            System.out.println("One or both accounts not found: " + fromAccountNumber + ", " + toAccountNumber);
        }
    }

    public void viewTransactions(String accountNumber) {
        BankingAccount account = findAccount(accountNumber);
        if (account != null) {
            account.viewTransactions();
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }
}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        
        bank.createSavingsAccount("SA123");
        bank.createCheckingAccount("CA123");

        bank.deposit("SA123", 500);
        bank.deposit("CA123", 1000);
        
        bank.withdraw("SA123", 100);
        bank.withdraw("CA123", 1100); // Should allow due to overdraft

        bank.transfer("SA123", "CA123", 50);

        bank.viewTransactions("SA123");
        bank.viewTransactions("CA123");
    }
}