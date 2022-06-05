import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Random;

public class PowerUp extends Elements implements Runnable{

    /**
     * Constructor for the PowerUp class
     * @param x is the coordinate of the powerUp in the x axis.
     * @param y is the coordinate of the powerUp in the y axis.
     * @param speed is the move speed of the powerUp.
     */
    public PowerUp(int x, int y, int speed) {
        super(x, y, speed);
        image =  new ImageIcon(Objects.requireNonNull(getClass().getResource("/Assets/pUp.png"))).getImage();
    }

    /**
     * Moves the power ups.
     */
    public void move(){
        new Thread(PowerUp.this).start();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        setX(getX()-getSpeed());
    }

    /**
     * This method is used to generate random integer to determine which powerUp will be selected.
     * @return random integer up to 4.
     */
    public int power(){
        return new Random().nextInt(4);
    }

    /**
     * Creates rectangle bound to the powerUp to detect if there is any collision with the rover.
     * @return Rectangle object
     */
    public Rectangle getBounds(){
        return new Rectangle(getX(),getY(),this.image.getWidth(null), this.image.getHeight(null));
    }

}
