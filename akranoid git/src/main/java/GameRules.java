import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameRules extends JPanel implements KeyListener, ActionListener {

    private boolean gameStarted = false;
    private int countBlocks = 9;
    private Timer timer = new Timer(4, this);
    Ball ball = new Ball(150, 350, 1, 1, 20, 20, Color.BLUE);
    Paddle paddle = new Paddle(100, 570, 150, 15, Color.GREEN);
    Block[][] blocks = Generator.generateBlocks(3,3);

    public GameRules(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer.start();
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(1,1,700, 600);

        paddle.draw(g);
        ball.draw(g);

        for (int i = 0; i< blocks.length; i++){
            for (int j = 0; j<blocks[i].length; j++){
                if(!blocks[i][j].isCrashed())
                blocks[i][j].draw((Graphics2D)g);
            }
        }

        if(countBlocks <= 0){
            gameEnd(g, "YOU WON!");
        }

        if (ball.getY() > 580) {
            gameEnd(g, "GAME OVER!");
        }
        g.dispose();
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(paddle.getX() <= 0){
                paddle.setX(0);
            }
            else{
                gameStarted = true;
                paddle.moveLeft();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(paddle.getX() >= 540){
                paddle.setX(550);
            }
            else{
                gameStarted = true;
                paddle.moveRight();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            if(!gameStarted){
                gameStarted = true;
                ball = new Ball(150, 350, -1, -2, 20, 20, Color.BLUE);
                countBlocks = 9;
                blocks = Generator.generateBlocks(3,3);
                repaint();
            }
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void actionPerformed(ActionEvent e) {
        if(gameStarted){

            if(ball.getArea().intersects(paddle.getArea())){
                ball.changeDirectionY();
            }

            A: for (int i = 0; i< blocks.length; i++){
                for (int j = 0; j<blocks[i].length; j++){
                    if(!blocks[i][j].isCrashed()){

                        if(ball.getArea().intersects(blocks[i][j].getArea())){
                            blocks[i][j].setCrashed();
                            countBlocks--;

                            if(ball.getX() + ball.getHeight() < blocks[i][j].getX() || ball.getX() + 1 >= blocks[i][j].getX() + blocks[i][j].getWidth()){
                                ball.changeDirectionX();
                            }
                            else {
                                ball.changeDirectionY();
                            }
                            break A;
                        }
                    }
                }
            }
            ball.move();
            checkWall();
            repaint();
        }
    }

    private void gameEnd(Graphics g, String s) {
        gameStarted = false;
        ball.setDirectionX(0);
        ball.setDirectionY(0);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("serif", Font.BOLD, 30));
        g.drawString(s, 240, 300);
        g.setFont(new Font("serif", Font.BOLD, 20));
        g.drawString("Press Enter to Restart", 240, 350);
    }

    private void checkWall() {
        if(ball.getX()<0){
            ball.changeDirectionX();
        }

        if(ball.getY()<0){
            ball.changeDirectionY();
        }

        if(ball.getX()>670){
            ball.changeDirectionX();
        }
    }
}
