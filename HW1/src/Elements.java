import java.awt.*;

public abstract class Elements {

    private int x;
    private int y;
    private final int speed;
    protected Image image;

    /**
     * Constructor of the Elements abstract class.
     * @param x x is the coordinate of the element in vertical direction.
     * @param y y is the coordinate of the element in horizontal direction.
     * @param speed speed is the move speed of the element.
     */
    public Elements(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    /**
     * getter for the x coordinate of the element
     * @return integer x
     */
    public int getX() {
        return x;
    }

    /**
     * Setter for the x coordinate of the element.
     * @param x is the new x coordinate.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Getter for the y coordinate of the element
     * @return integer x
     */
    public int getY() {
        return y;
    }

    /**
     * Setter for the y coordinate of the element.
     * @param y is the new y coordinate.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Getter for the speed of the element.
     * @return integer speed.
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Draws element to the panel.
     * @param g is the 2D graphic which is needed to render 2D objects.
     */
    public void draw(Graphics2D g){
        g.drawImage(this.image,getX(),getY(),null);
    }
}
