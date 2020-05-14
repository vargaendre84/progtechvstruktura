package KoltsegStrategia;

public abstract class KoltsegStrategia
{
    protected long nevErtek;
    protected int futamIdo;

    public KoltsegStrategia(long nevErtek, int futamIdo)
    {
        this.nevErtek = nevErtek;
        this.futamIdo = futamIdo;
    }

    public abstract void KoltsegSzamitas();
}
