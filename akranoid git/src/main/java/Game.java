import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel implements KeyListener, ActionListener {

    private boolean gameStarted;
    Ball ball;
    Paddle paddle;
    Block[][] blocks;
    private int countBlocks;
    private Timer timer = new Timer(4, this);

    public Game(){
        paddle = Paddle.getInstance();
        ball = new Ball(150, 350, 1, 1, 20, 20, Color.BLUE);
        blocks = BlocksGenerator.generate();
        countBlocks = 12;
        addKeyListener(this);
        setFocusable(true);
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(1,1,700, 600);
        paddle.draw(g);
        ball.draw(g);

        for (Block[] blockRow : blocks) {
            for (Block block : blockRow) {
                if (!block.getCrashed())
                    block.draw((Graphics2D) g);
            }
        }
        if(!gameStarted) {
            g.setColor(Color.ORANGE);
            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press Enter to Restart", 240, 350);
        }
        g.dispose();
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                paddle.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                paddle.moveRight();
                break;
            case KeyEvent.VK_ENTER:
                if (!gameStarted) {
                    startGame();
                }
                break;
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }

    public void actionPerformed(ActionEvent e) {
        if(gameStarted){

            A: for (int i = 0; i< blocks.length; i++){
                for (int j = 0; j<blocks[i].length; j++){
                    if(!blocks[i][j].getCrashed()){
                        if (checkBlockIntersection(i, j)) break A;
                    }
                }
            }

            checkPaddleIntersection();
            checkWallIntersection();
            ball.move();
            if ( isGameOver() || isGameWon()) endGame();
            repaint();
        }
    }

    private void checkWallIntersection() {
        if(ball.getX()<0 || ball.getX()>670){
            ball.changeDirectionX();
        }
        if(getY()<0){
            ball.changeDirectionY();
        }
    }

    private void startGame() {
        timer.start();
        paddle = Paddle.getInstance();
        gameStarted = true;
        ball = new Ball(150, 350, -1, -2, 20, 20, Color.BLUE);
        blocks = BlocksGenerator.generate();
        countBlocks = 12;
        repaint();
    }

    private boolean checkBlockIntersection(int i, int j) {
        if(ball.getArea().intersects(blocks[i][j].getArea())){
            blocks[i][j].setCrashed();
            countBlocks--;

            if(ball.getX() + ball.getHeight() < blocks[i][j].getX() || ball.getX() + 1 >= blocks[i][j].getX() + blocks[i][j].getWidth()){
                ball.changeDirectionX();
            }
            else {
                ball.changeDirectionY();
            }
            return true;
        }
        return false;
    }

    private void checkPaddleIntersection() {
        if(ball.getArea().intersects(paddle.getArea())){
            ball.changeDirectionY();
        }
    }

    private boolean isGameWon(){
        return countBlocks <= 0;
    }

    private boolean isGameOver(){
        return ball.getY() > 580;
    }

    private void endGame() {
        gameStarted = false;
    }

}
