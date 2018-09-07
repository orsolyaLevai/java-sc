package com.supercharge.bank.model;

import java.math.BigDecimal;

/**
 * The class is for representing the deposit and withdraw certain amount of money from his/her bank account.
 */
public class TransactionDeposit extends Transaction {

    public TransactionDeposit(BigDecimal amountBeforeTransaction, BigDecimal transferedAmount) {

        this.transerDate = Utils.getCurrentDate();
        this.amountBeforeTransaction = amountBeforeTransaction;
        this.transferedAmount = transferedAmount;
        this.transactionType = TransactionType.DEPOSIT;

    }

    @Override
    public boolean prepareTransaction() {
        return true;
    }

    @Override
    public Transaction startTransaction() {

    }
}
