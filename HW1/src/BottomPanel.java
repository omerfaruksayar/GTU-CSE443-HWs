import java.awt.*;

public class BottomPanel extends Panel{

    private String message;

    /**
     * Constructor for the bottom panel.
     * @param height is the height of the panel.
     * @param width is the width of the panel.
     * @param message is the message that will be printed on the panel.
     */
    public BottomPanel(int height, int width, String message) {
        super(height, width);
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
    protected void printToScreen(Graphics2D g) {
        setBackground(Color.WHITE);
        g.drawString(message,20,40);
    }
}
