package PenzugyiEszkozok;
import KoltsegStrategia.KoltsegStrategia;
import ValutaStrategia.ArfolyamStrategia;
import ValutaStrategia.BeszerzesiStrategia;

public abstract class Valuta extends PenzugyiEszkoz implements IValuta
{
    public Valuta(String nev, String tipus)
    {
        super(nev,tipus);
    }

    public abstract void Beszerzes();
    public abstract void ArfolyamNyereseg();
    public abstract void KoltsegSzamitas();
}
