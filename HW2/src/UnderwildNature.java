import javax.swing.*;
import java.util.Objects;

public class UnderwildNature extends JButton implements Nature{
    final double strength = 60;
    final double agility = 160;
    double health = 100;

    public UnderwildNature() {
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
        health = 100;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("UnderwildNature " + "health=%.2f",health ) ;
    }
}
