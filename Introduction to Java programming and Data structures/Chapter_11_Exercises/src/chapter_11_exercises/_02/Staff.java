/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package chapter_11_exercises._02;

/**
 *
 * @author Samuel Bangslund
 */
public class Staff extends Employee {
    private String title;
    
    public Staff(int office, double salary, String title) {
        super(office, salary);
        this.title = title;
    }

    @Override
    public String toString() {
        return "Person.Employee.Staff: " + this.getName();
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
