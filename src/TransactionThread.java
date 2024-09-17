public class TransactionThread implements Runnable {
    private final BankAccount account;
    private final double amount;
    private final boolean deposit;

    public TransactionThread(BankAccount account, double amount, boolean deposit) {
        this.account = account;
        this.amount = amount;
        this.deposit = deposit;
    }

    @Override
    public void run() {
        if (deposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
        System.out.println("Final balance: " + account.getBalance());
    }
}
