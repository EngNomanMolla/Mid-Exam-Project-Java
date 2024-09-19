import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        BankAccount account1 = new BankAccount("Account_047", 220500);
        BankAccount account2 = new BankAccount("Account_2023000010053", 231000);


        TransactionThread depositToAccount1 = new TransactionThread(account1, true, 31500);  // Deposit
        TransactionThread withdrawFromAccount2 = new TransactionThread(account2, false, 7350);  // Withdraw


        depositToAccount1.start();
        withdrawFromAccount2.start();


        try {
            depositToAccount1.join();
            withdrawFromAccount2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("Total current balance of " + account1.getAccountNumber() + ": " + account1.getBalance() + " BDT");
        System.out.println("Total current balance of " + account2.getAccountNumber() + ": " + account2.getBalance() + " BDT");
    }


}
