import javax.swing.*;
import java.awt.*;

public class WindowMain extends JFrame{

    public WindowMain()  {
        Game game = new Game();

        super.setPreferredSize(new Dimension(720, 650));
        super.pack();
        super.setVisible(true);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.add(game);
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {

            public void run() {
                try {
                    new WindowMain();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}