import java.awt.*;

public class Shape {

    protected int x ;
    protected int y ;
    protected int height ;
    protected int width ;
    protected Color color;

    public Shape(){}

    public Shape(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.color = color;
    }

    //abstrakcija
    public Rectangle getArea(){
        return new Rectangle(x, y, width, height);
    }

    //abstrakcija
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setStroke(new BasicStroke(3));
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
