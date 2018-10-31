/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package chapter_11_exercises._02;

/**
 *
 * @author Samuel Bangslund
 */
public class Faculty extends Employee {
    private String officeHours;
    private String rank;
    
    public Faculty(int office, double salary, String officeHours, String rank) {
        super(office, salary);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Person.Employee.Faculty: officeHours = " + this.officeHours + 
                ", rank = " + this.rank;
    }
    
    public String getOfficeHours() {
        return officeHours;
    }

    public String getRank() {
        return rank;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
    
    
}
