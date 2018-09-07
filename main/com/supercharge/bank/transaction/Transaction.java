package com.supercharge.bank.transaction;

import com.supercharge.bank.model.Client;
import com.supercharge.bank.model.TransactionType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The class is an universal class for the different transactions.
 * Date transferDate: when the transaction was born
 * BigDecimal transferedAmount: the amount of money which was transferred
 * String transactionType: what kind of transaction
 */
public abstract class Transaction {

    protected static Long LASTTRANSACTIONID = 0L;

    protected Long transactionId;
    protected Client clientFrom;
    protected Date transerDate;
    protected BigDecimal transferedAmount;
    protected TransactionType transactionType;


    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Client getClientFrom() {
        return clientFrom;
    }

    public void setClientFrom(Client clientFrom) {
        this.clientFrom = clientFrom;
    }

    public Date getTranserDate() {
        return transerDate;
    }

    public void setTranserDate(Date transerDate) {
        this.transerDate = transerDate;
    }

    public BigDecimal getTransferedAmount() {
        return transferedAmount;
    }

    public void setTransferedAmount(BigDecimal transferedAmount) {
        this.transferedAmount = transferedAmount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

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
