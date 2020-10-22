import javax.swing.*;
import java.awt.*;

public class WindowMain extends JFrame{

    public WindowMain()  {
        GameRules gameRules = new GameRules();

        super.setPreferredSize(new Dimension(850, 700));
        super.pack();
        super.setVisible(true);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.add(gameRules);
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                try {
                    new WindowMain();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static final long serialVersionUID = 1L;
}