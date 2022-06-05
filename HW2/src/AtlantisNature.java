import javax.swing.*;
import java.util.Objects;

public class AtlantisNature extends JButton implements Nature{
    final double strength = 60;
    final double agility = 120;
    double health = 150;

    public AtlantisNature() {
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
        health = 150;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("AtlantisNature " + "health=%.2f",health ) ;
    }
}
