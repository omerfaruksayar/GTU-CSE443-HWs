public interface Nature {
    /**
     * Getter for strength of nature char/enemy.
     * @return double strength
     */
    double getStrength();
    /**
     * Getter for agility of nature char/enemy.
     * @return double agility
     */
    double getAgility();
    /**
     * Getter for health of nature char/enemy.
     * @return double health
     */
    double getHealth();
    /**
     * Setter for health of nature char/enemy
     * @param health new health of nature char/enemy
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
