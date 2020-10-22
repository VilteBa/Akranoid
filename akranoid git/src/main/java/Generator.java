import java.awt.*;

public class Generator {

    public static Block[][] generateBlocks(int row, int col){
        Block[][] blocks = new Block[row][col];
        for (int i = 0; i < blocks.length; i++){
            for (int j = 0; j < blocks[i].length ;j++){
                int width = 520/col;
                int height = 150/row;
                int x = width*j+90;
                int y = height*i+50;
                blocks[i][j] = new Block(x, y, Color.ORANGE, width, height);
            }
        }
        return blocks;
    }
}
