public class Main {
    public static void main(String[] args) {
        // Initialize bank accounts with initial balances
        BankAccount account1 = new BankAccount("Account_053", 0.00);
        BankAccount account2 = new BankAccount("Account_2023100010013", 10000.00); // Initial balance set to 10,000 for demonstration

        // Create transaction threads based on the given data
        Thread depositThread = new Thread(new TransactionThread(account1, 36750, true), "Deposit Thread");
        Thread withdrawThread = new Thread(new TransactionThread(account2, 9450, false), "Withdraw Thread");

        // Start the threads
        depositThread.start();
        withdrawThread.start();

        // Wait for threads to finish
        try {
            depositThread.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            System.out.print(e.getMessage());
        }

        // Display final balances
        System.out.println("Final balance for Account_047: " + account1.getBalance());
        System.out.println("Final balance for Account_2023000010053: " + account2.getBalance());
    }


}
