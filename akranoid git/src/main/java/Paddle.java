import lombok.Data;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.util.Scanner;
import java.util.Vector;


@Data
public class Paddle {

    private int x ;
    private int y ;
    private int velocityX = 0 ;
    private int height ;
    private int width ;
    private Color color;

    public Paddle(int x, int y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public Rectangle getArea(){
        return new Rectangle(x, y, width, height);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public void moveRight() {
        x = x + 20;
    }

    public void moveLeft() {
        x = x - 20;
    }
}