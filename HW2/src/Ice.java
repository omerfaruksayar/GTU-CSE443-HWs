public interface Ice {
    /**
     * Getter for strength of ice char/enemy.
     * @return double strength
     */
    double getStrength();
    /**
     * Getter for agility of ice char/enemy.
     * @return double agility
     */
    double getAgility();
    /**
     * Getter for health of ice char/enemy.
     * @return double health
     */
    double getHealth();
    /**
     * Setter for health of ice char/enemy
     * @param health new health of ice char/enemy
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
