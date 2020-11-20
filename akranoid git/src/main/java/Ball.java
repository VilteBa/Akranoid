import java.awt.*;

public class Ball extends Shape {

    private int directionX;
    private int directionY;

    public Ball(int x, int y, int directionX, int directionY, int height, int width, Color color) {
        super(x, y, width, height, color);
        this.directionX = directionX;
        this.directionY = directionY;
    }

    public void changeDirectionX() {
        directionX *= -1;
    }

    public void changeDirectionY() {
        directionY *= -1;
    }

    public void move() {
        x += directionX;
        y += directionY;
    }

    public int getDirectionX() {
        return directionX;
    }

    public void setDirectionX(int directionX) {
        this.directionX = directionX;
    }

    public int getDirectionY() {
        return directionY;
    }

    public void setDirectionY(int directionY) {
        this.directionY = directionY;
    }
}
