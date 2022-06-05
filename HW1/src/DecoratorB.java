public class DecoratorB extends ScoreDecorator {

    public DecoratorB(Score s) {
        super(s);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int calculatePoint() {
        return s.calculatePoint()*5;
    }
}