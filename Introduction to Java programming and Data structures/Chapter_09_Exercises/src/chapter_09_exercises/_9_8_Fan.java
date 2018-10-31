package chapter_09_exercises;

/**
 * @author Samuel Bangslund
 */
public class _9_8_Fan {
    private final int SLOW      = 1;
    private final int MEDIUM    = 2;
    private final int HIGH      = 3;
    
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "Blue";
    
    public _9_8_Fan() {
        this(1, 5, "Blue");
    }
    
    public _9_8_Fan(int speed, double radius, String color) {
        this.setSpeed(speed);
        this.radius = radius;
        this.color = color;
    }
    
    public void incrementSpeed() {
        speed += speed < HIGH ? 1 : 0;
    }
    
    public void decreaseSpeed() {
        speed -= speed > SLOW ? 1 : 0;
    }
    
    @Override
    public String toString() {
        if(on) {
            return String.format("Speed:[%s]  Color:[%s]  Radius:[%s]", speed, color, radius);
        } else {
            return String.format("Color:[%s]  Radius:[%s]  The fan is not on.", color, radius);
        }
    }
    
    public void setSpeed(int speed) {
        this.speed = speed <= HIGH && speed >= SLOW ? speed : SLOW;
    }
    
    public void isOn(boolean on) {
        this.on = on;
    }
    
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public int getSpeed() {
        return this.speed;
    }
    
    public int getHigh() {
        return this.HIGH;
    }
    
    public int getMedium() {
        return this.MEDIUM;
    }
    
    public int getSlow() {
        return this.SLOW;
    }
    
    public boolean getOn() {
        return this.on;
    }
    
    public double getRadius() {
        return this.radius;
    }
    
    public String getColor() {
        return this.color;
    }
}
