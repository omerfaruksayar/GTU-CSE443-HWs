import javax.swing.*;
import java.util.Objects;

public class UnderwildIce extends JButton implements Ice{
    final double strength = 100;
    final double agility = 120;
    double health = 80;

    public UnderwildIce() {
        setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Assets/Ice.png"))));
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
        health = 80;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("UnderwildIce " + "health=%.2f",health ) ;
    }
}
