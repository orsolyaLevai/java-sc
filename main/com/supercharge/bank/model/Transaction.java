package com.supercharge.bank.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The class is an universal class for the different transactions.
 * Date transferDate: when the transaction was born
 * BigDecimal transferedAmount: the amount of money which was transferred
 * BigDecimal amountBeforeTransaction: the amount of money which was before the transaction
 */
public abstract class Transaction {

    private Date transerDate;
    private BigDecimal transferedAmount;
    private BigDecimal amountBeforeTransaction;

    public abstract void doTransaction();
}
