import lombok.Data;

import java.awt.*;

@Data
public class Block {
    private int x;
    private int y;
    private final int height;
    private final int width;
    private Color color;
    private boolean crashed;

    public Block(int x, int y, Color color, int width, int height){
        this.x = x;
        this.y = y;
        this.color = color;
        this.width = width;
        this.height = height;
        this.crashed = false;

    }

    public void setCrashed(){
        this.crashed =  true;
    }

    public boolean isCrashed(){
        return crashed;
    }

    public Rectangle getArea(){
        return new Rectangle(x, y, width, height);
    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setStroke(new BasicStroke(3));
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
    }
}