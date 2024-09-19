public class BankAccount {
    final private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        System.out.println("Your balance is: " + balance + " BDT and deposited: " + amount + " BDT");
        balance += amount;
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            System.out.println("Your balance is: " + balance + " BDT and withdrew: " + amount + " BDT");
            balance -= amount;
        } else {
            System.out.println("Your balance is: " + balance + " BDT and failed to withdraw: " + amount + " BDT due to insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
