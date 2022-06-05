public class InsertCommand implements Command{

    public InsertCommand(BestDSEver bds) {
        this.bds = bds;
    }

    BestDSEver bds;

    /**
     * {@inheritDoc}
     */
    @Override
    public Object execute(int index) {
        return null;
    }

    @Override

    /**
     * {@inheritDoc}
     */
    public void execute(Object o) {
        synchronized (this) {
            bds.insert(o);
        }
    }
}
