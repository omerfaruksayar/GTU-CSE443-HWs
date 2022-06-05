import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Rover extends Elements {

    private Jumping jumping;

    /**
     * Constructor for the Rover class
     * @param x is the coordinate of the rover in the x axis.
     * @param y is the coordinate of the rover in the y axis.
     */
    public Rover(int x, int y, int speed) {
        super(x, y, speed);
        this.image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Assets/rover.png"))).getImage();
        jumping = new LowJump(this);
    }

    /**
     * Getter for jumping behaviour
     * @return Jumping object
     */
    public Jumping getJumping() {
        return jumping;
    }

    /**
     * Setter for jumping behaviour
     * @param jumping is the new Jumping behaviour.
     */
    public void setJumping(Jumping jumping) {
        this.jumping = jumping;
    }

    /**
     * It makes the rover jump.
     */
    public void jump(){
        jumping.jump();
    }

    /**
     * Creates rectangle bound to the rover to detect if there is any collision with other elements.
     * @return Rectangle object
     */
    public Rectangle getBounds(){
        return new Rectangle(getX(),getY(),this.image.getWidth(null)-40, this.image.getHeight(null));
    }
}
