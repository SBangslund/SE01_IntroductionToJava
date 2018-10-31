package chapter_11_exercises._01;

/**
 * @author Samuel Bangslund
 */
public class GeometricObject {
    private String color;
    private boolean isFilled;
    
    public GeometricObject() {
        this("RED", false);
    }
    
    public GeometricObject(String color, boolean isFilled) {
        this.color = color;
        this.isFilled = isFilled;
    }

    public String getColor() {
        return color;
    }

    public boolean isFilled() {
        return this.isFilled;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public void setIsFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }
}
