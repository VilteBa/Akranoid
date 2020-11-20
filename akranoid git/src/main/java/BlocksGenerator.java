import java.awt.*;

public class BlocksGenerator {

    public static Block[][] generate(){

        Block[][] blocks = new Block[3][4];
        int width = 150;
        int height = 50;
        int x;
        int y;

        for (int i = 0; i < blocks.length; i++){
            for (int j = 0; j < blocks[i].length ;j++){
                x = width*j+50;
                y = height*i+50;
                blocks[i][j] = new Block(x, y, Color.ORANGE, width, height);
            }
        }
        return blocks;
    }
}
