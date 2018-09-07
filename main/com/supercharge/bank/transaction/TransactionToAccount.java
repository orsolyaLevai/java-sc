package com.supercharge.bank.transaction;

import com.supercharge.bank.model.Client;
import com.supercharge.bank.model.TransactionType;
import com.supercharge.bank.util.Utils;

import java.math.BigDecimal;

/**
 * The class is for representing the transaction certain amount of money from his/her bank account to another.
 */
public class TransactionToAccount extends Transaction {
    private Client clientTo;

    public TransactionToAccount(BigDecimal amountBeforeTransaction, BigDecimal transferedAmount) {

        LASTTRANSACTIONID += 1;
        this.transactionId = LASTTRANSACTIONID;
        this.transerDate = Utils.getCurrentDate();
        this.amountBeforeTransaction = amountBeforeTransaction;
        this.transferedAmount = transferedAmount;
        this.transactionType = TransactionType.WITHDRAW;

    }


    /**
     * It sets the client for clientFrom.
     *
     * @param clientFrom Client: the client who's started the transfer process
     */
    public void setClientFrom(Client clientFrom) {

        this.clientFrom = clientFrom;

    }


    /**
     * It sets the client for clientTo.
     *
     * @param clientTo Client: the client who's got the money
     */
    public void setClientTo(Client clientTo) {

        this.clientFrom = clientFrom;

    }


    /**
     * This is for preparing the transfer between accounts. It controls whether the supporting systems are ready
     *
     * @return boolean: if the supporting system are ready or not
     */
    @Override
    public boolean prepareTransaction() {

        return true;
    }


    /**
     * It executes the transfer process.
     *
     * @return Transaction:
     */
    @Override
    public Transaction startTransaction() {
        BigDecimal moneyOfClientFrom = clientFrom.getAmountOfMoney().subtract(transferedAmount);
        clientFrom.setAmountOfMoney(moneyOfClientFrom);

        BigDecimal moneyOfClientTo = clientFrom.getAmountOfMoney().add(transferedAmount);
        clientTo.setAmountOfMoney(moneyOfClientTo);

        return this;
    }


    /**
     * It ends the withdraw: add the transaction to the history close database, restore if it is necessarily.
     *
     * @return boolean: if it was successful or not
     */
    @Override
    public boolean endTransaction() {
        clientFrom.addTransactionToHistory(this);
        clientTo.addTransactionToHistory(this);

        return true;
    }
    
}
