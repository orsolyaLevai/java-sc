import com.supercharge.bank.model.Client;
import com.supercharge.bank.transaction.TransactionDeposit;
import com.supercharge.bank.transaction.TransactionToAccount;
import com.supercharge.bank.transaction.TransactionWithdraw;

import java.math.BigDecimal;

public class Bank {

    public static void main(String[] args) {

        //The clients
        Client clientFrom = new Client("Ödön", "Szalay");
        clientFrom.setAmountOfMoney(new BigDecimal(100));

        Client clientTo = new Client("Elemér", "Kovács");

        //Transferable Money
        BigDecimal money = new BigDecimal(50);


        //Deposit
        System.out.println("Starting a deposit...\n");
        TransactionDeposit transactionDeposit = new TransactionDeposit(money);
        transactionDeposit.setClientFrom(clientFrom);

        System.out.println("Name: " + clientFrom.getFirstName() + " " + clientFrom.getLastName());
        System.out.println("Money before transaction: " + clientFrom.getAmountOfMoney());

        transactionDeposit.prepareTransaction();
        transactionDeposit.startTransaction();
        transactionDeposit.endTransaction();

        System.out.println("Money after transaction: " + clientFrom.getAmountOfMoney());


        //WithDraw
        System.out.println("\n\nStarting a withdraw...\n");
        TransactionWithdraw transactionWithdraw = new TransactionWithdraw(money);
        transactionWithdraw.setClientFrom(clientFrom);

        System.out.println("Name: " + clientFrom.getFirstName() + " " + clientFrom.getLastName());
        System.out.println("Money before transaction: " + clientFrom.getAmountOfMoney());

        transactionWithdraw.prepareTransaction();
        transactionWithdraw.startTransaction();
        transactionWithdraw.endTransaction();

        System.out.println("Money after transaction: " + clientFrom.getAmountOfMoney());


        //Transfer money

        //Transferable Money
        BigDecimal money2 = new BigDecimal(50);

        System.out.println("\n\nStarting a transfer between accounts...\n");
        clientFrom.setAmountOfMoney(new BigDecimal(100));

        TransactionToAccount transactionTransfer = new TransactionToAccount(money2);
        transactionTransfer.setClientFrom(clientFrom);
        transactionTransfer.setClientTo(clientTo);

        System.out.println("From: Name: " + clientFrom.getFirstName() + " " + clientFrom.getLastName());
        System.out.println("Money before transaction: " + clientFrom.getAmountOfMoney());
        System.out.println("To: Name: " + clientTo.getFirstName() + " " + clientTo.getLastName());
        System.out.println("Money before transaction: " + clientTo.getAmountOfMoney());

        transactionTransfer.prepareTransaction();
        transactionTransfer.startTransaction();
        transactionTransfer.endTransaction();

        System.out.println("ClientFrom: Money after transaction: " + clientFrom.getAmountOfMoney());
        System.out.println("ClientTo: Money after transaction: " + clientTo.getAmountOfMoney());

    }
}
