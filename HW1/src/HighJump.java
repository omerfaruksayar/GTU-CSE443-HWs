public class HighJump implements Jumping{

    private final Rover rover;

    public HighJump(Rover r) {
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
        for (int i = 0; i <180 ; i++) {
            rover.setY(rover.getY()-1);
        }
        for (int i = 0; i < 200; i++) {
            rover.setX(rover.getX()+1);
        }

        try {
            Thread.sleep(300L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i <180 ; i++) {
            rover.setY(rover.getY()+1);
        }
        for (int i = 0; i < 200; i++) {
            rover.setX(rover.getX()+1);
        }

    }
}
