public interface Fire {
    /**
     * Getter for strength of fire char/enemy.
     * @return double strength
     */
    double getStrength();

    /**
     * Getter for agility of fire char/enemy.
     * @return double agility
     */
    double getAgility();
    /**
     * Getter for health of fire char/enemy.
     * @return double health
     */
    double getHealth();

    /**
     * Setter for health of fire char/enemy
     * @param health new health of fire char/enemy
     */
    void setHealth(double health);

    /**
     * Remove Char/enemy icon
     */
    void removeBg();

    /**
     * Replenishes char/enemy health
     */
    void updateHealth();
}
