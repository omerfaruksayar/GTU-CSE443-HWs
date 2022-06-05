import javax.swing.*;
import java.util.Objects;

public class Background extends Elements {

    /**
     * Constructor for the Background
     * @param x is the coordinate of the background image in the x axis.
     * @param y is the coordinate of the background image in the y axis.
     * @param speed is the move speed of the background
     */
    public Background(int x, int y, int speed) {
        super(x, y, speed);
        this.image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Assets/bg.png"))).getImage();
    }

    /**
     * Moves background image to the left.
     */
    public void moveLeft(){
        setX(getX()-getSpeed());
    }
}
