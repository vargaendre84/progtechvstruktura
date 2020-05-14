package PenzugyiEszkozok;
import KoltsegStrategia.KoltsegStrategia;
import ValutaStrategia.ArfolyamStrategia;
import ValutaStrategia.BeszerzesiStrategia;

public class Kripto_Ethereum extends KriptoValuta
{
    BeszerzesiStrategia beszerzes;
    ArfolyamStrategia arfolyam;
    KoltsegStrategia koltseg;

    public Kripto_Ethereum(BeszerzesiStrategia beszerzes, ArfolyamStrategia arfolyam,KoltsegStrategia koltseg, String nev, String tipus)
    {
        super(nev, tipus);
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

    @Override
    public Object Clone()
    {
        Kripto_Ethereum uj = new Kripto_Ethereum(beszerzes,arfolyam,koltseg,nev,tipus);
        uj.nev = nev;
        return uj;
    }
}
