public class ValhallaStyleFactory implements CharFactory{

    @Override
    public Fire createFire() {
        return new ValhallaFire();
    }

    @Override
    public Ice createIce() {
        return new ValhallaIce();
    }

    @Override
    public Nature createNature() {
        return new ValhallaNature();
    }
}
