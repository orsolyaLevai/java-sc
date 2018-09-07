package com.supercharge.bank.model;

import java.math.BigDecimal;

/**
 * The class is for representing the deposit and withdraw certain amount of money from his/her bank account.
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

        BigDecimal moneyOfClientFrom = clientFrom.getAmountOfMoney().subtract(transferedAmount);
        clientFrom.setAmountOfMoney(moneyOfClientFrom);

        return this;

    }


    /**
     * it ends the deposit: add the transaction to the history close database, restore if it is necessarily.
     * @return
     */
    @Override
    public boolean endTransaction() {

        clientFrom.addTransactionToHistory(this);

        return true;

    }
}
