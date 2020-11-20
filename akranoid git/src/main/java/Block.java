import java.awt.*;

public class Block extends Shape{

    private boolean crashed;

    public Block(int x, int y, Color color, int width, int height){
        super(x, y, width, height, color);
        this.crashed = false;
    }

    public void setCrashed(){
        this.crashed =  true;
    }

    public boolean getCrashed(){
        return crashed;
    }
}