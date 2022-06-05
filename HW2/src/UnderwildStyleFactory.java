public class UnderwildStyleFactory implements CharFactory{
    @Override
    public Fire createFire() {
        return new UnderwildFire();
    }

    @Override
    public Ice createIce() {
        return new UnderwildIce();
    }

    @Override
    public Nature createNature() {
        return new UnderwildNature();
    }
}
