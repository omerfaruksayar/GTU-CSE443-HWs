import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class GamePanel extends Panel implements Runnable {

    private Thread t;
    private final BottomPanel bottomPanel;
    private final JButton play = new JButton("Play");
    private final JButton pause = new JButton("Pause");
    private final JButton restart = new JButton("Restart");
    private final Background background1 = new Background(0,0,2);
    private final Background background2 = new Background(getWidth(),0,2);
    private final Rover rover = new Rover(50, 600,0);
    private CopyOnWriteArrayList<Blackhole> holes = new CopyOnWriteArrayList<>();
    private final PowerUp p = new PowerUp(getWidth(),getHeight() - 350, 2);
    private int life = 3;
    private int framesCount = 0;
    private int framesCountAvg=0;
    private long framesTimer=0;
    private int score = 0;
    private Score s = new GameScore();
    private boolean running = true;

    /**
     * Constructor of the Game Panel which is the panel that playing the game
     * @param height is height of the panel
     * @param width is width of the panel
     */
    public GamePanel(int height, int width) {
        super(height,width);
        bottomPanel = new BottomPanel(80, getWidth(),"Game Started!");
        Action jumpAction = new JumpAction();
        Action moveAction = new MoveAction();
        this.getInputMap().put(KeyStroke.getKeyStroke('d'),"moveAction");
        this.getActionMap().put("moveAction", moveAction);
        this.getInputMap().put(KeyStroke.getKeyStroke(' '), "jumpAction");
        this.getActionMap().put("jumpAction", jumpAction);
        play.addActionListener(e -> {
            running = true;
            this.requestFocusInWindow();
        });

        pause.addActionListener(e -> {
            running = false;
            this.requestFocusInWindow();
        });

        restart.addActionListener(e -> {
            init();
            running = true;
            this.requestFocusInWindow();
            t = new Thread(GamePanel.this);
            t.start();
        });

        bottomPanel.add(play);
        bottomPanel.add(pause);
        bottomPanel.add(restart);
    }

    private void init(){
        life = 3;
        rover.setX(50);
        rover.setY(600);
        score = 0;
        framesCount = 0;
        framesCountAvg=0;
        framesTimer=0;
        rover.setJumping(new LowJump(rover));
        s = new GameScore();
        holes = new CopyOnWriteArrayList<>();
        p.setX(getWidth());
        bottomPanel.setMessage("Game Started!");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addNotify(){
        super.addNotify();
        if (t == null)
            t = new Thread(GamePanel.this);
        t.start();
    }

    /**
     * Getter for bottom panel
     * @return the bottom panel
     */
    public BottomPanel getBottomPanel() {
        return bottomPanel;
    }

    /**
     * It updates the position of the black holes
     */
    public void updateHoles(){
        if (holes.size() < 2){
            for (int i = 0; i < new Random().nextInt(3); i++) {
                holes.add(new Blackhole(getWidth()+ new Random().ints(0,500).findFirst().getAsInt(),790,0));
            }
        }
        for (int i = 0; i < holes.size()-1; i++) {
            if (holes.get(i).getX() - holes.get(i+1).getX() > -250)
                holes.remove(holes.get(i));
        }
        holes.removeIf(b -> b.getX() <= -100);
    }

    /**
     * It updates the position of the power ups.
     */
    public void updatePowerUp(){
        if (score % 250 == 0 && score != 0){
            p.move();
            score += 50;
        }
        if (p.getX() >= -100 && p.getX() < getWidth())
            p.move();

        if (p.getX() < -100)
            p.setX(getWidth());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        while (life > 0) {
            long start = System.currentTimeMillis();
            if (running) {
                updateHoles();
                updatePowerUp();
                checkIntersects();
            }
            bottomPanel.repaint();
            repaint();
            long end = System.currentTimeMillis() - start;
            int fps = 500;
            long ms = 1000L;
            framesCount++;
            if (start-framesTimer>1000){
                framesTimer = start;
                framesCountAvg = framesCount;
                framesCount = 0;
            }
            long wait = (ms / fps) - end / ms;
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * It checks if there is any collision between obstacles and the rover and also checks if the rover catches the power ups.
     */
    public void checkIntersects(){
        if (holes.size() != 0) {
            for (Blackhole b : holes) {
                if (rover.getBounds().intersects(b.getBounds())) {
                    if (life > 1) {
                        life = life - 1;
                        bottomPanel.setMessage("You have " + life + " life left!");
                        holes.remove(b);
                    } else {
                        life = life - 1;
                        bottomPanel.setMessage("Game over!");
                    }
                }
            }
        }

        if (rover.getBounds().intersects(p.getBounds())){
            switch (p.power()){
                case 0:
                    bottomPanel.setMessage("You got powerup A : *2 points!");
                    s = new DecoratorA(s);
                    break;
                case 1:
                    bottomPanel.setMessage("You got powerup B : *5 points!");
                    s = new DecoratorB(s);
                    break;

                case 2:
                    bottomPanel.setMessage("You got powerup C : *10 points!");
                    s = new DecoratorC(s);
                    break;

                default:
                    bottomPanel.setMessage("You got high jump!");
                    rover.setJumping(new HighJump(rover));
                    break;
            }
            p.setX(getWidth());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void printToScreen(Graphics2D g) {
        background1.draw(g);
        background2.draw(g);
        rover.draw(g);
        for (Blackhole b: holes) {
            b.draw(g);
        }
        if (p != null)
            p.draw(g);

        g.setColor(Color.WHITE);
        g.setFont(new Font("default", Font.BOLD,24));
        g.drawString("Score: " + score,getWidth()- 200,50);
        g.drawString("FPS: " + framesCountAvg,200, 50);
    }

    public class MoveAction extends AbstractAction{

        /**
         * {@inheritDoc}
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            if (running) {
                for (Blackhole b : holes)
                    b.move();

                if (rover.getX() > 50)
                    rover.setX(rover.getX() - 10);

                if (background1.getX() != -getWidth() && background2.getX() != -getWidth()) {
                    background1.moveLeft();
                    background2.moveLeft();
                } else if (background1.getX() == -getWidth())
                    background1.setX(getWidth());

                else if (background2.getX() == -getWidth())
                    background2.setX(getWidth());
            }
        }
    }

    public class JumpAction extends AbstractAction {

        /**
         * {@inheritDoc}
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (running) {
                if (rover.getY() == 600) {
                    rover.jump();
                    for (Blackhole b : holes) {
                        if (rover.getJumping() instanceof LowJump) {
                            if (rover.getX() + 300 > b.getX() + 120) {
                                score += s.calculatePoint();
                                bottomPanel.setMessage("You earned " + s.calculatePoint() + " points!");
                            }
                        } else {
                            if (rover.getX() + 400 > b.getX() + 120) {
                                score += s.calculatePoint();
                                bottomPanel.setMessage("You earned " + s.calculatePoint() + " points!");
                            }
                        }
                    }
                }
            }
        }
    }
}
