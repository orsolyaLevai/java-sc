package com.supercharge.bank.model;

import java.math.BigDecimal;
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

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<Transaction> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }
}
