/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package chapter_11_exercises._03;

/**
 *
 * @author Samuel Bangslund
 */
public class SavingsAccount extends Account {
    public SavingsAccount() {
        
    }
    
    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }
    
    @Override
    public void withdraw(double amount) {
        double newBalance = this.getBalance() - amount;
        if(newBalance >= 0) {
            this.setBalance(newBalance);
        }
    }
    
    @Override
    public String toString() {
        return String.format("Account.SavingsAccount [Balance: $%,.2f]", this.getBalance());
    }
}
