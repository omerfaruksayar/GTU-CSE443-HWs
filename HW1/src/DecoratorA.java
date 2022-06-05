public class DecoratorA extends ScoreDecorator {
    public DecoratorA(Score s) {
        super(s);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int calculatePoint() {
        return s.calculatePoint()*2;
    }
}
