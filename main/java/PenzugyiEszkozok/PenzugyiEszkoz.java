package PenzugyiEszkozok;

public abstract class PenzugyiEszkoz
{
    protected String nev;
    protected String tipus;

    public PenzugyiEszkoz(String nev, String tipus)
    {
        this.nev = nev;
        this.tipus = tipus;
    }

    public String getNev()
    {
        return nev;
    }
    public void setNev(String nev)
    {
        this.nev = nev;
    }
    public String getTipus()
    {
        return tipus;
    }
}
