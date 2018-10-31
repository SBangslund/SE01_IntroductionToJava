/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter_11_exercises._08;

import java.util.Date;

/**
 *
 * @author sbang
 */
public class Transaction {
    private Date dateCreated;
    private char type;
    private double amount;
    private double balance;
    private String description;
    
    public Transaction(char type, double amount, double balance, String description) {
        this.dateCreated = new Date();
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Transaction[date:%s, type:%s, amount:%,.2f$, balance:%,.2f$, description:%s", 
                this.dateCreated, this.type, this.amount, this.balance, this.description);
    }
    
    public Date getDateCreated() {
        return dateCreated;
    }

    public char getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setType(char type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
