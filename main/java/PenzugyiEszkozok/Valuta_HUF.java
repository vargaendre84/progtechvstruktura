package PenzugyiEszkozok;
import KoltsegStrategia.KoltsegStrategia;
import ValutaStrategia.BeszerzesiStrategia;

public class Valuta_HUF extends Valuta
{
    BeszerzesiStrategia beszerzes;
    KoltsegStrategia koltseg;

    public Valuta_HUF(BeszerzesiStrategia beszerzes, KoltsegStrategia koltseg, String nev, String tipus)
    {
        super(nev,tipus);
        this.beszerzes = beszerzes;
        this.koltseg = koltseg;
    }
    @Override
    public void Beszerzes() { beszerzes.Beszerzes(); }
    @Override
    public void ArfolyamNyereseg(){}
    @Override
    public void KoltsegSzamitas(){koltseg.KoltsegSzamitas();}
}
