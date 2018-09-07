import com.supercharge.bank.model.Client;
import com.supercharge.bank.model.Transaction;
import com.supercharge.bank.model.TransactionDeposit;

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
        TransactionDeposit transactionDeposit = new TransactionDeposit(money);
        transactionDeposit.setClientFrom(clientFrom);

        System.out.println("Name: " + clientFrom.getFirstName() + " " + clientFrom.getLastName());
        System.out.println("Money before transaction: " + clientFrom.getAmountOfMoney());

        transactionDeposit.prepareTransaction();
        transactionDeposit.startTransaction();
        transactionDeposit.endTransaction();

        System.out.println("Money after transaction: " + clientFrom.getAmountOfMoney());

    }
}
