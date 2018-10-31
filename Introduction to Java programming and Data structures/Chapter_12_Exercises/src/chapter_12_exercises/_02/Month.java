/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package chapter_12_exercises._02;

/**
 *
 * @author Samuel Bangslund
 */
public class Month {
    private static final String[] MONTHS = {"January", "Febuary", "March", "April", "May", "June", 
        "July", "August", "September", "October", "November", "December" };
    
    private static final int[] DOM = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public static int getDaysInMonth(int i) {
        try {
            int daysInMonth = DOM[i - 1];
            return daysInMonth;
        } catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println("Wrong number. [Returned 0]");
            return 0;
        }
    }
    
    public static String getMonth(int number) {
        return MONTHS[number];
    }
    
    public static String[] getMonths() {
        return Month.MONTHS;
    }
    
    public int[] getDom() {
        return Month.DOM;
    }
}
