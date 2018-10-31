/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */
package chapter_12_exercises._05;

/**
 *
 * @author Samuel Bangslund
 */
public class IllegalTriangleException extends Exception {

    public IllegalTriangleException() {
        super("This is not a valid triangle.");
    }
}
