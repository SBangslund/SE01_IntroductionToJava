/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package chapter_11_exercises._08;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Samuel Bangslund
 */
public class Account {
    private long accountNumber;
    private String name;
    private double balance;
    private double annualInterestRate;
    
    private final Date DATE_CREATED;

    private ArrayList<Transaction> transactions = new ArrayList<>();
    
    public Account() {
        this.DATE_CREATED = new Date();
    }
    
    public Account(String name, long accountNumber, double balance, double annualInterestRate) {
        this(accountNumber, balance, annualInterestRate);
        this.name = name;
    }
    
    public Account(long accountNumber, double balance, double annualInterestRate) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.DATE_CREATED = new Date();
    }
    
    public void deposit(double amount) {
        this.balance += amount >= 0 ? amount : 0;
        if(amount >= 0) {
            this.balance += amount;
            Transaction transaction = new Transaction('d', amount, balance, String.format("Deposited %,.2f$", amount));
            transactions.add(transaction);
        }
        
    }
    
    public void withdraw(double amount) {
        if(amount >= 0) {
            this.balance -= amount;
            Transaction transaction = new Transaction('w', amount, balance, String.format("Withdrew %,.2f$", amount));
            transactions.add(transaction);
        }
    }
    
    public void printAccountSummary() {
        System.out.println("The account summary for: " + name);
        System.out.println("Annual interest rate: " + this.annualInterestRate);
        System.out.println("Balance: " + this.balance);
        System.out.println("Transactions: ");
        for(Transaction transaction : transactions) {
            System.out.println(transaction);
        }
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
    
    public String getName() {
        return this.name;
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
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
}
