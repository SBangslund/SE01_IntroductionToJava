package chapter_09_exercises;

/**
 * @author Samuel Bangslund
 */
public class _9_3_Date {

    private final java.util.Date date;

    public _9_3_Date(long elapsedTime) {
        this.date = new java.util.Date(elapsedTime);
    }
    
    public String getDate() {
        return date.toString();
    }
}
