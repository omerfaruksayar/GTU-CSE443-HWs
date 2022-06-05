public abstract class ScoreDecorator extends Score{

    Score s;

    /**
     * Constructor for the score decorator.
     * @param s is the Score that will be used to decorate.
     */
    public ScoreDecorator(Score s) {
        this.s = s;
    }
}
