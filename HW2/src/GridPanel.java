import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GridPanel extends JPanel implements Runnable {
    String button1, button2;
    private final JButton[] tiles = new JButton[54];
    boolean computerTurn,gameOver;
    private final CharBoard charPanel;
    private final StatusPanel sp;
    int dead = 0;

    /**
     * Constructor for the tiles panel
     * @param width is width of the panel
     * @param height is height of the panel
     */
    public GridPanel(int width, int height) {
        super(new GridLayout(6,9),true);
        this.setPreferredSize(new Dimension(width,height));
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        initBoard();
        computerTurn = false;
        gameOver = false;
        charPanel = new CharBoard(width,height-100);
        sp = new StatusPanel(width,50, "Your Turn");
    }

    /**
     * Getter for Status panel
     * @return StatusPanel
     */
    public StatusPanel getSp() {
        return sp;
    }

    /**
     * Getter for Char panel
     * @return CharBoard
     */
    public CharBoard getCharPanel() {
        return charPanel;
    }

    /**
     * Generates random tiles board
     */
    void initBoard(){
        tiles[0] = new JButton("0");
        tiles[0].addActionListener(new TileActionListener(tiles[0]));
        tiles[0].setBackground(Color.RED);
        tiles[0].setForeground(Color.RED);
        this.add(tiles[0]);
        for (int i = 1; i < 53; i++) {
            tiles[i] = new JButton(Integer.toString(i));
            tiles[i].addActionListener(new TileActionListener(tiles[i]));
            int rand = new Random().nextInt(3);
            if (rand == 0) {
                if (tiles[i-1].getBackground() != Color.RED ||(i > 8 && tiles[i-9] .getBackground() != Color.RED)){
                    tiles[i].setBackground(Color.RED);
                    tiles[i].setForeground(Color.RED);
                }
                else {
                    tiles[i].setBackground(Color.GREEN);
                    tiles[i].setForeground(Color.GREEN);
                }
            }
            else if (rand == 1) {
                if (tiles[i-1].getBackground() != Color.BLUE ||(i > 8 && tiles[i-9] .getBackground() != Color.BLUE)){
                    tiles[i].setBackground(Color.BLUE);
                    tiles[i].setForeground(Color.BLUE);
                }
                else {
                    tiles[i].setBackground(Color.RED);
                    tiles[i].setForeground(Color.RED);
                }
            }
            else {
                if (tiles[i-1].getBackground() != Color.GREEN ||(i > 8 && tiles[i-9] .getBackground() != Color.GREEN)){
                    tiles[i].setBackground(Color.GREEN);
                    tiles[i].setForeground(Color.GREEN);
                }
                else {
                    tiles[i].setBackground(Color.BLUE);
                    tiles[i].setForeground(Color.BLUE);
                }
            }
            this.add(tiles[i]);
        }
        tiles[53] = new JButton("53");
        tiles[53].addActionListener(new TileActionListener(tiles[53]));
        tiles[53].setBackground(Color.BLUE);
        tiles[53].setForeground(Color.BLUE);
        this.add(tiles[53]);
        handleMatches();
    }

    /**
     * Removes matches on starting
     */
    void handleMatches(){
        for (int i = 0; i < 52; i++) {
            if (i % 9 != 8){
                if (tiles[i].getBackground() ==tiles[i+1].getBackground() && tiles[i+1].getBackground() == tiles[i+2].getBackground()) {

                    for (int j = 0; j < 3; j++) {
                        int r = new Random().nextInt(3);
                        if (r == 0){
                            tiles[i+j].setBackground(Color.RED);
                            tiles[i+j].setForeground(Color.RED);
                        }
                        else if (r== 1){
                            tiles[i+j].setBackground(Color.BLUE);
                            tiles[i+j].setForeground(Color.BLUE);
                        }
                        else {
                            tiles[i+j].setBackground(Color.GREEN);
                            tiles[i+j].setForeground(Color.GREEN);
                        }
                    }
                    handleMatches();
                }
            }
            if (i < 36){
                if (tiles[i].getBackground() == tiles[i+9].getBackground() && tiles[i+9].getBackground() == tiles[i+18].getBackground()) {
                    for (int j = 0; j < 19; j+=9) {
                        int r = new Random().nextInt(3);
                        if (r == 0){
                            tiles[i+j].setBackground(Color.RED);
                            tiles[i+j].setForeground(Color.RED);
                        }
                        else if (r== 1){
                            tiles[i+j].setBackground(Color.BLUE);
                            tiles[i+j].setForeground(Color.BLUE);
                        }
                        else {
                            tiles[i+j].setBackground(Color.GREEN);
                            tiles[i+j].setForeground(Color.GREEN);
                        }
                    }
                    handleMatches();
                }
            }
        }
    }

    /**
     * Find for matches
     * @throws InterruptedException
     */
    void findMatch() throws InterruptedException {
        if (!gameOver) {
            for (int i = 0; i < 52; i++) {
                if (i % 9 < 7) {
                    if (tiles[i].getBackground() == tiles[i + 1].getBackground() && tiles[i + 1].getBackground() == tiles[i + 2].getBackground()) {
                        horizontalMatch(i);
                        for (int j = 0; j < 3; j++) {
                            int r = new Random().nextInt(3);
                            if (r == 0) {
                                tiles[i + j].setBackground(Color.RED);
                                tiles[i + j].setForeground(Color.RED);
                            } else if (r == 1) {
                                tiles[i + j].setBackground(Color.BLUE);
                                tiles[i + j].setForeground(Color.BLUE);
                            } else {
                                tiles[i + j].setBackground(Color.GREEN);
                                tiles[i + j].setForeground(Color.GREEN);
                            }
                        }
                        this.update(this.getGraphics());
                        Thread.sleep(1000);
                        if (!gameOver)
                            findMatch();
                    }
                }
                if (i < 36) {
                    if (tiles[i].getBackground() == tiles[i + 9].getBackground() && tiles[i + 9].getBackground() == tiles[i + 18].getBackground()) {
                        verticalMatch(i);

                        for (int j = 0; j < 19; j += 9) {
                            int r = new Random().nextInt(3);
                            if (r == 0) {
                                tiles[i + j].setBackground(Color.RED);
                                tiles[i + j].setForeground(Color.RED);
                            } else if (r == 1) {
                                tiles[i + j].setBackground(Color.BLUE);
                                tiles[i + j].setForeground(Color.BLUE);
                            } else {
                                tiles[i + j].setBackground(Color.GREEN);
                                tiles[i + j].setForeground(Color.GREEN);
                            }
                        }
                        this.update(this.getGraphics());
                        Thread.sleep(1000);
                        if (!gameOver)
                            findMatch();
                    }
                }
            }
        }
    }

    /**
     * Swaps tiles
     * @throws InterruptedException
     */
    void swap() throws InterruptedException {
        if (Math.abs((Integer.parseInt(button1)- Integer.parseInt(button2)))== 1 || Math.abs((Integer.parseInt(button1)- Integer.parseInt(button2))) == 9){
            Color tmp = tiles[Integer.parseInt(button2)].getBackground();
            tiles[Integer.parseInt(button2)].setBackground(tiles[Integer.parseInt(button1)].getBackground());
            tiles[Integer.parseInt(button2)].setForeground(tiles[Integer.parseInt(button1)].getBackground());
            tiles[Integer.parseInt(button1)].setBackground(tmp);
            tiles[Integer.parseInt(button1)].setForeground(tmp);
            findMatch();
        }
    }

    /**
     * Performs computer move
     * @throws InterruptedException
     */
    void computerMove() throws InterruptedException {

        if (!gameOver) {
            int random = new Random().nextInt(54);

            if (random % 9 != 8) {
                button1 = Integer.toString(random);
                button2 = Integer.toString(random + 1);
            } else {
                if (random < 45) {
                    button1 = Integer.toString(random);
                    button2 = Integer.toString(random + 9);
                } else {
                    button1 = Integer.toString(random);
                    button2 = Integer.toString(random - 9);
                }
            }
            swap();
            button1 = null;
            button2 = null;
            computerTurn = false;
            sp.setMessage("Computer Moved, It's Your Turn");
            sp.update(sp.getGraphics());
        }
    }

    @Override
    public void run() {
        while (!gameOver) {

        }
        sp.setMessage("Game Over!");
        sp.update(sp.getGraphics());
    }

    private class TileActionListener implements ActionListener {
        JButton button;

        public TileActionListener(JButton button) {
            this.button = button;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!computerTurn && !gameOver) {
                if (button1 == null)
                    button1 = button.getText();

                else {
                    button2 = button.getText();
                    try {
                        swap();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    button1 = null;
                    button2 = null;
                    computerTurn = true;
                    try {
                        computerMove();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * Perform character damages
     * @param i is index of tile
     * @throws InterruptedException
     */
    void charDamage(int i) throws InterruptedException {
        double damage = 0;
        if (i % 9 <= 2 && charPanel.getFires()[0] != null) {
            damage = Math.pow((charPanel.getFires()[0].getStrength() / charPanel.getFires()[1].getAgility()), 1.35)*100;
            if (tiles[i].getBackground() == Color.BLUE)
                damage = damage /2;

            if (tiles[i].getBackground() == Color.GREEN)
                damage = damage *2;

            charPanel.getFires()[1].setHealth(charPanel.getFires()[1].getHealth() - damage);
            sp.setMessage(String.format("Character " + charPanel.getFires()[0] + " gave %.2f"+" damage to "+ "Enemy " + charPanel.getFires()[1],damage));
            sp.update(sp.getGraphics());
            Thread.sleep(3000);
            if (charPanel.getFires()[1].getHealth() <= 0){
                charPanel.getFires()[1].removeBg();
                charPanel.update(charPanel.getGraphics());
                sp.setMessage("Enemy died: " + charPanel.getFires()[1]);
                sp.update(sp.getGraphics());
                Thread.sleep(2000);
                charPanel.getFires()[0].updateHealth();
                charPanel.getIces()[0].updateHealth();
                charPanel.getNatures()[0].updateHealth();
                sp.setMessage("Characters health is replenished!");
                sp.update(sp.getGraphics());
                Thread.sleep(3000);
                charPanel.newEnemy(0);
                sp.setMessage("New enemy is respawned: " + charPanel.getFires()[1]);
                sp.update(sp.getGraphics());
            }
        }
        else if (i% 9 <= 5 && charPanel.getIces()[0] != null) {
            damage = Math.pow((charPanel.getIces()[0].getStrength() / charPanel.getIces()[1].getAgility()), 1.35) * 100;
            if (tiles[i].getBackground() == Color.RED)
                damage = damage *2;

            if (tiles[i].getBackground() == Color.GREEN)
                damage = damage /2;

            charPanel.getIces()[1].setHealth(charPanel.getIces()[1].getHealth() - damage);
            sp.setMessage(String.format("Character " + charPanel.getIces()[0] + " gave %.2f"+" damage to "+ "Enemy " + charPanel.getIces()[1],damage));
            sp.update(sp.getGraphics());
            Thread.sleep(3000);
            if (charPanel.getIces()[1].getHealth() <= 0) {
                charPanel.getIces()[1].removeBg();
                charPanel.update(charPanel.getGraphics());
                sp.setMessage("Enemy died: " + charPanel.getIces()[1]);
                sp.update(sp.getGraphics());
                Thread.sleep(2000);
                charPanel.getFires()[0].updateHealth();
                charPanel.getIces()[0].updateHealth();
                charPanel.getNatures()[0].updateHealth();
                sp.setMessage("Characters health is replenished!");
                sp.update(sp.getGraphics());
                Thread.sleep(3000);
                charPanel.newEnemy(1);
                sp.setMessage("New enemy is respawned: " + charPanel.getIces()[1]);
                sp.update(sp.getGraphics());
            }
        }
        else {
            if (charPanel.getNatures()[0] != null)
                damage = Math.pow((charPanel.getNatures()[0].getStrength() / charPanel.getNatures()[1].getAgility()), 1.35)*100;
            if (tiles[i].getBackground() == Color.RED)
                damage = damage /2;

            if (tiles[i].getBackground() == Color.BLUE)
                damage = damage *2;

            charPanel.getNatures()[1].setHealth(charPanel.getNatures()[1].getHealth() - damage);
            sp.setMessage(String.format("Character " + charPanel.getNatures()[0] + " gave %.2f"+" damage to "+ "Enemy " + charPanel.getNatures()[1],damage));
            sp.update(sp.getGraphics());
            Thread.sleep(3000);
            if (charPanel.getNatures()[1].getHealth() <= 0) {
                charPanel.getNatures()[1].removeBg();
                charPanel.update(charPanel.getGraphics());
                sp.setMessage("Enemy died: " + charPanel.getNatures()[1]);
                sp.update(sp.getGraphics());
                Thread.sleep(2000);
                charPanel.getFires()[0].updateHealth();
                charPanel.getIces()[0].updateHealth();
                charPanel.getNatures()[0].updateHealth();
                sp.setMessage("Characters health is replenished!");
                sp.update(sp.getGraphics());
                Thread.sleep(3000);
                charPanel.newEnemy(3);
                sp.setMessage("New enemy is respawned: " + charPanel.getNatures()[1]);
                sp.update(sp.getGraphics());
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Perform enemy damages
     * @param i is index of tile
     * @throws InterruptedException
     */
    void enemyDamage(int i) throws InterruptedException {
        double damage;
        if (i % 9 <= 2 && charPanel.getFires()[0] != null) {
            damage = Math.pow((charPanel.getFires()[1].getStrength() / charPanel.getFires()[0].getAgility()), 1.35)*100;
            if (tiles[i].getBackground() == Color.BLUE)
                damage = damage /2;

            if (tiles[i].getBackground() == Color.GREEN)
                damage = damage *2;

            charPanel.getFires()[0].setHealth(charPanel.getFires()[0].getHealth() - damage);
            sp.setMessage(String.format("Enemy " + charPanel.getFires()[1] + " gave %.2f"+" damage to "+ "Character " + charPanel.getFires()[0],damage));
            sp.update(sp.getGraphics());
            Thread.sleep(3000);
            if (charPanel.getFires()[0].getHealth() <= 0){
                charPanel.getFires()[0].removeBg();
                charPanel.update(charPanel.getGraphics());
                dead++;
                sp.setMessage("Character died:" + charPanel.getFires()[0]);
                charPanel.getFires()[0] = null;
                sp.update(sp.getGraphics());
                Thread.sleep(3000);
            }
        }
        else if (i% 9 <= 5 && charPanel.getIces()[0] != null) {
            damage = Math.pow((charPanel.getIces()[1].getStrength() / charPanel.getIces()[0].getAgility()), 1.35) * 100;
            if (tiles[i].getBackground() == Color.RED)
                damage = damage *2;

            if (tiles[i].getBackground() == Color.GREEN)
                damage = damage /2;

            charPanel.getIces()[0].setHealth(charPanel.getIces()[0].getHealth() - damage);
            sp.setMessage(String.format("Enemy " + charPanel.getIces()[1] + " gave %.2f"+" damage to "+ "Character " + charPanel.getIces()[0],damage));
            sp.update(sp.getGraphics());
            Thread.sleep(3000);
            if (charPanel.getIces()[0].getHealth() <= 0){
                charPanel.getIces()[0].removeBg();
                charPanel.update(charPanel.getGraphics());
                dead++;
                sp.setMessage("Character died:" + charPanel.getIces()[0]);
                charPanel.getIces()[0] = null;
                sp.update(sp.getGraphics());
                Thread.sleep(3000);
            }
        }
        else {
            if (charPanel.getNatures()[0] != null && i%9 >= 6) {
                damage = Math.pow((charPanel.getNatures()[1].getStrength() / charPanel.getNatures()[0].getAgility()), 1.35) * 100;
                if (tiles[i].getBackground() == Color.RED)
                    damage = damage / 2;

                if (tiles[i].getBackground() == Color.BLUE)
                    damage = damage * 2;

                charPanel.getNatures()[0].setHealth(charPanel.getNatures()[0].getHealth() - damage);
                sp.setMessage(String.format("Enemy " + charPanel.getNatures()[1] + " gave %.2f"+" damage to "+ "Character " + charPanel.getNatures()[0],damage));
                sp.update(sp.getGraphics());
                Thread.sleep(3000);
                if (charPanel.getNatures()[0].getHealth() <= 0){
                    charPanel.getNatures()[0].removeBg();
                    charPanel.update(charPanel.getGraphics());
                    dead++;
                    sp.setMessage("Character died:" + charPanel.getNatures()[0]);
                    charPanel.getNatures()[0] = null;
                    sp.update(sp.getGraphics());
                    Thread.sleep(3000);
                }
            }
        }

        if (dead >= 3) {
            gameOver = true;
            sp.setMessage("Game Over!");
            sp.update(sp.getGraphics());
        }
    }

    /**
     * Handles vertical matches
     * @param i index of starting tile of the match
     * @throws InterruptedException
     */
    void verticalMatch(int i) throws InterruptedException {
        tiles[i].setBackground(Color.GRAY);
        tiles[i].setForeground(Color.GRAY);
        tiles[i + 9].setBackground(Color.GRAY);
        tiles[i + 9].setForeground(Color.GRAY);
        tiles[i + 18].setBackground(Color.GRAY);
        tiles[i + 18].setForeground(Color.GRAY);
        this.update(this.getGraphics());
        sp.setMessage("Match Found!");
        sp.update(sp.getGraphics());
        Thread.sleep(1000);
        if (computerTurn) {
            enemyDamage(i);
        }
        else {
           charDamage(i);
        }
    }

    /**
     * Handles horizontal matches
     * @param i index of starting tile of the match
     * @throws InterruptedException
     */
    void horizontalMatch(int i) throws InterruptedException {
        tiles[i].setBackground(Color.GRAY);
        tiles[i].setForeground(Color.GRAY);
        tiles[i + 1].setBackground(Color.GRAY);
        tiles[i + 1].setForeground(Color.GRAY);
        tiles[i + 2].setBackground(Color.GRAY);
        tiles[i + 2].setForeground(Color.GRAY);
        this.update(this.getGraphics());
        sp.setMessage("Match Found!");
        sp.update(sp.getGraphics());
        Thread.sleep(1000);
        if (computerTurn)
            enemyDamage(i);
        else
            charDamage(i);
    }
}
