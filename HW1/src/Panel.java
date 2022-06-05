import javax.swing.*;
import java.awt.*;

public abstract class Panel extends JPanel {

    private final int height;
    private final int width;

    /**
     * Constructor for the abstract panel.
     * @param height is the height of the panel in integer
     * @param width is the height of the panel in integer
     */
    public Panel(int height, int width) {
        this.height = height;
        this.width = width;
        setPreferredSize(new Dimension(width,height));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        printToScreen(g2D);
    }

    /**
     * Getter for the panel height.
     * @return integer height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Getter for the panel width
     * @return integer width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Abstract method for the panels, it prints other objects in the panel to the screen
     * @param g is the 2D graphic which is needed to render 2D objects.
     */
    protected abstract void printToScreen(Graphics2D g);
}
