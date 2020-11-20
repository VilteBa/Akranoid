import java.awt.*;

public class Paddle extends Shape{

    private static Paddle paddle = new Paddle(100, 570, 150, 15, Color.GREEN);

    private Paddle(int x, int y, int width, int height, Color color){
        super(x, y, width, height, color);
    }

    public static Paddle getInstance(){
        return paddle;
    }
    public void moveRight() {
        x= x >= 540 ? 500 : x + 20;
    }

    public void moveLeft() {
        x= x <= 20 ? 0 : x - 20;
    }
}