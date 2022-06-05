import javax.swing.*;
import java.util.Objects;

public class ValhallaNature extends JButton implements Nature{
    final double strength = 97.5;
    final double agility = 40;
    double health = 162.5;

    public ValhallaNature() {
        setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Assets/Nature.png"))));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getStrength() {
        return strength;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getAgility() {
        return agility;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getHealth() {
        return health;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHealth(double health) {
        this.health = health;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeBg() {
        setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Assets/Cross.jpg"))));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateHealth() {
        health = 162.5;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("ValhallaNature " + "health=%.2f",health ) ;
    }
}
