import javax.swing.*;
import java.util.Objects;

public class UnderwildFire extends JButton implements Fire{
    final double strength = 80;
    final double agility = 200;
    double health = 60;

    public UnderwildFire() {
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
        health = 60;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("UnderwildFire " + "health=%.2f",health ) ;
    }
}
