/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package chapter_11_exercises._03;

import java.util.Date;

/**
 *
 * @author Samuel Bangslund
 */
public class Account {
    private long accountNumber;
    
    private double balance;
    private double annualInterestRate;
    
    private final Date DATE_CREATED;

    public Account() {
        this.DATE_CREATED = new Date();
    }
    
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.DATE_CREATED = new Date();
    }
    
    public void deposit(double amount) {
        this.balance += amount >= 0 ? amount : 0;
    }
    
    public void withdraw(double amount) {
        this.balance -= amount >= 0 ? amount : 0;
    }
    
    @Override
    public String toString() {
        return String.format("Account [Balance: $%,.2f]", this.getBalance());
    }
    
    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }
    
    public double getMontlyInterest() {
        return getMonthlyInterestRate() * balance / 100;
    }
    
    public long getAccountNumber() {
        return this.accountNumber;
    }
    
    public double getBalance() {
        return this.balance;
    }
    
    public double getAnnualInterestRate() {
        return this.annualInterestRate;
    }
    
    public String getDateCreated() {
        return this.DATE_CREATED.toString();
    }
    
    public void setAccountNumber(long id) {
        this.accountNumber = (id >= 0) ? id : 0;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
}
