/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package chapter_11_exercises._03;

/**
 *
 * @author Samuel Bangslund
 */
public class CheckingsAccount extends Account {
    
    private double overdraftLimit;
    
    public CheckingsAccount(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
    
    public CheckingsAccount(long accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }
    
    @Override
    public void withdraw(double amount) {
        double newBalance = this.getBalance() - amount;
        if(newBalance >= this.overdraftLimit) {
            setBalance(newBalance);
        }
    }
    
    @Override
    public String toString() {
        return String.format("Account.CheckingAccount [Balance: $%,.2f]", this.getBalance());
    }
    
    public void setOverdraftLimit(double limit) {
        this.overdraftLimit = limit;
    }
    
    public double getOverdraftLimit() {
        return this.overdraftLimit;
    }
}
