public class AtlantisStyleFactory implements CharFactory{
    @Override
    public Fire createFire() {
        return new AtlantisFire();
    }

    @Override
    public Ice createIce() {
        return new AtlantisIce();
    }

    @Override
    public Nature createNature() {
        return new AtlantisNature();
    }
}
