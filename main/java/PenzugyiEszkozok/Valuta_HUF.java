package PenzugyiEszkozok;
import KoltsegStrategia.KoltsegStrategia;
import ValutaStrategia.ArfolyamStrategia;
import ValutaStrategia.BeszerzesiStrategia;

public class Valuta_HUF extends Valuta
{
    BeszerzesiStrategia beszerzes;
    ArfolyamStrategia arfolyam;
    KoltsegStrategia koltseg;

    public Valuta_HUF(BeszerzesiStrategia beszerzes, ArfolyamStrategia arfolyam, KoltsegStrategia koltseg, String nev, String tipus)
    {
        super(nev,tipus);
        this.beszerzes = beszerzes;
        this.arfolyam = arfolyam;
        this.koltseg = koltseg;
    }
    @Override
    public void Beszerzes() { beszerzes.Beszerzes(); }
    @Override
    public void ArfolyamNyereseg(){arfolyam.ArfolyamNyereseg();}
    @Override
    public void KoltsegSzamitas(){koltseg.KoltsegSzamitas();}
}
