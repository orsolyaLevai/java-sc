package com.supercharge.bank.model;

import com.supercharge.bank.transaction.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * This class is for the client's of the bank. It contains the user/client
 * his/her fullname, money and a transaction history.
 */
public class Client {
    private String firstName;
    private String lastName;

    private BigDecimal amountOfMoney;

    private List<Transaction> transactionHistory;

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.amountOfMoney = BigDecimal.ZERO;
        this.transactionHistory = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(BigDecimal amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public void addTransactionToHistory(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    public void removeTransactionToHistory(Transaction transaction) {
        transactionHistory.remove(transaction);
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<Transaction> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

}
