package PenzugyiEszkozok;
import KamatozasiVasarlasiStrategia.KamatozasiStrategia;
import KoltsegStrategia.KoltsegStrategia;
import ValutaStrategia.BeszerzesiStrategia;

public class BankBetet extends PenzugyiEszkoz
{
    BeszerzesiStrategia beszerzes;
    KamatozasiStrategia kamat;
    KoltsegStrategia koltseg;
    private String nev;

    public BankBetet(BeszerzesiStrategia beszerzes, KamatozasiStrategia kamat, KoltsegStrategia koltseg, String nev,String tipus)
    {
        super(nev, tipus);
        this.beszerzes = beszerzes;
        this.kamat = kamat;
        this.koltseg = koltseg;
    }

    public void Beszerzes() {beszerzes.Beszerzes();}
    public void Kamatozas() {
        kamat.Kamatozas();
    }
    public void KoltsegSzamitas(){koltseg.KoltsegSzamitas();}
}
