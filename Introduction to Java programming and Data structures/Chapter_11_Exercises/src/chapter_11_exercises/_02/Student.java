/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package chapter_11_exercises._02;

/**
 *
 * @author Samuel Bangslund
 */
public class Student extends Person {
    private final String CLASS_STATUS;
    
    public Student(String status) {
        this.CLASS_STATUS = status;
    }

    @Override
    public String toString() {
        return "Person.Student: CLASS_STATUS = " + this.CLASS_STATUS;
    }
    
    public String getStatus() {
        return CLASS_STATUS;
    }
}
