package chapter_09_exercises;

/**
 * @author Samuel Bangslund
 */
public class _9_7_Account {

    private int id;

    private double balance;
    private double annualInterestRate;

    private _9_3_Date dateCreated;

    public _9_7_Account() {
        
    }
    
    public _9_7_Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new _9_3_Date(System.currentTimeMillis());
    }
    
    public void deposit(double amount) {
        this.balance += amount >= 0 ? amount : 0;
    }
    
    public void withdraw(double amount) {
        this.balance -= amount >= 0 ? amount : 0;
    }
    
    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }
    
    public double getMontlyInterest() {
        return getMonthlyInterestRate() * balance / 100;
    }
    
    public int getID() {
        return this.id;
    }
    
    public double getBalance() {
        return this.balance;
    }
    
    public double getAnnualInterestRate() {
        return this.annualInterestRate;
    }
    
    public String getDateCreated() {
        return this.dateCreated.getDate();
    }
    
    public void setID(int id) {
        this.id = (id >= 0) ? id : 0;
    }
    
    public void setBalance(double balance) {
        this.balance = (balance >= 0) ? balance : 0;
    }
    
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
}
