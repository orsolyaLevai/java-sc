package com.supercharge.bank.util;

import com.supercharge.bank.model.Client;
import com.supercharge.bank.transaction.Transaction;

public class PrintTransaction {
    private Client client;

    public PrintTransaction(Client client) {
        this.client = client;
    }

    public void printTransactions() {
        for (Transaction transaction: client.getTransactionHistory()) {
            System.out.println("Name: " + client.getFirstName() + " " + client.getLastName());
            System.out.println("Transaction " + transaction.getTransactionId() + ": ");
            System.out.println("Transaction type:" + transaction.getTransactionType().name());

            //if (transaction.getTransactionType().equals())
        }
    }
}
