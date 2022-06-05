import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CharBoard extends JPanel {

    private Fire[] fires = new Fire[2];
    private Ice[] ices = new Ice[2];
    private Nature[] natures = new Nature[2];
    AtlantisStyleFactory asf = new AtlantisStyleFactory();
    ValhallaStyleFactory vsf = new ValhallaStyleFactory();
    UnderwildStyleFactory usf = new UnderwildStyleFactory();

    /**
     * Constructor for Char/Enemy Board
     * @param width is width of the board.
     * @param height is height of the board.
     */
    public CharBoard(int width, int height) {
        super(new GridLayout(2,3,5,10));
        this.setPreferredSize(new Dimension(width,height));
        this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        initChar();
        for (int i = 0; i < 2; i++) {
            add((Component) fires[i]);
            add((Component) ices[i]);
            add((Component) natures[i]);
        }
    }

    /**
     * Generates random Chars/enemies
     */
    void initChar(){
        for (int i = 0; i < 2; i++) {
            int random = new Random().nextInt(3);
            if (fires[i] == null){
                if (random == 0)
                    fires[i] = asf.createFire();

                else if (random == 1)
                    fires[i] = vsf.createFire();

                else
                    fires[i] = usf.createFire();
            }

            if (ices[i] == null){
                if (random == 0)
                    ices[i] = asf.createIce();

                else if (random == 1)
                    ices[i] = vsf.createIce();

                else
                    ices[i] = usf.createIce();
            }

            if (natures[i] == null){
                if (random == 0)
                    natures[i] = asf.createNature();

                else if (random == 1)
                    natures[i] = vsf.createNature();

                else
                    natures[i] = usf.createNature();
            }
        }
    }

    /**
     * Create a new enemy
     * @param e is controller for type of the enemy
     */
    void newEnemy(int e){
        int random = new Random().nextInt(3);
        if (e == 0){
            remove(3);
            revalidate();
            repaint();

            if (random == 0)
                fires[1] = asf.createFire();

            else if (random == 1)
                fires[1] = vsf.createFire();

            else
                fires[1] = usf.createFire();

            add((Component)fires[1],3);
            revalidate();
            repaint();
        }

        if (e == 1){
            this.remove(4);
            this.revalidate();
            this.repaint();

            if (random == 0)
                ices[1] = asf.createIce();

            else if (random == 1)
                ices[1] = vsf.createIce();

            else
                ices[1] = usf.createIce();

            this.add((Component) ices[1],4);
            this.revalidate();
            this.repaint();
        }

        if (e == 2){
            this.remove(5);
            this.revalidate();
            this.repaint();

            if (random == 0)
                natures[1] = asf.createNature();

            else if (random == 1)
                natures[1] = vsf.createNature();

            else
                natures[1] = usf.createNature();


            this.add((Component) natures[1],5);
            this.revalidate();
            this.repaint();
        }
    }

    /**
     * Getter for fires array
     * @return Fire array
     */
    public Fire[] getFires() {
        return fires;
    }

    /**
     * Getter for Ices array
     * @return Ice array
     */
    public Ice[] getIces() {
        return ices;
    }

    /**
     * Getter for Natures array
     * @return Nature array
     */
    public Nature[] getNatures() {
        return natures;
    }
}
