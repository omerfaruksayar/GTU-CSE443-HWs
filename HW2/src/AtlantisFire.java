import javax.swing.*;
import java.util.Objects;

public class AtlantisFire extends JButton implements Fire {
    final double strength = 80;
    final double agility = 150;
    double health = 90;

    public AtlantisFire() {
        setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Assets/Fire.png"))));
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
        health = 90;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("AtlantisFire " + "health=%.2f",health ) ;
    }
}
