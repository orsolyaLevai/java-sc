package com.supercharge.bank.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The class is an universal class for the different transactions.
 * Date transferDate: when the transaction was born
 * BigDecimal transferedAmount: the amount of money which was transferred
 * BigDecimal amountBeforeTransaction: the amount of money which was before the transaction
 * String transactionType: what kind of transaction
 */
public abstract class Transaction {

    protected Date transerDate;
    protected BigDecimal transferedAmount;
    protected BigDecimal amountBeforeTransaction;
    protected TransactionType transactionType;


    /**
     * The method is an "interface" for preparing transactions i.e. the supporting systems are ready.
     * @return boolean: the supporting system are ready or not.
     */
    public abstract boolean prepareTransaction();


    /**
     * The method is an "interface" for executing transactions.
     * @return Transaction: it returns with the transaction details.
     */
    public abstract Transaction startTransaction();

    /**
     * The method ends the transaction.
     * @return boolean: restore the original state, if the transaction was unsuccessful and send an "end" message
     * for the supperting systems
     */
    public abstract boolean endTransaction();
}
