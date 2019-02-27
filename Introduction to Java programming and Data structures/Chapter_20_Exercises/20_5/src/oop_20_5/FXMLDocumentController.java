package oop_20_5;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Canvas canvas;
    
    List<Ball> balls = new ArrayList<>();
    private final int numberOfBalls = 2000;
    private final int maxRadius = 5;
    
    private boolean runningAnimation = true;
    private GraphicsContext gc;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = canvas.getGraphicsContext2D();
        initializeBalls(numberOfBalls, maxRadius);
        drawBalls();
        startAnimation();
    }

    private void startAnimation() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (runningAnimation) {
                    clearCanvas();
                    calcBalls();
                    drawBalls();
                    calcCollisions();
                }
            }
        }.start();
    }

    private void supendAnimation() {
        this.runningAnimation = false;
    }

    private void resumeAnimation() {
        this.runningAnimation = true;
    }

    private void initializeBalls(int numberOfBalls, double maxRadius) {
        for (int i = 1; i <= numberOfBalls; i++) {
            double radius = Math.random() * maxRadius;
            double x = Math.random() * (canvas.getWidth() - radius);
            double y = Math.random() * (canvas.getHeight() - radius);
            double xDir = Math.random();
            double yDir = Math.random();

            balls.add(new Ball(x, y, xDir, yDir, radius, Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255))));
        }
    }

    private void addBall() {
        double radius = Math.random() * maxRadius;
        double x = Math.random() * (canvas.getWidth() - radius);
        double y = Math.random() * (canvas.getHeight() - radius);
        double xDir = Math.random();
        double yDir = Math.random();

        balls.add(new Ball(x, y, xDir, yDir, radius, Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255))));
    }

    private void removeBall() {
        if (balls.size() > 0) {
            balls.remove(balls.get((int) (Math.random() * balls.size())));
        }
    }

    private void drawBalls() {
        balls.forEach(e -> e.drawBall(gc));
    }

    private void calcBalls() {
        balls.forEach(e -> e.calcBorderCollision(canvas));
    }

    private void calcCollisions() {
        List<Ball> markedForRemove = new ArrayList<>();
        balls.forEach(e -> {
            e.calcCollidingBalls(balls);
            e.getCollidingBalls().forEach(u -> {
                if (e.getRadius() > u.getRadius()) {
                    e.setRadius(e.getRadius() + u.getRadius() / 4);
                    markedForRemove.add(u);
                } else {
                    u.setRadius(u.getRadius() + e.getRadius() / 4);
                    markedForRemove.add(e);
                }
            });
        });
        balls.removeAll(markedForRemove);
    }

    private void drawGizmos() {
        balls.forEach(e -> {
            e.calcCollidingBalls(balls);
            e.getCollidingBalls().forEach(u -> {
                gc.strokeLine(e.getxPos(), e.getyPos(), u.getxPos(), u.getyPos());
            });
        });
    }

    private void clearCanvas() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    @FXML
    private void OnMouseClicked(MouseEvent event) {
        List<Ball> markedForRemove = new ArrayList<>();
        balls.forEach(e -> {
            if (e.calcDistance(event.getSceneX(), event.getSceneY()) < e.getRadius()) {
                markedForRemove.add(e);
            }
        });
        balls.removeAll(markedForRemove);
    }

    @FXML
    private void OnSuspendAction(ActionEvent event) {
        supendAnimation();
    }

    @FXML
    private void OnResumeAction(ActionEvent event) {
        resumeAnimation();
    }

    @FXML
    private void OnPlusAction(ActionEvent event) {
        addBall();
    }

    @FXML
    private void OnMinusAction(ActionEvent event) {
        removeBall();
    }
}
