public class GetCommand implements Command{
    public GetCommand(BestDSEver bds) {
        this.bds = bds;
    }

    BestDSEver bds;

    /**
     * {@inheritDoc}
     */
    @Override
    public Object execute(int index) {
        synchronized (this){
            return bds.get(index);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(Object o) {

    }
}
