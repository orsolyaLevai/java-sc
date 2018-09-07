package com.supercharge.bank.transaction;

import com.supercharge.bank.model.Client;
import com.supercharge.bank.model.TransactionType;
import com.supercharge.bank.util.Utils;

import java.math.BigDecimal;

/**
 * The class is for representing the deposit certain amount of money to his/her bank account.
 */
public class TransactionDeposit extends Transaction {

    public TransactionDeposit(BigDecimal transferedAmount) {

        LASTTRANSACTIONID += 1;
        this.transactionId = LASTTRANSACTIONID;
        this.transerDate = Utils.getCurrentDate();
        this.transferedAmount = transferedAmount;
        this.transactionType = TransactionType.DEPOSIT;

    }


    /**
     * It sets the client for clientFrom.
     * @param clientFrom Client: the client who's started the deposit process
     */
    public void setClientFrom(Client clientFrom) {

        this.clientFrom = clientFrom;
        this.amountBeforeTransaction = clientFrom.getAmountOfMoney();

    }


    /**
     * This is for preparing the deposit. It controls whether the supporting systems are ready
     * @return boolean: if the supporting system are ready or not
     */
    @Override
    public boolean prepareTransaction() {

        return true;

    }


    /**
     * It executes the deposit.
     * @return Transaction:
     */
    @Override
    public Transaction startTransaction() {

        BigDecimal moneyOfClientFrom = clientFrom.getAmountOfMoney().add(transferedAmount);
        clientFrom.setAmountOfMoney(moneyOfClientFrom);

        return this;

    }


    /**
     * It ends the deposit: add the transaction to the history close database, restore if it is necessarily.
     * @return boolean: if it was successful or not
     */
    @Override
    public boolean endTransaction() {

        clientFrom.addTransactionToHistory(this);

        return true;

    }
}
