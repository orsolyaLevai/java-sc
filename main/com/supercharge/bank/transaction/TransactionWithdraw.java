package com.supercharge.bank.transaction;

import com.supercharge.bank.model.Client;
import com.supercharge.bank.model.TransactionType;
import com.supercharge.bank.util.Utils;

import java.math.BigDecimal;

/**
 * The class is for representing the withdraw certain amount of money from his/her bank account.
 */
public class TransactionWithdraw extends Transaction {

    public TransactionWithdraw(BigDecimal amountBeforeTransaction, BigDecimal transferedAmount) {

        LASTTRANSACTIONID += 1;
        this.transactionId = LASTTRANSACTIONID;
        this.transerDate = Utils.getCurrentDate();
        this.amountBeforeTransaction = amountBeforeTransaction;
        this.transferedAmount = transferedAmount;
        this.transactionType = TransactionType.WITHDRAW;

    }


    /**
     * It sets the client for clientFrom.
     * @param clientFrom Client: the client who's started the withdraw process
     */
    public void setClientFrom(Client clientFrom) {

        this.clientFrom = clientFrom;

    }


    /**
     * This is for preparing the withdraw. It controls whether the supporting systems are ready
     * @return boolean: if the supporting system are ready or not
     */
    @Override
    public boolean prepareTransaction() {

        return true;

    }


    /**
     * It executes the withdraw.
     * @return Transaction:
     */
    @Override
    public Transaction startTransaction() {
        BigDecimal moneyOfClientFrom = clientFrom.getAmountOfMoney().subtract(transferedAmount);
        clientFrom.setAmountOfMoney(moneyOfClientFrom);

        return this;

    }


    /**
     * It ends the withdraw: add the transaction to the history close database, restore if it is necessarily.
     * @return boolean: if it was successful or not
     */
    @Override
    public boolean endTransaction() {
        clientFrom.addTransactionToHistory(this);

        return true;

    }
}
