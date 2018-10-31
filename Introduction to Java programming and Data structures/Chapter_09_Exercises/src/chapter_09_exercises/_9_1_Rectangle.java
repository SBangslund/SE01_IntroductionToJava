package chapter_09_exercises;

/**
 * @author Samuel Bangslund
 */
public class _9_1_Rectangle {
    private double width = 1;
    private double height = 1;
    
    public _9_1_Rectangle() {
        
    }
    
    public _9_1_Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    public double getWidth() {
        return this.width;
    }
    
    public double getHeight() {
        return this.height;
    }
    
    public double getArea() {
        return width * height;
    }
    
    public double getPerimeter() {
        return 2 * width + 2 * height;
    }
}
