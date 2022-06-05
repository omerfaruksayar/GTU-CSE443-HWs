import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel {

    private String message;

    /**
     * Constructor for the bottom panel.
     * @param height is the height of the panel.
     * @param width is the width of the panel.
     * @param message is the message that will be printed on the panel.
     */
    public StatusPanel(int width, int height, String message) {
        setPreferredSize(new Dimension(width,height));
        this.message = message;
    }

    /**
     * Setter for the message that will be printed to the screen
     * @param message is the String message.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(message,10,30);
    }
}
