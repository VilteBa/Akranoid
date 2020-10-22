import lombok.Data;

import java.awt.*;


@Data
public class Ball {

    private int x ;
    private int y ;
    private int directionX;
    private int directionY;
    private int height ;
    private int width ;
    private Color color;


    public Ball(int x, int y, int directionX, int directionY, int height, int width, Color color)  {
        this.x = x;
        this.y = y;
        this.directionX = directionX;
        this.directionY = directionY;
        this.width = width;
        this.height = height;
        this.color = color;

    }

    public Rectangle getArea(){
        return new Rectangle(x, y, width, height);
    }

    public void changeDirectionX() {
        directionX *= -1;
    }

    public void changeDirectionY() {
        directionY *= -1;
    }

    public void move(){
        x += directionX;
        y += directionY;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }

}
