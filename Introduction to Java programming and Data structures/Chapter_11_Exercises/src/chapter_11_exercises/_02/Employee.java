/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package chapter_11_exercises._02;

import java.util.Date;

/**
 *
 * @author Samuel Bangslund
 */
public class Employee extends Person {
    private int office;
    private double salary;
    private Date dateHired;
    
    public Employee(int office, double salary) {
        this.office = office;
        this.salary = salary;
        this.dateHired = new Date();
    }

    @Override
    public String toString() {
        return "Person.Employee: office = " + this.office + 
                ", salary = " + this.salary + 
                ", dateHied = " + this.dateHired;
    }
    
    public int getOffice() {
        return office;
    }

    public double getSalary() {
        return salary;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public void setOffice(int office) {
        this.office = office;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }
}
