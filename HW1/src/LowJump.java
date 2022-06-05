public class LowJump implements Jumping{

    private final Rover rover;

    public LowJump(Rover r) {
        rover = r;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void jump() {
       new Thread(this).start();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        for (int i = 0; i <130 ; i++) {
            rover.setY(rover.getY()-1);
        }
        for (int i = 0; i < 150; i++) {
            rover.setX(rover.getX()+1);
        }

        try {
            Thread.sleep(300L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i <130 ; i++) {
            rover.setY(rover.getY()+1);
        }
        for (int i = 0; i < 150; i++) {
            rover.setX(rover.getX()+1);
        }
    }
}
