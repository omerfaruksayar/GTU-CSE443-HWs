import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Blackhole extends Elements{

    /**
     * Constructor for the blackhole images
     * @param x is the coordinate of the blackhole image in the x axis.
     * @param y is the coordinate of the blackhole image in the y axis.
     * @param speed is the move speed of the blackholes.
     */
    public Blackhole(int x, int y, int speed) {
        super(x, y, speed);
        image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Assets/blackhole.png"))).getImage();
    }

    /**
     * It moves blackholes.
     */
    public void move(){
        setX(getX()-10);
    }

    /**
     * Creates rectangle bound to the blackholes to detect if there is any collision with the rover.
     * @return Rectangle object
     */
    public Rectangle getBounds(){
        return new Rectangle(getX(),getY(),this.image.getWidth(null), this.image.getHeight(null));
    }
}
