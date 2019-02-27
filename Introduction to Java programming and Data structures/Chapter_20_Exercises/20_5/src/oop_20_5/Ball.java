package oop_20_5;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball implements Comparable<Ball> {

    private static int counter;
    private int id;
    private double radius;
    private Color color;

    private double xPos, yPos, xDir, yDir;

    private final Set<Ball> collidingBalls = new TreeSet<>();

    public Ball(double xPos, double yPos, double xDir, double yDir, double diameter, Color color) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.xDir = xDir;
        this.yDir = yDir;
        this.radius = diameter / 2;
        this.color = color;

        this.id = counter;
        counter++;
    }

    public void calcBorderCollision(Canvas canvas) {
        xDir = xPos + radius / 2 > canvas.getWidth() ? -xDir : xDir;
        xDir = xPos - radius / 2 < 0 ? Math.abs(xDir) : xDir;

        yDir = yPos + radius / 2 > canvas.getHeight() ? -yDir : yDir;
        yDir = yPos - radius / 2 < 0 ? Math.abs(yDir) : yDir;

        xPos += xDir;
        yPos += yDir;
    }

    public double calcDistance(Ball other) {
        return Math.sqrt(Math.pow(xPos - other.getxPos(), 2) + Math.pow(yPos - other.getyPos(), 2));
    }
    
    public double calcDistance(double x, double y) {
        return Math.sqrt(Math.pow(xPos - x, 2) + Math.pow(yPos - y, 2));
    }

    public void calcCollidingBalls(List<Ball> balls) {
        collidingBalls.clear();
        balls.forEach(ball -> {
            double distance = calcDistance(ball);
            if (distance <= (radius + ball.getRadius()) / 2 && distance != 0) {
                collidingBalls.add(ball);
            }
        });
    }

    public void drawBall(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(xPos - radius / 2, yPos - radius / 2, radius, radius);
    }

    @Override
    public int compareTo(Ball o) {
        return Double.valueOf(o.calcDistance(this)).compareTo(this.calcDistance(o));
    }

    @Override
    public String toString() {
        return String.format("[Ball(%s)]:%s:%s:%s:%s:%s", id, xPos, yPos, xDir, yDir, radius);
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }

    public double getxPos() {
        return xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public double getxDir() {
        return xDir;
    }

    public double getyDir() {
        return yDir;
    }

    public double getRadius() {
        return radius;
    }

    public Color getColor() {
        return color;
    }

    public int getID() {
        return id;
    }

    public Set<Ball> getCollidingBalls() {
        return this.collidingBalls;
    }
}
