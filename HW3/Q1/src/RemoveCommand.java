public class RemoveCommand implements Command{

    public RemoveCommand(BestDSEver bsd) {
        this.bsd = bsd;
    }

    BestDSEver bsd;

    /**
     * {@inheritDoc}
     */
    @Override
    public Object execute(int index) {
        return null;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Object o) {
        synchronized (this) {
            bsd.remove(o);
        }
    }
}
