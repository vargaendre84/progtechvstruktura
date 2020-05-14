package ValutaStrategia;

public abstract class ArfolyamStrategia
{
    protected long nevErtek;
    protected double veteliArfolyam;
    protected double aktualisArfolyam;

    public ArfolyamStrategia(long nevErtek, double veteliArfolyam, double aktualisArfolyam)
    {
        this.nevErtek = nevErtek;
        this.veteliArfolyam = veteliArfolyam;
        this.aktualisArfolyam = aktualisArfolyam;
    }

    public abstract void ArfolyamNyereseg();
}
