public class DecoratorC extends ScoreDecorator {

    public DecoratorC(Score s) {
        super(s);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int calculatePoint() {
        return s.calculatePoint()*10;
    }
}
