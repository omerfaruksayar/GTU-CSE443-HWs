import javax.swing.*;
import java.util.Objects;

public class ValhallaFire extends JButton implements Fire{
    final double strength = 130;
    final double agility = 50;
    double health = 97.5;

    public ValhallaFire() {
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
        health = 97.5;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("ValhallaFire " + "health=%.2f",health ) ;
    }
}
